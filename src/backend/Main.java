package backend;

import java.io.File;
import java.net.URL;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // JavaFX entry point: Loads the graphical interface
    @Override
    public void start(Stage primaryStage) throws Exception {

        new ui.AuditController();

        // 1. Locate the FXML file
        File fxmlFile = new File("src/ui/AuditView.fxml");
        URL fxmlUrl = fxmlFile.toURI().toURL();

        // 2. Create the FXMLLoader
        FXMLLoader loader = new FXMLLoader(fxmlUrl);

        // 3. Set the class loader
        loader.setClassLoader(getClass().getClassLoader());

        // 4. Load the FXML and get the root node
        Parent root = loader.load();

        primaryStage.setTitle("Swiss Loan Fairness Auditor");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

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

        // Start the JavaFX application lifecycle
        launch(args);
    }
}
