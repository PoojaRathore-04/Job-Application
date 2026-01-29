package service;
import model.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ApplicationService {
    private final HashMap<String, Application> applications = new HashMap<>();
    private final CandidateService candidateService;
    private final JobService jobService;

    public ApplicationService(CandidateService cs, JobService js) {
        this.candidateService = cs;
        this.jobService = js;
    }

    public void applyForJob(String appId, String candId, String jobId) {
        Candidate cand = candidateService.getCandidate(candId);
        Job job = jobService.getJob(jobId);
        if (cand == null) throw new IllegalArgumentException("Candidate not found");
        if (job == null) throw new IllegalArgumentException("Job not found");

        // Check duplicate
        for (Application app : applications.values()) {
            if (app.getCandidate().getId().equals(candId) && app.getJob().getJobId().equals(jobId)) {
                throw new IllegalStateException("Candidate already applied for this job");
            }
        }

        // Auto reject if underqualified
        ApplicationStatus status = (cand.getExperienceYears() < job.getMinExperience()) ? 
                                   ApplicationStatus.REJECTED : ApplicationStatus.APPLIED;
        Application app = new Application(appId, cand, job, status);
        if (applications.containsKey(appId)) {
            throw new IllegalArgumentException("Application ID already exists");
        }
        applications.put(appId, app);
    }

    public void updateStatus(String appId, ApplicationStatus newStatus) {
        Application app = applications.get(appId);
        if (app == null) throw new IllegalArgumentException("Application not found");
        if (!app.getStatus().canTransitionTo(newStatus)) {
            throw new IllegalStateException("Invalid status transition from " + app.getStatus() + " to " + newStatus);
        }
        app.setStatus(newStatus);
    }

    public List<Application> getByStatus(ApplicationStatus status) {
        return applications.values().stream()
                           .filter(a -> a.getStatus() == status)
                           .collect(Collectors.toList());
    }

    public List<Application> getByCandidate(String candId) {
        return applications.values().stream()
                           .filter(a -> a.getCandidate().getId().equals(candId))
                           .collect(Collectors.toList());
    }

    public HashMap<String, Application> getAll() {
        return new HashMap<>(applications);
    }
}
