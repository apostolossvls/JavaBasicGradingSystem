package userManagement;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;

import courseManagement.Grade;
import mainpackage.CreateUsers;

//import java.util.InputMismatchException;

public class Professor extends User {
	
	//auto generated serialVersionUID
	private static final long serialVersionUID = -3819521436348570924L;
	
	//Professor info
	private final Integer registrationNumber;
	
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
		registrationNumber = Integer.valueOf(CreateUsers.s.nextLine()); //final variable is initialized on constructor
		
		SetType(Type.Professor); //sets its type to Professor
		
		System.out.println("'Professor' created.");
	}
	
	//Constructor with parameters
	public Professor(String newUsername, String newPassword, String newName, String newSurname, Integer newRegistrationNumber) {
		SetName(newName);
		SetUsername(newUsername);
		SetPassword(newPassword);
		SetSurname(newSurname);
		registrationNumber = newRegistrationNumber;
		
		SetType(Type.Professor); //sets its type to Professor
		
		System.out.println("'Professor' created.");
	}
	
	//Give a score/grade on a student on a Grade instance (Grade and Course objects are related)
	public void GradeStudent(Student student, Grade grade,  Float value) {
		//check if the professor is the course's assigne professor
		if (grade.GetCourse().GetAssignedProfessor() == this) {
			grade.GiveGrade(student, value);
		}
		else {
			System.out.println("Professor is not the assigned professor for this course.");
		}
	}
	
	//Show all grades of students of all the courses the professor is assigned
	public void ShowAllGradings() {
		//get a list all all Grade instances the professor is assigned professor
		ArrayList<Grade> grades = Grade.GetProfessorGradings(this);
		if (grades == null || grades.isEmpty()) { //message if result is empty
			System.out.println("Professor is not assigned to any course");
			return;
		}
		
		for (int i = 0; i < grades.size(); i++) {
			//print out the course name
			System.out.println("Course: "+grades.get(i).GetCourse().GetName());
			
			//get grade dictionary of this course
			Dictionary<Student, Float> grade = grades.get(i).GetGrades();
			//enumeration to store. grade.keys returns an enumeration
			Enumeration<Student> enu = grade.keys();
			
	        //While enumeration has still elements 
	        while (enu.hasMoreElements()) {
	        	Student student = enu.nextElement(); //get next student
	        	//Print out student's name and the grade on this course.
	        	//Giving the student as key will return the score / value on the dictionary
	        	System.out.println(student.GetName() +" | "+grade.get(student));
	        }
		}
	}
	
	//Shows informations about the professor
	public void ShowInfo() {
		System.out.println("Username: " + GetUsername());
		System.out.println("Name: " + GetName());
		System.out.println("Surname: " + GetSurname());
		System.out.println("Registration Number: " + getRegistrationNumberToString());
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
	public static Professor FindByRegistrationNumber(Integer regNumber) {
		for (int i = 0; i < allUsers.size(); i++) {
			User user = allUsers.get(i);
			if (user.GetType() == Type.Professor) { //check if user is type of professor
				Professor professor = (Professor) user; //cast
				if (professor.getRegistrationNumber().intValue() == regNumber){
					return professor;
				}
			}
		}
		return null; //if not found return null
	}
	
	//getters
	public Integer getRegistrationNumber() {
		return registrationNumber;
	}
	
	public String getRegistrationNumberToString() {
		return registrationNumber.toString();
	}
}
