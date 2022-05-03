package courseManagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import fileManagement.SaveManager;
import mainpackage.CreateUsers;
import userManagement.Professor;
import userManagement.Student;

public class Grade implements Serializable{
	
	//auto generated serialVersionUID
	private static final long serialVersionUID = 2518546822920987814L;

	//static variable list of all grades
	public static ArrayList<Grade> allGrades  = new ArrayList<>();
	
	//Grade's info
	private Course course;
	private int year;
	private Hashtable<Student, Float> grades = new Hashtable<Student, Float>(); //Like Dictionary
	
	//overload constructor using User Input
	public Grade() {
		System.out.println("Creating Grade:");
		
		System.out.println("Enter Course Name");
		String answer;
		Course course;
		do {
			answer = CreateUsers.s.nextLine();
			if (answer == "exit" || answer == "cancel") return;
			course = Course.FindByName(answer);
		} while (course == null);
		
 		System.out.println("Enter Year");
 		int answerInt;
 		do {
	 		if(CreateUsers.s.hasNextInt()){
				answerInt = CreateUsers.s.nextInt(); //read integer
				setYear(answerInt);
	 		}
	 		else{
	 			answerInt = -1;
				System.out.println("Incorrect year");
				CreateUsers.s.nextLine(); //consumes line after giving integer
			}
 		} while (answerInt == -1);
		
		//Add this to static list
		Grade.allGrades.add(this);
		
		//saves all courses' list to a file
		SaveManager.Save((Object) allGrades, "grades.txt");
	}
	
	//overload constructor with given parameters
	public Grade(Course course, int year, Hashtable<Student, Float> grades) {
		this.course = course;
		this.year = year;
		if (grades!= null) this.grades = grades;
		
		//Add this to static list
		Grade.allGrades.add(this);
		
		//saves all grades' list to a file
		SaveManager.Save((Object) allGrades, "grades.txt");
	}
	
	//Update OR Add student to list
	public void GiveGrade(Student student, Float value) {
		//TODO try..catch null
		//With "put", the value gets updated if key exists of it gets added if it doesn't.
		grades.put(student, value);
		System.out.println("Grade was given to (RegN): "+student.GetRegistrationNumberToString());
	}
	
	//overloading GiveGrade with UI and calling AddGrade with parameters
	public void GiveGrade() {
		String answer;
		Student student;
		Float grade;
		
		System.out.println("Enter Student's Registration Number");
		do {
			answer = CreateUsers.s.nextLine();
			if (answer == "exit" || answer == "cancel") return;
			//TODO Try...catch
			student = Student.FindByRegistrationNumber(Integer.valueOf(answer));
		} while (student == null);
		
		System.out.println("Enter Student's Grade");
		do {
			answer = CreateUsers.s.nextLine();
			if (answer == "exit" || answer == "cancel") return;
			//try...catch
			grade = Float.parseFloat(answer);
		} while (grade == null || (grade < 0F && grade != -1.0F));
		//allow float grade to take positive values, zero or -1 (as a helper value meaning no grading yer)
		
		GiveGrade(student, grade);
		System.out.println("Student's Grade was added to" + course.GetName());
	}
	
	//getters
	public Course GetCourse() {
		return course;
	}
	
	public int GetYear() {
		return year;
	}
	
	public Hashtable<Student, Float> GetGrades() {
		return grades;
	}
	
	//return a student searched by the registration number
	public Float GetGrade(Integer registrationNumber) {
		Student student = FindStudent(registrationNumber);
		if (student != null) {
			return grades.get(student).floatValue();
		}
		else {
			return -1.0F;
		}
	}
	
	//Returns a Grade instance  by searching in static allGrades array list
	public static Grade GetGradeOfCourse(Course course) {
		for (int i = 0; i < allGrades.size(); i++) {
			//if courses match
			if (allGrades.get(i).GetCourse() == course) {
				return allGrades.get(i);
			}
		}
		return null;
	}
	
	//GetGrade using User Input, calls GetGrade overload with one String parameter
	public void GetStudentGrade() {
		String answer;
		System.out.println("Enter Student's Registration Number");
		answer = CreateUsers.s.nextLine();
		if (answer == "exit" || answer == "cancel")
			return;
		else {
			//Call main overload GetGrade method and if result is -1 then Student wasn't found...
			//...main overload GetGrade method doesn't include console output as it may be used by other methods
			//TODO try...catch
			if (GetGrade(Integer.valueOf(answer)) == -1.0F) {
				System.out.println("Student not found.");
			}
		}
	}
	
	//Prints out all the grades that the student has been given a score
	public static void GetStudentAllGrades(Student student) {
		boolean foundAtLeastOne = false;
		for (int i = 0; i < allGrades.size(); i++) {
			//Get this course's grading object
			Grade gradeObj = allGrades.get(i);
			if (gradeObj == null) continue; //skip
			if (gradeObj.grades == null) continue; //skip
			float score;
			try {
				//Get score Value with key "student" on the "grades" hashtable
				score = gradeObj.grades.get(student);
			} catch (java.lang.NullPointerException e) {
				continue;
			}
			if (score == -1.0F) continue; //score has value -1.0F when student is not yet graded, as a helping value
			
			String courseName = gradeObj.GetCourse().GetName();
			//TODO return values and not print out
			System.out.println("Course: "+courseName+" | "+score);
			foundAtLeastOne = true;
		}
		
		if (!foundAtLeastOne) System.out.println("No grade was found.");
	}
	
	public static ArrayList<Grade> GetProfessorGradings(Professor professor) {
		ArrayList<Grade> proffessorsGrades = new ArrayList<Grade>();
		for (int i = 0; i < allGrades.size(); i++) {
			//if courses match
			if (allGrades.get(i).GetCourse().GetAssignedProfessor() == professor) {
				proffessorsGrades.add(allGrades.get(i));
			}
		}
		return proffessorsGrades;
	}
	
	//Find a student in the hashtable of grades by the registration number 
	Student FindStudent(Integer registrationNumber) {
		Student student = null;
		//enumeration to store keys. grades.keys returns an enumeration
        Enumeration<Student> enu = grades.keys();
        //While enumeration has still elements 
        while (enu.hasMoreElements()) {
        	student = enu.nextElement();
        	if (student.GetRegistrationNumber() == registrationNumber) {
        		return student;
        	}
        }
		return null;
	}
	
	//setters
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void SetStudents(Hashtable<Student, Float> grades) {
		this.grades = grades;
	}
}
