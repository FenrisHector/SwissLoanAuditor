package backend;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Swiss Loan Auditor System Initialized.");

        // Initialize components
        DatabaseManager dbManager = new DatabaseManager();
        LoanOfficer biasedOfficer = new LoanOfficer();
        FairLoanOfficer fairOfficer = new FairLoanOfficer();
        DataGenerator generator = new DataGenerator();

        // Initialize database
        dbManager.initializeDatabase();

        // Generate synthetic applicant data
        List<Applicant> applicants = generator.generateApplicants(1000);

        // Save audit results to the database
        System.out.println("Running 1000 evaluations and saving results...");
        dbManager.saveAuditResults(applicants, biasedOfficer, fairOfficer);

        System.out.println("Audit process completed. Results stored in database/audit_records.db");
    }
}
