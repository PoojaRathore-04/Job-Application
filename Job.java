package model;
import java.io.Serializable;
import java.util.Objects;

public class Job implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String jobId, title, department;
    private final int minExperience;

    public Job(String jobId, String title, String department, int minExperience) {
        this.jobId = jobId;
        this.title = title;
        this.department = department;
        this.minExperience = minExperience;
    }

    // Getters
    public String getJobId() { return jobId; }
    public String getTitle() { return title; }
    public String getDepartment() { return department; }
    public int getMinExperience() { return minExperience; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return jobId.equals(job.jobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId);
    }

    @Override
    public String toString() {
        return "Job{jobId='" + jobId + "', title='" + title + "', dept='" + department + "', minExp=" + minExperience + "}";
    }
}
