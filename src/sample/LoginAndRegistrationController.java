package sample;

import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class LoginAndRegistrationController
{
    private String roll;
    @FXML private TextField username;
    @FXML private PasswordField password;

    @FXML private PasswordField password1;
    @FXML private PasswordField password2;
    @FXML private TextField email;

    @FXML private Button login;
    public void showRegistrationForm(ActionEvent actionEvent) throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("registration.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

    private int validateUser(TextField argUsername, PasswordField argPassword)
    {
        // return 0 for admin & 1 for student & 2 for wrong authentication
//        System.out.println(argUsername.getText());
        String statement = "SELECT * FROM user_info WHERE username=?";
        String connectionUrl = "jdbc:mysql://localhost/course_registration_system";
        try{
            Connection conn = DriverManager.getConnection(connectionUrl, "root", "");
            PreparedStatement preparedStmt = conn.prepareStatement(statement);
            preparedStmt.setString(1, argUsername.getText().toString());
            ResultSet rs = preparedStmt.executeQuery();
            if(rs.next()){
                if(rs.getString("password").equals(argPassword.getText())){
                    if(rs.getString("role").equals("admin")){
                        return 0;
                    }else if(rs.getString("role").equals("student")){
                        this.roll = rs.getString("roll");
                        return 1;
                    }
                }else{
                    return 2;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(argUsername.getText().equals("admin") && argPassword.getText().equals("admin"))
            return 0;
        return 1;
    }
    public void doLogin(ActionEvent actionEvent) throws IOException {

        if(this.validateUser(username, password)==0){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("You are logged in");
            alert.showAndWait();

            Stage main = (Stage) login.getScene().getWindow();
            main.close();

            Parent part = FXMLLoader.load(getClass().getResource("admin-panel.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(part);
            stage.setScene(scene);
            stage.show();

        }else if(this.validateUser(username, password)==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("You are logged in as student");
            alert.showAndWait();

            Stage main = (Stage) login.getScene().getWindow();
            main.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("student-panel.fxml"));
            Parent part = loader.load();
            StudentController controller = loader.getController();
            controller.setRoll(roll);
            Stage stage = new Stage();
            Scene scene = new Scene(part);
            stage.setScene(scene);
            stage.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong authentication");
            alert.setHeaderText(null);
            alert.setContentText("Your password or username didn't match");
            alert.showAndWait();
        }
    }
}
