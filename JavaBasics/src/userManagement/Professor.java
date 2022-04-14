package userManagement;

import courseManagement.Grade;
import mainpackage.CreateUsers;

//import java.util.InputMismatchException;

public class Professor extends User {
	
	//auto generated serialVersionUID
	private static final long serialVersionUID = -3819521436348570924L;
	
	//Professor info
	//empty
	
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
		SetType(Type.Professor); //sets its type to Professor
		
		User.allUsers.add(this);
		usersCounter++;
		
		System.out.println("'Professor' created.");
	}
	
	//Constructor with parameters
	public Professor(String newUsername, String newPassword, String newName, String newSurname) {
		SetName(newName);
		SetUsername(newUsername);
		SetPassword(newPassword);
		SetSurname(newSurname);
		SetType(Type.Professor); //sets its type to Professor
		
		User.allUsers.add(this);
		usersCounter++;
		
		System.out.println("'Professor' created.");
	}
	
	public void GradeStudent(Student student, Grade grade,  Float value) {
		grade.AddGrade(student, value);
	}
	
	//Shows informations about the student
	public void ShowInfo() {
		System.out.println("Username: " + GetUsername());
		System.out.println("Name: " + GetName());
		System.out.println("Surname: " + GetSurname());
	}
	
	public static Professor FindByNameSurname(String wantedName, String wantedSurname) {
		for (int i = 0; i < allUsers.size(); i++) {
			User user = allUsers.get(i);
			if (user.GetType() == Type.Professor) {
				if (user.GetName() == wantedName && user.GetSurname() == wantedSurname){
					return (Professor)user;
				}
			}
		}
		return null;
	}
}
