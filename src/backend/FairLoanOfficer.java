package backend;

//The 'Control Group' decision engine. This model contains ONLY the fair, acting without discrimination

public class FairLoanOfficer {

    // Returns TRUE if approved (score >= 50), FALSE if rejected.
    public boolean evaluateLoan(Applicant person) {
        int score = 0;

        // High income adds points
        if (person.getIncome() > 100000)
            score += 30;
        else if (person.getIncome() > 60000)
            score += 15;

        // Good credit score adds points
        if (person.getCreditScore() > 700)
            score += 40;
        else if (person.getCreditScore() > 600)
            score += 20;

        // Approval Threshold (requires 50 points to pass)
        return score >= 50;
    }
}
