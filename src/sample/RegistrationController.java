package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.*;

public class RegistrationController {
    @FXML private TextField username;
    @FXML private PasswordField password1;
    @FXML private PasswordField password2;
    @FXML private TextField email;
    @FXML private TextField roll;

    public void showRegistrationForm(ActionEvent actionEvent) throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("registration.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }
    private boolean validateRoll(String roll){
        try{
            int iRoll = Integer.parseInt(roll);
            if(roll.length() == 7){
                return true;
            }
        }catch (NumberFormatException e){
            return false;
        }
        return false;
    }
    private boolean validatePassword(String password){
        return password.length() >= 5;
    }
    private boolean matchPassword(String pw1, String pw2){
        return pw1.equals(pw2);
    }
    @FXML
    public void doRegister(ActionEvent actionEvent) {
        String username = this.username.getText().toString();
        String roll = this.roll.getText().toString();
        String pw1 = this.password1.getText().toString();
        String pw2 = this.password2.getText().toString();
        String email = this.email.getText().toString();

        if(!(this.validateRoll(roll) && this.validatePassword(pw1) && this.matchPassword(pw1, pw2))){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Something is missing");
            alert.showAndWait();
            return;
        }
        String statement = "INSERT INTO user_info(username, email, password, roll, role) VALUES(?,?,?,?,?)";
        String connectionUrl = "jdbc:mysql://localhost/course_registration_system";

        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "root", "");
            PreparedStatement preparedStmt = conn.prepareStatement(statement);
            preparedStmt.setString(1, username);
            preparedStmt.setString(2, email);
            preparedStmt.setString(3, pw1);
            preparedStmt.setInt(4, Integer.parseInt(roll));
            preparedStmt.setString(5, "student");
            preparedStmt.execute();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Account created");
            alert.setHeaderText("Success");
            alert.setContentText("Now you are registered");
            alert.showAndWait();
//            ResultSet rs = preparedStmt.executeQuery()){
//                System.out.println("Connected!");
//
////            while (rs.next()) {
//////                long id = rs.getLong("ID");
//////                String name = rs.getString("FIRST_NAME");
//////                String lastName = rs.getString("LAST_NAME");
////
////                // do something with the extracted data...
////            }
//            }
        }catch (SQLException e) {
            // handle the exception
            e.printStackTrace();
        }
    }
}
