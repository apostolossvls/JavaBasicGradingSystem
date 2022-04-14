package userManagement;

import java.util.ArrayList;

import mainpackage.CreateUsers;

//import java.util.InputMismatchException;

public class Student extends User {
	
	//auto generated serialVersionUID
	private static final long serialVersionUID = -3819521436348570924L;
	
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
		
		User.allUsers.add(this);
		usersCounter++;
		
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
		
		User.allUsers.add(this);
		usersCounter++;
		
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
		for (int i = 0; i < allUsers.size(); i++) {
			User user = allUsers.get(i);
			if (user.GetType() == Type.Student) {
				Student student = (Student)user;
				if (student.GetRegistrationNumber() == target) {
					return student;
				}
			}
		}
		return null;
	}
	
	//returns all students from allUsers list
	public static ArrayList<Student> GetAllStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		for (int i = 0; i < allUsers.size(); i++) {
			User user = allUsers.get(i);
			if (user.GetType() == Type.Student) {
				//cast user as student and the all it to return list
				students.add((Student)user);
			}
		}
		return students;
	}
	
	//getters
	public String GetRegistrationNumber() {
		return registrationNumber;
	}
}

