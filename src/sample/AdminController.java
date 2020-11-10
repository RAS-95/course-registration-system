package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
public class AdminController {
    @FXML private ChoiceBox deptListChoiceBox;
    @FXML private ChoiceBox yearListChoiceBox;

    ObservableList<String> departmentList = FXCollections.observableArrayList(
            "CSE",
            "EEE",
            "ME"
            );

    ObservableList<String> yearList = FXCollections.observableArrayList(
            "1st",
            "2nd",
            "3rd",
            "4th"
    );
    @FXML
    private void initialize(){
//        deptListChoiceBox.setItems(departmentList);
//        deptListChoiceBox.setValue("CSE");

//        yearListChoiceBox.setItems(yearList);
//        yearListChoiceBox.setValue("1st");
    }
    @FXML
    public void setDepartment(MouseEvent mouseEvent) {
        System.out.println(deptListChoiceBox.getItems());
    }
    @FXML
    public void updateCourse(MouseEvent mouseEvent) {
        System.out.println(deptListChoiceBox.getValue().toString());
        System.out.println(yearListChoiceBox.getValue().toString());
    }
}
