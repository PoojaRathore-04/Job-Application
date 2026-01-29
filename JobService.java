package service;
import model.Job;
import java.util.HashMap;

public class JobService {
    private final HashMap<String, Job> jobs = new HashMap<>();

    public void addJob(Job job) {
        if (jobs.containsKey(job.getJobId())) {
            throw new IllegalArgumentException("Job ID already exists");
        }
        jobs.put(job.getJobId(), job);
    }

    public Job getJob(String jobId) {
        return jobs.get(jobId);
    }

    public HashMap<String, Job> getAll() {
        return new HashMap<>(jobs);
    }
}
