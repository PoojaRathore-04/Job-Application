package util;
import java.io.*;
import java.util.HashMap;

public class FileHandler {
    private static final String CAND_FILE = "candidates.ser";
    private static final String JOBS_FILE = "jobs.ser";
    private static final String APPS_FILE = "applications.ser";

    public static void saveCandidates(HashMap<String, ?> map) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CAND_FILE))) {
            oos.writeObject(map);
        }
    }

    @SuppressWarnings("unchecked")
    public static <K,V> HashMap<K,V> loadCandidates() throws IOException, ClassNotFoundException {
        File f = new File(CAND_FILE);
        if (!f.exists()) return new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (HashMap<K,V>) ois.readObject();
        }
    }

    // Similar methods for saveJobs/loadJobs, saveApps/loadApps
    public static void saveJobs(HashMap<String, ?> map) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(JOBS_FILE))) {
            oos.writeObject(map);
        }
    }

    @SuppressWarnings("unchecked")
    public static <K,V> HashMap<K,V> loadJobs() throws IOException, ClassNotFoundException {
        File f = new File(JOBS_FILE);
        if (!f.exists()) return new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (HashMap<K,V>) ois.readObject();
        }
    }

    public static void saveApplications(HashMap<String, ?> map) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(APPS_FILE))) {
            oos.writeObject(map);
        }
    }

    @SuppressWarnings("unchecked")
    public static <K,V> HashMap<K,V> loadApplications() throws IOException, ClassNotFoundException {
        File f = new File(APPS_FILE);
        if (!f.exists()) return new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (HashMap<K,V>) ois.readObject();
        }
    }
}
