package userManagement;

import java.util.ArrayList;

import courseManagement.Course;
import courseManagement.EnrollCourseRequest;
import courseManagement.Grade;
import mainpackage.CreateUsers;

//import java.util.InputMismatchException;

public class Secretary extends User {
	
	//auto generated serialVersionUID
	private static final long serialVersionUID = -3819521436348570924L;
	
	//Secretary info
	private static ArrayList<EnrollCourseRequest> pendingCourseRequests;
	
	//Constructors
	//Constructor with user interface
	public Secretary() {
		System.out.println("Creating Secretary:");
		System.out.println("Enter Username");
		SetUsername(CreateUsers.s.nextLine());
		System.out.println("Enter Password");
		SetPassword(CreateUsers.s.nextLine());
		System.out.println("Enter Name");
		SetName(CreateUsers.s.nextLine());
		System.out.println("Enter Surname");
		SetName(CreateUsers.s.nextLine());
		SetType(Type.Secretary); //sets its type to Secretary
		
		//add secretary to allUsers list and increase counter
		User.allUsers.add(this);
		usersCounter++;
		
		System.out.println("'Secretary' created.");
	}
	
	//Constructor with parameters
	public Secretary(String newUsername, String newPassword, String newName, String newSurname) {
		SetName(newName);
		SetUsername(newUsername);
		SetPassword(newPassword);
		SetSurname(newSurname);
		SetType(Type.Secretary); //sets its type to Secretary
		
		//add secretary to allUsers list and increase counter
		User.allUsers.add(this);
		usersCounter++;
		
		System.out.println("'Secretary' created.");
	}
	
	//create new Student using UI constructor
	public Student CreateStudent() {
		return new Student();
	}
	
	//create new Professor using UI constructor
	public Professor CreateProfessor() {
		return new Professor();
	}
	
	//create new course using UI constructor
	public Course CreateCourse() {
		return new Course();
	}
	
	//create new grade object using UI constructor
	public Grade CreateGrade() {
		return new Grade();
	}
	
	//create new grade object using UI constructor
	public void UpdateCourseName() {
		//TODO
		System.out.println("'Updated.'");
	}
	
	//Shows informations about the student
	public void ShowInfo() {
		System.out.println("Username: " + GetUsername());
		System.out.println("Name: " + GetName());
		System.out.println("Surname: " + GetSurname());
	}
	
	//Takes an EnrollCourseRequest and adds it to the pending list if it was not included.
	//Used by Student class.
	public static void StudentEnrollCourse(EnrollCourseRequest request) {
		if (!pendingCourseRequests.contains(request)) {
			pendingCourseRequests.add(request);
		}
	}
	
	//With a request, add a student to the grading list, ready to be given a grade, on that requested course
	public void AcceptEnrollRequest(EnrollCourseRequest request) {
		//Find the grade instance by giving the course contained in the request as parameter.
		Grade grade = Grade.GetGradeOfCourse(request.getCourse());
		//Add the student in the grading list of the course ready to be given a grade.
		//Value of -1.0F is a helper float value meaning that the student has not been given a grade yet.
		grade.GiveGrade(request.getStudent(), -1.0F);
	}
	
	//For each pending enroll request, call AcceptEnrollRequest method
	public void AcceptAllEnrollRequests() {
		for (int i = 0; i < pendingCourseRequests.size(); i++) {
			AcceptEnrollRequest(pendingCourseRequests.get(i));
		}
	}
}