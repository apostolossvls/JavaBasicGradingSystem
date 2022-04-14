package userManagement;

import mainpackage.CreateUsers;

import java.util.ArrayList;

import fileManagement.SaveManager;

import java.io.*;
//import java.util.InputMismatchException;

public class User implements Serializable{
	
	//auto generated serialVersionUID
	private static final long serialVersionUID = -8487797401987095122L;

	public enum Type {
		User,
		Student,
		Professor,
		Secretary
	};
	
	//static variables
	public static ArrayList<User> allUsers  = new ArrayList<>(); //list of all users
	public static int usersCounter; //amount of users
	
	//user info
	private String username;
	private String password;
	private String name;
	private String surname;
	private Type type;
	
	//Constructors
	//Constructor with user interface
	public User() {
		System.out.println("Creating User:");
		System.out.println("Enter Username");
		SetUsername(CreateUsers.s.nextLine());
		System.out.println("Enter Password");
		SetPassword(CreateUsers.s.nextLine());
		System.out.println("Enter Name");
		SetName(CreateUsers.s.nextLine());
		System.out.println("Enter Surname");
		SetName(CreateUsers.s.nextLine());
		SetType(Type.User); //empty value
		
		User.allUsers.add(this);
		usersCounter++;
		
		//saves all users' list to a file
		SaveManager.Save((Object) allUsers, "users.txt");
		
		System.out.println("'User' created.");
	}
	
	//Constructor with parameters
	public User(String newUsername, String newPassword, String newName, String newSurname) {
		SetUsername(newUsername);
		SetPassword(newPassword);
		SetName(newName);
		SetSurname(newSurname);
		SetType(Type.User); //empty value
		
		User.allUsers.add(this);
		usersCounter++;
		
		//saves all users' list to a file
		SaveManager.Save((Object) allUsers, "users.txt");
		
		System.out.println("'User' created.");
	}
	
	//UI
	public void LogIn() {
		System.out.println("Enter Username");
		username = CreateUsers.s.nextLine();
		System.out.println("Enter Password");
		password = CreateUsers.s.nextLine();
		System.out.println("Hello "+username+" (password: "+password+")");
	}
	
	public void LogIn(String username, String password) {
		System.out.println("Hello "+username+" (password: "+password+")");
	}
	
	public void LogOut()  {
		//saves all users' list to a file
		//SaveManager.Save((Object) allUsers, "users.txt");

		//saves all programs' list to a file
		//SaveManager.Save((Object) Admin.programs, "programs.txt");
		
		System.out.println("Logout");
		System.exit(0);
	}
	
	//getters
	public String GetUsername() {
		return username;
	}
	
	//Password has no public getter
	
	public String GetName() {
		return name;
	}
	
	public String GetSurname() {
		return surname;
	}
	
	public Type GetType() {
		return type;
	}
	
	//setters
	public void SetUsername(String newUsername) {
		this.username = newUsername;
	}
	
	void SetPassword(String newPassword) {
		this.password = newPassword;
	}
	
	public void SetName(String newName) {
		this.name = newName;
	}
	
	public void SetSurname(String newSurname) {
		this.surname = newSurname;
	}
	
	public void SetType(Type newType) {
		this.type = newType;
	}
}