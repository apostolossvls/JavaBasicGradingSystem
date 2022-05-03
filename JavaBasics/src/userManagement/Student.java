package userManagement;

import java.util.ArrayList;

import courseManagement.Course;
import courseManagement.EnrollCourseRequest;
import courseManagement.Grade;
import mainpackage.CreateUsers;

//import java.util.InputMismatchException;

public class Student extends User {
	
	//auto generated serialVersionUID
	private static final long serialVersionUID = -3819521436348570924L;
	
	//static variables
	public static ArrayList<Student> allStudents  = new ArrayList<>(); //list of all students
	
	//Student info
	private final Integer registrationNumber;
	
	//Constructors
	//Constructor with user interface
	public Student() {
		System.out.println("Creating Student:");
		System.out.println("Enter Username");
		SetUsername(CreateUsers.s.nextLine());
		System.out.println("Enter Password");
		SetPassword(CreateUsers.s.nextLine());
		System.out.println("Enter Name");
		SetName(CreateUsers.s.nextLine());
		System.out.println("Enter Surname");
		SetSurname(CreateUsers.s.nextLine());
		System.out.println("Enter Registration Number");
		registrationNumber = Integer.valueOf(CreateUsers.s.nextLine()); //final variable is initialized on constructor
		
		SetType(Type.Student); //sets its type to Student
		
		//Add object to specific list
		Student.allStudents.add(this);
		
		System.out.println("'Student' created.");
	}
	
	//Constructor with parameters
	public Student(String newUsername, String newPassword, String newName, String newSurname, Integer newRegistrationNumber) {
		SetName(newName);
		SetUsername(newUsername);
		SetPassword(newPassword);
		SetSurname(newSurname);
		registrationNumber = newRegistrationNumber; //final variable is initialized on constructor
		SetType(Type.Student); //sets its type to Student
		
		//Add object to specific list
		Student.allStudents.add(this);
		
		System.out.println("'Student' created.");
	}
	
	//Shows informations about the student
	public void ShowInfo() {
		System.out.println("Username: " + GetUsername());
		System.out.println("Name: " + GetName());
		System.out.println("Surname: " + GetSurname());
		System.out.println("Registration Number: " + GetRegistrationNumberToString());
	}
	
	//Enroll to a course, added to a pending list on Secretary class
	public EnrollCourseRequest EnrollCourse(Course course) {
		//crate a new EnrollCourseRequest instance for this student
		EnrollCourseRequest request = new EnrollCourseRequest(this, course);
		//Request call static method on Secretary class
		int requestReturn = Secretary.StudentEnrollCourse(request);
		if (requestReturn == 0) System.out.println("Request was made.");
		else System.out.println("Request already exists");
		return request;
	}
	
	//Show all grades of this student
	//TODO Get results and then print out results on this method
	public void ShowAllGrades() {
		Grade.GetStudentAllGrades(this);
	}
	
	//Find Student by Registration Number
	public static Student FindByRegistrationNumber(Integer target) {
		for (int i = 0; i < allStudents.size(); i++) {
			if (allStudents.get(i).GetRegistrationNumber().intValue() == target) {
				return allStudents.get(i);
			}
		}
		return null;
	}
	
	//returns all students from static list
	public static ArrayList<Student> GetAllStudents() {
		return allStudents;
	}
	
	//getters
	public Integer GetRegistrationNumber() {
		return registrationNumber;
	}
	
	//getters
	public String GetRegistrationNumberToString() {
		return registrationNumber.toString();
	}
}

