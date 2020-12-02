package sample;


import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

import java.awt.image.AreaAveragingScaleFilter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminController {
    private ArrayList<Course> selectedCourses = new ArrayList<>(); // course list to be excluded
    @FXML private  TextField rollNo;
    @FXML private Text tableCaption;
    @FXML private TableView courseDetails;
    @FXML private ChoiceBox deptListChoiceBox;
    @FXML private ChoiceBox yearListChoiceBox;
    private HashMap<String, HashMap<Integer, HashMap<String, ArrayList<Course>>>> all = (new HashedCourseInfo()).getHashedCourseInfo();

//    ObservableList<String> departmentList = FXCollections.observableArrayList(
//            "CSE",
//            "EEE",
//            "ME"
//            );
//
//    ObservableList<String> yearList = FXCollections.observableArrayList(
//            "1st",
//            "2nd",
//            "3rd",
//            "4th"
//    );
    @FXML
    private void initialize(){
        TableColumn select = new TableColumn("Enrolled");
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
                        }else{
                            selectedCourses.add(course);
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
        payableAmountColumn.setMinWidth(150);
        payableAmountColumn.setStyle( "-fx-alignment: CENTER-RIGHT;");
        courseDetails.getColumns().addAll(select, courseCodeColumn, descriptionColumn, creditColumn, payableAmountColumn);
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
    private int getStudentId(String roll){
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
    private Course getSelectedCoursesHelper(String id)
    {
        Course res = null;
        String findUserID = "SELECT * FROM course_info WHERE id=?";
        String connectionUrl = "jdbc:mysql://localhost/course_registration_system";

        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "root", "");
            PreparedStatement preparedStmt = conn.prepareStatement(findUserID);
            preparedStmt.setString(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){
                res = new Course(
                        rs.getString("code"),
                        rs.getString("description"),
                        Double.valueOf(rs.getString("credit")));
                res.setSelected(true);
            }

        }catch (SQLException e) {
            // handle the exception
            e.printStackTrace();
        }
        return res;
    }
    private ArrayList<Course> getEnrolledCourses(int id)
    {
        ArrayList<String> courseIds = new ArrayList<>();
        ArrayList<Course> enrolledCourses = new ArrayList<>();

        String findUserID = "SELECT * FROM enrolled_info WHERE user_id=?";
        String connectionUrl = "jdbc:mysql://localhost/course_registration_system";

        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "root", "");
            PreparedStatement preparedStmt = conn.prepareStatement(findUserID);
            preparedStmt.setString(1, String.valueOf(id));
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){
                courseIds.add(rs.getString("course_id"));
            }

        }catch (SQLException e) {
            // handle the exception
            e.printStackTrace();
        }
        for(String cid: courseIds)
        {
            enrolledCourses.add(this.getSelectedCoursesHelper(cid));
        }
        return enrolledCourses;
    }

    private String getCourseIdsByCourseCode(String code)
    {
        String res = null;
        String findUserID = "SELECT * FROM course_info WHERE code=?";
        String connectionUrl = "jdbc:mysql://localhost/course_registration_system";

        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "root", "");
            PreparedStatement preparedStmt = conn.prepareStatement(findUserID);
            preparedStmt.setString(1, code);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){
                res = rs.getString("id");
            }

        }catch (SQLException e) {
            // handle the exception
            e.printStackTrace();
        }
        return res;
    }
    private boolean unenrollCourses(ArrayList<String> ids) throws SQLException {
        String findUserID = "DELETE FROM enrolled_info WHERE user_id=? AND course_id=?";
        String connectionUrl = "jdbc:mysql://localhost/course_registration_system";
        Connection conn = DriverManager.getConnection(connectionUrl, "root", "");
        for(String id: ids)
        {
            try {
                PreparedStatement preparedStmt = conn.prepareStatement(findUserID);
                preparedStmt.setString(1, String.valueOf(getStudentId(rollNo.getText())));
                preparedStmt.setString(2, id);
                preparedStmt.execute();
            }catch (SQLException e) {
                // handle the exception
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
    public void trackStudent(MouseEvent mouseEvent) {
        courseDetails.getItems().clear();
        tableCaption.setText("Information for Roll: "+rollNo.getText().toString());
//        System.out.println(rollNo.getText().toString());
//        Course testRow = new Course("CSE 2101", "CSE", 2.0);
//        testRow.setSelected(true);
//        courseDetails.getItems().add(testRow);
        for(Course c: this.getEnrolledCourses(getStudentId(rollNo.getText())))
        {
            courseDetails.getItems().add(c);
        }
    }

    public void saveCourse(MouseEvent mouseEvent) throws SQLException {
        int studentId = getStudentId(rollNo.getText());

        ArrayList<String> courseIds = new ArrayList<>();
        for(Course c: selectedCourses)
        {
            courseIds.add(this.getCourseIdsByCourseCode(c.getCourseCode()));
        }
        if(this.unenrollCourses(courseIds))
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Unenrolled");
            alert.setContentText("Successfully unenrolled " + String.valueOf(selectedCourses.size()) + " courses for roll " + rollNo.getText());
            alert.showAndWait();

            selectedCourses.clear();
        }
    }
}
