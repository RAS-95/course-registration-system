package sample;

public class Course {
    private String courseCode;
    private String courseDescription;
    private boolean isSelected;
    private double courseCredit;
    private double payableAmount;
    public Course(String courseCode, String description, double credit){
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
    public boolean isSelected(){ return this.isSelected; }
    public void setSelected(Boolean arg) { this.isSelected = arg;}
}
