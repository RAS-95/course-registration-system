package sample;

public class EnrolledCourse {
    private String courseCode;
    private String courseDescription;
    private double courseCredit;
    public EnrolledCourse(String courseCode, String description, double credit){
        this.courseCode = courseCode;
        this.courseDescription = description;
        this.courseCredit = credit;
    }
    public String getCourseCode(){
        return this.courseCode;
    }
    public String getCourseDescription(){
        return this.courseDescription;
    }
    public double getCourseCredit(){return this.courseCredit;}
}
