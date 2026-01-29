import java.io.IOException;
import java.util.*;
import model.*;
import service.*;
import util.FileHandler;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final CandidateService candService = new CandidateService();
    private static final JobService jobService = new JobService();
    private static final ApplicationService appService = new ApplicationService(candService, jobService);

    public static void main(String[] args) {
        loadData();
        boolean running = true;
        while (running) {
            showMenu();
            try {
                int choice = Integer.parseInt(sc.nextLine());
                handleChoice(choice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
        saveData();
        sc.close();
    }

    private static void showMenu() {
        System.out.println("\n=== Job Application Tracker ===");
        System.out.println("1. Add Candidate");
        System.out.println("2. Add Job Opening");
        System.out.println("3. Apply for Job");
        System.out.println("4. Update Application Status");
        System.out.println("5. View Applications by Status");
        System.out.println("6. View Candidate History");
        System.out.println("7. Save & Exit");
        System.out.print("Choose: ");
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1 -> addCandidate();
            case 2 -> addJob();
            case 3 -> applyJob();
            case 4 -> updateStatus();
            case 5 -> viewByStatus();
            case 6 -> viewCandidateHistory();
            case 7 -> {
                System.out.println("Saving and exiting...");
                System.exit(0);
            }
            default -> System.out.println("Invalid choice!");
        }
    }

    private static void addCandidate() {
        System.out.print("ID: "); String id = sc.nextLine();
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Phone: "); String phone = sc.nextLine();
        System.out.print("Experience Years: "); int exp = Integer.parseInt(sc.nextLine());
        try {
            candService.addCandidate(new Candidate(id, name, email, phone, exp));
            System.out.println("Candidate added!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addJob() {
        System.out.print("Job ID: "); String id = sc.nextLine();
        System.out.print("Title: "); String title = sc.nextLine();
        System.out.print("Department: "); String dept = sc.nextLine();
        System.out.print("Min Experience: "); int minExp = Integer.parseInt(sc.nextLine());
        try {
            jobService.addJob(new Job(id, title, dept, minExp));
            System.out.println("Job added!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void applyJob() {
        System.out.print("App ID: "); String appId = sc.nextLine();
        System.out.print("Candidate ID: "); String candId = sc.nextLine();
        System.out.print("Job ID: "); String jobId = sc.nextLine();
        try {
            appService.applyForJob(appId, candId, jobId);
            System.out.println("Applied successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void updateStatus() {
        System.out.print("App ID: "); String appId = sc.nextLine();
        System.out.print("New Status (APPLIED/SHORTLISTED/INTERVIEW_SCHEDULED/REJECTED/HIRED): ");
        try {
            ApplicationStatus status = ApplicationStatus.valueOf(sc.nextLine().toUpperCase());
            appService.updateStatus(appId, status);
            System.out.println("Status updated!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewByStatus() {
        System.out.print("Status: "); String s = sc.nextLine().toUpperCase();
        try {
            ApplicationStatus status = ApplicationStatus.valueOf(s);
            appService.getByStatus(status).forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status.");
        }
    }

    private static void viewCandidateHistory() {
        System.out.print("Candidate ID: "); String candId = sc.nextLine();
        appService.getByCandidate(candId).forEach(System.out::println);
    }

    private static void loadData() {
        try {
            candService.getAll().putAll(FileHandler.loadCandidates());
            jobService.getAll().putAll(FileHandler.loadJobs());
            appService.getAll().putAll(FileHandler.loadApplications());
            System.out.println("Data loaded from files.");
        } catch (Exception e) {
            System.out.println("No previous data or load error.");
        }
    }

    private static void saveData() {
        try {
            FileHandler.saveCandidates(candService.getAll());
            FileHandler.saveJobs(jobService.getAll());
            FileHandler.saveApplications(appService.getAll());
        } catch (IOException e) {
            System.err.println("Save failed: " + e.getMessage());
        }
    }
}
