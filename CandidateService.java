package service;
import model.Candidate;
import java.util.HashMap;

public class CandidateService {
    private final HashMap<String, Candidate> candidates = new HashMap<>();

    public void addCandidate(Candidate candidate) {
        if (candidates.containsKey(candidate.getId())) {
            throw new IllegalArgumentException("Candidate ID already exists");
        }
        candidates.put(candidate.getId(), candidate);
    }

    public Candidate getCandidate(String id) {
        return candidates.get(id);
    }

    public HashMap<String, Candidate> getAll() {
        return new HashMap<>(candidates);
    }
}
