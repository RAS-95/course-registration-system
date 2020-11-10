package sample;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class StudentController {
    private HashMap<String, HashMap<Integer, HashMap<String, ArrayList<Course>>>> all = (new HashedCourseInfo()).getHashedCourseInfo();
    private ArrayList<Course> selectedCourses = new ArrayList<>();
    public StudentController(){
//        System.out.println(all.get("CSE").get(1).get("Odd"));
    }
    @FXML private TableView courseDetails;
    @FXML private ChoiceBox deptListChoiceBox;
    @FXML private ChoiceBox yearListChoiceBox;
    @FXML private ChoiceBox semesterListChoiceBox;
    @FXML private Text payableAmount;
    @FXML private TextField roll;
    @FXML
    private void initialize() {
        TableColumn select = new TableColumn("Select");
        select.setMinWidth(25);
        select.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Course, CheckBox>, ObservableValue<CheckBox>>() {

            @Override
            public ObservableValue<CheckBox> call(
                    TableColumn.CellDataFeatures<Course, CheckBox> arg0) {
                Course course = arg0.getValue();

                CheckBox checkBox = new CheckBox();

                checkBox.selectedProperty().setValue(course.isSelected());



                checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    public void changed(ObservableValue<? extends Boolean> ov,
                                        Boolean old_val, Boolean new_val) {

                        course.setSelected(new_val);
//                        System.out.println(course.getCourseDescription()+" is " + course.isSelected());
                        if(selectedCourses.contains(course)){
                            selectedCourses.remove(course);
                            System.out.println(payableAmount.getText());
                            payableAmount.setText(String.valueOf(Double.parseDouble(payableAmount.getText())-course.getPayableAmount()));

                        }else{
                            selectedCourses.add(course);
                            System.out.println(payableAmount.getText());
                            payableAmount.setText(String.valueOf(Double.parseDouble(payableAmount.getText())+course.getPayableAmount()));
                        }
                    }
                });

                return new SimpleObjectProperty<CheckBox>(checkBox);

            }

        });
        TableColumn courseCodeColumn = new TableColumn("Course Code");
        courseCodeColumn.setCellValueFactory(new PropertyValueFactory<>("courseCode"));
        courseCodeColumn.setStyle( "-fx-alignment: CENTER-RIGHT;");


        TableColumn descriptionColumn = new TableColumn("Description");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("courseDescription"));
        descriptionColumn.setStyle( "-fx-alignment: CENTER-RIGHT;");
        descriptionColumn.setMinWidth(250);


        TableColumn creditColumn = new TableColumn("Credit");
        creditColumn.setCellValueFactory(new PropertyValueFactory<>("courseCredit"));
        creditColumn.setStyle( "-fx-alignment: CENTER-RIGHT;");
        creditColumn.setMinWidth(50);


        TableColumn payableAmountColumn = new TableColumn("Charge (BDT)");
        payableAmountColumn.setCellValueFactory(new PropertyValueFactory<>("payableAmount"));
        payableAmountColumn.setMinWidth(100);
        payableAmountColumn.setStyle( "-fx-alignment: CENTER-RIGHT;");
        courseDetails.getColumns().addAll(select, courseCodeColumn, descriptionColumn, creditColumn, payableAmountColumn);
    }
    private int getUserID(String roll){
        String findUserID = "SELECT * FROM user_info WHERE roll=?";
        String connectionUrl = "jdbc:mysql://localhost/course_registration_system";

        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "root", "");
            PreparedStatement preparedStmt = conn.prepareStatement(findUserID);
            preparedStmt.setString(1, roll);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){
                return rs.getInt("id");
            }

        }catch (SQLException e) {
            // handle the exception
            e.printStackTrace();
        }
        return -1;
    }
    private int getCourseID(String code){
        String findUserID = "SELECT * FROM course_info WHERE code=?";
        String connectionUrl = "jdbc:mysql://localhost/course_registration_system";

        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "root", "");
            PreparedStatement preparedStmt = conn.prepareStatement(findUserID);
            preparedStmt.setString(1, code);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){
                return rs.getInt("id");
            }

        }catch (SQLException e) {
            // handle the exception
            e.printStackTrace();
        }
        return -1;
    }
    @FXML
    private void updateCourse()
    {
        String dept = deptListChoiceBox.getValue().toString();
        String year = yearListChoiceBox.getValue().toString();
        String sems = semesterListChoiceBox.getValue().toString();
//        System.out.println(deptListChoiceBox.getValue().toString());
//        System.out.println(yearListChoiceBox.getValue().toString());
//        System.out.println(semesterListChoiceBox.getValue().toString());
        System.out.println(dept+year+sems);
        if(!dept.equals("Select Department") && !year.equals("Select year") && !sems.equals("Select semester")){
//        Course cse2102 = new Course("CSE 2102", "Project");
            for(Course c: all.get(dept).get(Integer.parseInt(year)).get(sems)){
                System.out.println(c.getCourseDescription());
                courseDetails.getItems().add(c);
            }
        }
    }
    @FXML
    private void doEnroll(){
        for(Course c: selectedCourses)
        {
            System.out.println(c.getCourseDescription());
            String findUserID = "INSERT INTO enrolled_info(user_id, course_id) VALUES(?, ?)";
            String connectionUrl = "jdbc:mysql://localhost/course_registration_system";

            try {
                Connection conn = DriverManager.getConnection(connectionUrl, "root", "");
                PreparedStatement preparedStmt = conn.prepareStatement(findUserID);
                preparedStmt.setString(1, String.valueOf(this.getUserID(this.roll.getText())));
                preparedStmt.setString(2, String.valueOf(this.getCourseID(c.getCourseCode())));
                preparedStmt.execute();

            }catch (SQLException e) {
                // handle the exception
                e.printStackTrace();
            }
        }
    }

    public void setRoll(String roll) {
        this.roll.setText(roll);
    }
}
