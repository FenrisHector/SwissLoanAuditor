package backend;

/**
 * Simulates a Bank's automated decision engine.
 * WARNING: This class contains INTENTIONAL BIAS logic for auditing
 * demonstration purposes.
 * It is the 'black box' under investigation.
 */

public class LoanOfficer {

    //Returns TRUE if approved (score >= 50), FALSE if rejected.
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


        // Discriminatory Rules

        // Nationality Discrimination
        // Unfair bonus for Swiss citizens vs others
        if (person.getNationality().equals("Swiss")) {
            score += 15;
        }

        // Regional Discrimination, penalizing 'Ticino' canton perceived as higher risk
        if (person.getCanton().equals("TI")) {
            score -= 10;
        }

        // Penalizing young people (< 25)
        if (person.getAge() < 25) {
            score -= 5;
        }

        // Approval Threshold (requires 50 points to pass)
        return score >= 50;
    }
}
