package model;

public enum ApplicationStatus {
    APPLIED, SHORTLISTED, INTERVIEW_SCHEDULED, REJECTED, HIRED;

    public boolean canTransitionTo(ApplicationStatus next) {
        return switch (this) {
            case APPLIED -> next == SHORTLISTED || next == REJECTED;
            case SHORTLISTED -> next == INTERVIEW_SCHEDULED || next == REJECTED;
            case INTERVIEW_SCHEDULED -> next == HIRED || next == REJECTED;
            case REJECTED, HIRED -> false;
        };
    }
}
