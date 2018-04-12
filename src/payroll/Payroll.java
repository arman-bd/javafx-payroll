package payroll;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 * @project Payroll Manager
 * @author Arman Hossain [ arman.hossain.bd93@gmail.com ]
 * @version 1.0.0
 */

public class Payroll extends Application {
    
    static Connection conn = null;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/java_app";
            String username = "root";
            String password = "";

            try {
                conn = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Database");
                alert.setHeaderText("Connection Error");
                alert.setContentText("Cannot Connect To Database!");
                alert.showAndWait();
                throw new IllegalStateException("Cannot connect the database!", e);
            }
            
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
        
        Parent root = FXMLLoader.load(getClass().getResource("Payroll.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Payroll Manager Application");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}