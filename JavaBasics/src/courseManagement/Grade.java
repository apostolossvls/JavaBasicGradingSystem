package courseManagement;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;

import fileManagement.SaveManager;
import mainpackage.CreateUsers;
import userManagement.Student;

public class Grade {
	
	//static variable list of all grades
	public static ArrayList<Grade> allGrades  = new ArrayList<>();
	
	//Grade's info
	private Course course;
	private int year;
	private Dictionary<Student, Float> grades;
	
	//overload constructor using User Input
	public Grade() {
		System.out.println("Creating Grade:");
		
		System.out.println("Enter Course Name");
		String answer;
		Course course;
		do {
			answer = CreateUsers.s.nextLine();
			if (answer == "exit" || answer == "cancel") return;
			course = Course.FindByName(answer);
		} while (course == null);
		
 		System.out.println("Enter Year");
 		int answerInt;
 		do {
	 		if(CreateUsers.s.hasNextInt()){
				answerInt = CreateUsers.s.nextInt(); //read integer
				setYear(answerInt);
	 		}
	 		else{
	 			answerInt = -1;
				System.out.println("Incorrect year");
				CreateUsers.s.nextLine(); //consumes line after giving integer
			}
 		} while (answerInt == -1);
		
		//Add this to static list
		Grade.allGrades.add(this);
		
		//saves all courses' list to a file
		SaveManager.Save((Object) allGrades, "grades.txt");
	}
	
	//overload constructor with given parameters
	public Grade(Course course, int year, Dictionary<Student, Float> grades) {
		this.course = course;
		this.year = year;
		this.grades = grades;
		
		//Add this to static list
		Grade.allGrades.add(this);
		
		//saves all grades' list to a file
		SaveManager.Save((Object) allGrades, "grades.txt");
	}
	
	//add student to list
	public void AddGrade(Student student, Float value) {
		grades.put(student, value);
		
	}
	
	//overloading AddGrade with UI and calling AddGrade with parameters
	public void AddGrade() {
		String answer;
		Student student;
		Float grade;
		
		System.out.println("Enter Student's Registration Number");
		do {
			answer = CreateUsers.s.nextLine();
			if (answer == "exit" || answer == "cancel") return;
			//TODO Try...catch
			student = Student.FindByRegistrationNumber(Integer.valueOf(answer));
		} while (student == null);
		
		System.out.println("Enter Student's Grade");
		do {
			answer = CreateUsers.s.nextLine();
			if (answer == "exit" || answer == "cancel") return;
			//try...catch
			grade = Float.parseFloat(answer);
		} while (grade == null);
		
		AddGrade(student, grade);
		System.out.println("Student's Grade was added to" + course.GetName());
	}
	
	//getters
	public Course GetCourse() {
		return course;
	}
	
	public int GetYear() {
		return year;
	}
	
	public Dictionary<Student, Float> GetGrades() {
		return grades;
	}
	
	//return a student searched by the registration number
	public Float GetGrade(Integer registrationNumber) {
		Student student = FindStudent(registrationNumber);
		if (student != null) {
			return grades.get(student).floatValue();
		}
		else {
			return -1.0F;
		}
	}
	
	//GetGrade using User Input, calls GetGrade overload with one String parameter
	public void GetGrade() {
		String answer;
		System.out.println("Enter Student's Registration Number");
		answer = CreateUsers.s.nextLine();
		if (answer == "exit" || answer == "cancel")
			return;
		else {
			//Call main overload GetGrade method and if result is -1 then Student wasn't found...
			//...main overload GetGrade method doesn't include console output as it may be used by other methods
			//TODO try...catch
			if (GetGrade(Integer.valueOf(answer)) == -1.0F) {
				System.out.println("Student not found.");
			}
		}
	}
	
	//Find a student in the dictionary of grades by the registration number 
	Student FindStudent(Integer registrationNumber) {
		Student student = null;
		//empty enumeration to store. grades.keys returns an enumaration
        Enumeration<Student> enu = grades.keys();
        //While enumeration has still elements 
        while (enu.hasMoreElements()) {
        	student = enu.nextElement();
        	if (student.GetRegistrationNumber() == registrationNumber) {
        		return student;
        	}
        }
		return null;
	}
	
	//setters
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void SetStudents(Dictionary<Student, Float> grades) {
		this.grades = grades;
	}
}
