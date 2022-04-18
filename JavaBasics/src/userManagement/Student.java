package userManagement;

import java.util.ArrayList;

import mainpackage.CreateUsers;

//import java.util.InputMismatchException;

public class Student extends User {
	
	//auto generated serialVersionUID
	private static final long serialVersionUID = -3819521436348570924L;
	
	//static variables
	public static ArrayList<Student> allStudents  = new ArrayList<>(); //list of all students
	
	//Student info
	private final String registrationNumber;
	
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
		SetName(CreateUsers.s.nextLine());
		System.out.println("Enter Registration Number");
		registrationNumber = CreateUsers.s.nextLine(); //final variable is initialized on constructor
		
		SetType(Type.Student); //sets its type to Student
		
		//Add object to both generic and specific list
		User.allUsers.add(this);
		Student.allStudents.add(this);
		usersCounter++; //userCounter is inherited from User
		
		System.out.println("'Student' created.");
	}
	
	//Constructor with parameters
	public Student(String newUsername, String newPassword, String newName, String newSurname, String newRegistrationNumber) {
		SetName(newName);
		SetUsername(newUsername);
		SetPassword(newPassword);
		SetSurname(newSurname);
		registrationNumber = newRegistrationNumber; //final variable is initialized on constructor
		SetType(Type.Student); //sets its type to Student
		
		//Add object to both generic and specific list
		User.allUsers.add(this);
		Student.allStudents.add(this);
		usersCounter++; //userCounter is inherited from User
		
		System.out.println("'Student' created.");
	}
	
	//Shows informations about the student
	public void ShowInfo() {
		System.out.println("Username: " + GetUsername());
		System.out.println("Name: " + GetName());
		System.out.println("Surname: " + GetSurname());
		System.out.println("Registration Number: " + GetRegistrationNumber());
	}
	
	//Find Student by Registration Number
	public static Student FindByRegistrationNumber(String target) {
		for (int i = 0; i < allStudents.size(); i++) {
			if (allStudents.get(i).GetRegistrationNumber() == target) {
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
	public String GetRegistrationNumber() {
		return registrationNumber;
	}
}

