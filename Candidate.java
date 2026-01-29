package model;
import java.io.Serializable;
import java.util.Objects;

public class Candidate implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String id, name, email, phone;
    private final int experienceYears;

    public Candidate(String id, String name, String email, String phone, int experienceYears) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.experienceYears = experienceYears;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public int getExperienceYears() { return experienceYears; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return id.equals(candidate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Candidate{id='" + id + "', name='" + name + "', exp=" + experienceYears + "}";
    }
}
