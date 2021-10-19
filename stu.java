package management;
import java.util.ArrayList;
import java.util.Scanner;
public class stu {
    private String studentID;
    private String studentName;
    private String semester;
    private String courseName;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID: ");
        studentID = sc.nextLine();
        System.out.println("Enter Studentname: ");
        studentName = sc.nextLine();
        System.out.println("Enter semester: ");
        semester = sc.nextLine();
    }
    public void showDisplay(){
        System.out.println("Student ID:"+ studentID+"\n"+"Student name:"+ studentName+"\n"+"Semester:"+ semester+"\n"+"Course name:"+ courseName+"\n");
    }
    public void showReport(){
        System.out.println(studentName+" | "+courseName+" | ");
    }
    }

