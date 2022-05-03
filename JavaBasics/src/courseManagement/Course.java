package courseManagement;

import java.util.ArrayList;

import fileManagement.SaveManager;
import mainpackage.CreateUsers;
import userManagement.Professor;

public class Course {
	
	//static variable list of all courses
	public static ArrayList<Course> allCourses  = new ArrayList<>();
	
	//Course info
	private String name;
	private String description;
	private Professor assignedProfessor;
	
	public Course() {
		System.out.println("Creating Course:");
		System.out.println("Enter Name");
		SetName(CreateUsers.s.nextLine());
		System.out.println("Enter Description");
		SetDescription(CreateUsers.s.nextLine());
		System.out.println("Enter Professor's name and Surname ('Name, Surname')");
		Professor professor;
		do {
			String answer = CreateUsers.s.nextLine();
			String[] answerParts = answer.split(", ");
			professor = Professor.FindByNameSurname(answerParts[0], answerParts[1]);
		} while (professor != null);
		SetAssignedProfessor(professor);
		
		//Add this to static list
		Course.allCourses.add(this);
		
		//saves all courses' list to a file
		SaveManager.Save((Object) allCourses, "courses.txt");
		
		System.out.println("'Course' created.");
	}
	
	public Course(String name, String description, Professor professor) {
		this.name = name;
		this.description = description;
		this.assignedProfessor = professor;

		//Add this to static list
		Course.allCourses.add(this);
		
		//saves all courses' list to a file
		SaveManager.Save((Object) allCourses, "courses.txt");
		
		System.out.println("'Course' created.");
	}
	
	public static Course FindByName(String targetName) {
		for (int i = 0; i < allCourses.size(); i++) {
			if (allCourses.get(i).name == targetName) {
				return allCourses.get(i);
			}
		}
		return null;
	}
	
	//getters
	public String GetName() {
		return name;
	}
	
	public String GetDescription() {
		return description;
	}
	
	public Professor GetAssignedProfessor() {
		return assignedProfessor;
	}
	
	//setters
	public void SetName(String name) {
		this.name = name;
	}

	public void SetDescription(String desc) {
		this.description = desc;
	}
	
	public void SetAssignedProfessor(Professor assignedProfessor) {
		this.assignedProfessor = assignedProfessor;
	}
}
