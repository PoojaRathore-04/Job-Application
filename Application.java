package model;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Application implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String applicationId;
    private final Candidate candidate;
    private final Job job;
    private final LocalDate applicationDate;
    private ApplicationStatus status;

    public Application(String applicationId, Candidate candidate, Job job, ApplicationStatus status) {
        this.applicationId = applicationId;
        this.candidate = candidate;
        this.job = job;
        this.applicationDate = LocalDate.now();
        this.status = status;
    }

    // Getters & Setters
    public String getApplicationId() { return applicationId; }
    public Candidate getCandidate() { return candidate; }
    public Job getJob() { return job; }
    public LocalDate getApplicationDate() { return applicationDate; }
    public ApplicationStatus getStatus() { return status; }
    public void setStatus(ApplicationStatus status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return applicationId.equals(that.applicationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationId);
    }

    @Override
    public String toString() {
        return "Application{appId='" + applicationId + "', cand=" + candidate.getName() + 
               ", job=" + job.getTitle() + ", status=" + status + ", date=" + applicationDate + "}";
    }
}
