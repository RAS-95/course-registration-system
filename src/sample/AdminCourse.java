package sample;

public class AdminCourse {
    private String courseCode;
    private String courseDescription;
    private double courseCredit;
    private double payableAmount;
    public AdminCourse(String courseCode, String description, double credit){
        this.courseCode = courseCode;
        this.courseDescription = description;
        this.courseCredit = credit;
        this.payableAmount = this.courseCredit*20; // assuming 20x amount to be paid
    }
    public String getCourseCode(){
        return this.courseCode;
    }
    public String getCourseDescription(){
        return this.courseDescription;
    }
    public double getCourseCredit(){return this.courseCredit;}
    public double getPayableAmount(){return this.payableAmount;}
}
