package userManagement;

import courseManagement.Grade;
import mainpackage.CreateUsers;

//import java.util.InputMismatchException;

public class Professor extends User {
	
	//auto generated serialVersionUID
	private static final long serialVersionUID = -3819521436348570924L;
	
	//Professor info
	private final String registrationNumber;
	
	//Constructors
	//Constructor with user interface
	public Professor() {
		System.out.println("Creating Professor:");
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
		
		SetType(Type.Professor); //sets its type to Professor
		
		//add professor to allUsers list and increase counter
		User.allUsers.add(this);
		usersCounter++;
		
		System.out.println("'Professor' created.");
	}
	
	//Constructor with parameters
	public Professor(String newUsername, String newPassword, String newName, String newSurname, String newRegistrationNumber) {
		SetName(newName);
		SetUsername(newUsername);
		SetPassword(newPassword);
		SetSurname(newSurname);
		registrationNumber = newRegistrationNumber;
		
		SetType(Type.Professor); //sets its type to Professor
		
		//add professor to allUsers list and increase counter
		User.allUsers.add(this);
		usersCounter++;
		
		System.out.println("'Professor' created.");
	}
	
	//Give a score/grade on a student on a Grade instance (Grade and Course objects are related)
	public void GradeStudent(Student student, Grade grade,  Float value) {
		grade.GiveGrade(student, value);
	}
	
	//Shows informations about the professor
	public void ShowInfo() {
		System.out.println("Username: " + GetUsername());
		System.out.println("Name: " + GetName());
		System.out.println("Surname: " + GetSurname());
		System.out.println("Registration Number: " + GetRegistrationNumber());
	}
	
	//Search on allUser static list by a given name and surname
	public static Professor FindByNameSurname(String wantedName, String wantedSurname) {
		for (int i = 0; i < allUsers.size(); i++) {
			User user = allUsers.get(i);
			if (user.GetType() == Type.Professor) { //check if user is type of professor
				if (user.GetName() == wantedName && user.GetSurname() == wantedSurname){
					return (Professor) user;
				}
			}
		}
		return null; //if not found return null
	}
	
	//Search on allUser static list by the registration number
	public static Professor FindByRegistrationNumber(String regNumber) {
		for (int i = 0; i < allUsers.size(); i++) {
			User user = allUsers.get(i);
			if (user.GetType() == Type.Professor) { //check if user is type of professor
				Professor professor = (Professor) user; //cast
				if (professor.GetRegistrationNumber() == regNumber){
					return professor;
				}
			}
		}
		return null; //if not found return null
	}
	
	//getters
	public String GetRegistrationNumber() {
		return registrationNumber;
	}
}
