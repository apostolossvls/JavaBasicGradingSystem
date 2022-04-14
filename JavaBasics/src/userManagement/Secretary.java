package userManagement;

import courseManagement.Course;
import courseManagement.Grade;
import mainpackage.CreateUsers;

//import java.util.InputMismatchException;

public class Secretary extends User {
	
	//auto generated serialVersionUID
	private static final long serialVersionUID = -3819521436348570924L;
	
	//Secretary info
	//empty
	
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
		
		User.allUsers.add(this);
		usersCounter++;
		
		System.out.println("'Secretary' created.");
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
			System.out.println("'UpdateCourseName' implementation.");
		}
	
	//Shows informations about the student
	public void ShowInfo() {
		System.out.println("Username: " + GetUsername());
		System.out.println("Name: " + GetName());
		System.out.println("Surname: " + GetSurname());
	}
}