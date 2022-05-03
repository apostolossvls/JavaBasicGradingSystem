package mainpackage;

import java.util.ArrayList;
import java.util.Scanner;

import courseManagement.*;
import fileManagement.*;
import userManagement.*;

import java.io.*;

public class CreateUsers implements Serializable {
	
	//auto generated serialVersionUID
	private static final long serialVersionUID = -6770288624567376574L;

	public static final Scanner s = new Scanner(System.in); //One and only scanner for the program
	
	public static void main(String[] args) throws Exception {
		
		/*
		//Προσπάθεια ανάγνωσης λίστας allUsers από αρχείο
		Object objUsers = SaveManager.Load("users.txt");
		if (objUsers != null) {
			User.allUsers = (ArrayList<User>) objUsers;
			System.out.println("Data retrieved successfully.");
		}
		*/
		//Γίνεται επιλογή μεταξύ 2 λειτουργιών
			//1. Αυτόματη λειτουργεία όπου δίχνει ενδεικτικά όλα τα αντικείμενα
				//και μεθόδους του πργράμματος
			//2. Προσομοίωση Αλληλεπίδρασης χρήστη.  Δίνεται ένας βασικός έλεγχος
				//για την ροή του προγράμματος
				//(Δεν υπάρχουν όλες οι μεθόδοι στην προσομοίωση)
		
		boolean correctAnswer = false;
		do {
			System.out.println("Select function:");
			System.out.println("(1) Automatic run , (2) Simulate User Interface");
			String answer = s.nextLine();
			switch (answer) {
				case "Automatic run":
				case "Automaticrun":
				case "AutomaticRun":
				case "1":
					correctAnswer = true;
					Auto();
					break;
				case "Simulate User Interface":
				case "SimulateUserInterface":
				case "Simulateuserinterface":
				case "Simulate user interface":
				case "Simulate":
				case "SimulateUI":
				case "Simulateui":
				case "Simulate UI":
				case "Simulate ui":
				case "Simulatation":
				case "UI":
				case "ui":
				case "2":
					correctAnswer = true;
					SimulateUI();
					break;
				default:
			}
		} while (!correctAnswer);
	}
	
	static void Auto() throws FileNotFoundException {
		
		//create 3 users one of each
		System.out.println("* Creating 3  users. One of each:");
		
		System.out.println("* Creating 'Secretary' with username:'GladOS', password: '12345', name: 'Mary', surname: 'Jane'");
		Secretary thisSecretary = new Secretary("GladOS", "12345", "Mary", "Jane");
		
		System.out.println("* Creating 'Professor' with username:'ProfessorX', password: '77777', name: 'Charles', surname: 'Xavier', registrationNumber: '22100'");
		Professor thisProfessor = new Professor("ProfessorX", "77777", "Charles", "Xavier", 22100);
		
		System.out.println("* Creating 'Student' with username:'NotSpiderman', password: '88888', name: 'Peter', surname: 'Parker', registrationNumber: '22022'");
		Student thisStudent = new Student("NotSpiderman", "88888", "Peter", "Parker", 22022);
		
		System.out.println("* All users created. \n");
		
		System.out.println("* Creating 2  courses:");
		
		System.out.println("* Creating 'Course' with name:'Web', a description and assigned professor: 'ProfessorX'");
		Course courseWeb = new Course("Web", "How to create web applications", thisProfessor);
		System.out.println("* Show 'Web' course description:");
		System.out.println(courseWeb.GetDescription());
		
		System.out.println("* Creating 'Course' with name:'Java', a description and assigned professor: 'ProfessorX'");
		Course courseJava = new Course("Java", "How to create java applications", thisProfessor);
		System.out.println("* Show 'Java' course description:");
		System.out.println(courseJava.GetDescription());
		
		System.out.println("* All courses created. \n");
		
		System.out.println("* Creating 2 grading objects for the courses:");
		
		System.out.println("* Creating 'Grade' with course:'Web', year: '2022'");
		Grade gradeWeb = new Grade(courseWeb, 2022, null);
		
		System.out.println("* Creating 'Grade' with course:'Java', year: '2022'");
		Grade gradeJava = new Grade(courseJava, 2022, null);
		
		System.out.println("* All grading objects created. \n");
		
		System.out.println("* Starting automatic calling methods.\n");
		
		//calling methods "Login" which derives from User class.
		System.out.println("* Login with all users:");
		System.out.println("* Login 'Student' with username:'NotSpiderman', password: '88888'");
		thisStudent.LogIn("NotSpiderman", "88888");
		System.out.println("* Login 'Professor' with username:'ProfessorX', password: '77777'");
		thisProfessor.LogIn("ProfessorX", "77777");
		System.out.println("* Login 'Secretary' with username:'GladOS', password: '12345'");
		thisSecretary.LogIn("GladOS", "12345");
		System.out.println("* All accounts logged in. \n");
		
		System.out.println("* Import from file \n");
		//ImportStudent.Import("D:\\unity projects\\temp\\new 3.txt");
		ImportStudent.Import("import.txt");
		
		
		
		System.out.println("*--- Secretary and Student Enroll methods ---*\n");
		
		System.out.println("* Show 'Secretary' info");
		thisSecretary.ShowInfo();
		
		//Create extra professor and student
		System.out.println("* 'Secretary' creates a 'Student' (Waiting for inputs):");
		thisSecretary.CreateStudent();
		System.out.println("* 'Secretary' creates a 'Professor' (Waiting for inputs):");
		thisSecretary.CreateProfessor();
		
		System.out.println("* 'Secretary' updates course 'Web' name to 'WebApps'");
		thisSecretary.UpdateCourseName(courseWeb , "WebApps");
		
		System.out.println("* 'Secretary' assign a professor to a course (Update assigned professor)");
		thisSecretary.AssignProfessorToCourse(thisProfessor, courseJava);
		
		System.out.println("* 'Student' is making a request to enroll on course 'Java'");
		EnrollCourseRequest requestJava = thisStudent.EnrollCourse(courseJava);
		System.out.println("* 'Student' is making a request to enroll on course 'WebApps'");
		thisStudent.EnrollCourse(courseWeb);
		
		System.out.println("* 'Secretary' accepts 'WebApps' enroll request");
		thisSecretary.AcceptEnrollRequest(requestJava);
		
		System.out.println("* 'Secretary' accepts ALL other enroll requests");
		thisSecretary.AcceptAllEnrollRequests();
		
		System.out.println("* Other methods will be demonstrated later. (Accept enroll requests etc)\n");
		
		
		//Professor
		System.out.println("\n*--- Professor methods ---*\n");
		
		System.out.println("* Show 'Professor' info");
		thisProfessor.ShowInfo();
		
		System.out.println("* Call static method to find a professor by name 'Charles' and surname 'Xavier'");
		Professor foundProfessor = Professor.FindByNameSurname("Charles", "Xavier");
		if (foundProfessor != null) {
			System.out.println("* Found, and the Professor's infos are:'");
			foundProfessor.ShowInfo();
		}
		System.out.println("* Call static method to find a professor by registration number ('22100'):");
		foundProfessor = Professor.FindByRegistrationNumber(22100);
		if (foundProfessor != null) {
			System.out.println("* Found, and the Professor's infos are:'");
			foundProfessor.ShowInfo();
		}
		
		System.out.println("* 'ProfessorX' gives student 'NotSpiderman' a score of 9.0 on course 'WebApps':");
		thisProfessor.GradeStudent(thisStudent, gradeWeb, 9.0F);
		System.out.println("* Completed");
		System.out.println("* 'ProfessorX' gives student 'NotSpiderman' a score of 8.5 on course 'Java':");
		thisProfessor.GradeStudent(thisStudent, gradeJava, 8.5F);
		System.out.println("* Completed");
		
		System.out.println("* Show all of 'ProfessorX' gradings in all of his courses:");
		thisProfessor.ShowAllGradings();
		
		
		
		//Student
		System.out.println("\n*--- Student methods (enroll methods are above)---*\n");
		
		System.out.println("* Call static method to find a student by registration number ('22022'):");
		Student foundStudent = Student.FindByRegistrationNumber(22022);
		if (foundStudent != null) {
			System.out.println("* Found, and the Student's infos are:'");
			foundStudent.ShowInfo();
		}
		
		System.out.println("* Show 'NotSpiderman' ALL grades on all of his courses:");
		thisStudent.ShowAllGrades();
		
		System.out.println("\n* Finally, Log out from a user:");
		thisStudent.LogOut();
	}
	
	static void SimulateUI() {
		
		System.out.println("Creating default instances:");
		
		Secretary thisSecretary = new Secretary("GladOS", "12345", "Mary", "Jane");
		Professor thisProfessor = new Professor("ProfessorX", "77777", "Charles", "Xavier", 22100);
		Student thisStudent = new Student("NotSpiderman", "88888", "Peter", "Parker", 22022);
		Course thisCourseWeb = new Course("Web", "How to create web applications", thisProfessor);
		Grade thisGradeWeb = new Grade(thisCourseWeb, 2022, null);
		
		System.out.println("\nIt is recommended to select on of each user (Student, Professor, Secretary),");
		System.out.println("...then assign your new professor with your values\n");
		
		//για την πρώτη άσκηση όπου η υλοποίηση δεν έχει ολοκληρωθεί, υπάρχει ο παρακάτω τρόπος user interface
		//στην αρχή ο χρήστης επιλέγει το user / δικαιώματα όπου θα έχει
		//μετά μπορεί να επιλέγει τις λειτουργείες όπου του επιτρέπονται και να τις εκτελεί
		System.out.println("Select User type (only for testing):");
		System.out.println("(1) Student , (2) Professor , (3) Secretary");
		
		Scanner scanner = new Scanner(System.in);
		String answerUser = scanner.nextLine();
		
		boolean answerUserFlag = false; //αν επιλεχθηκε σωστός user
		boolean answerStudentFlag = false; // //αν επιλεχθηκε student έστω μία φορά
		boolean answerProfessorFlag = false; // //αν επιλεχθηκε student έστω μία φορά
		boolean answerSecretaryFlag = false; // //αν επιλεχθηκε student έστω μία φορά
		do {
			System.out.println("*-----------*");
			System.out.println("Enter Action");
			String answer;
			switch (answerUser) {
				case "Student":
				case "1":
					answerUserFlag = true;
					if (!answerStudentFlag) thisStudent = new Student(); //δημιουργία αν είναι η πρώτη φορά
					answerStudentFlag = true;
					
					System.out.println(
						"(1) login , (2) logout , (3) show info , "
						+"(4) enroll course web, (5) show grades, "
						+"(6) select other user"
					);
					answer = scanner.nextLine();
					switch (answer) {
						case "login":
						case "1":
							thisStudent.LogIn();
							break;
						case "logout":
						case "2":
							thisStudent.LogOut();
							break;
						case "show info":
						case "3":
							thisStudent.ShowInfo();
							break;
						case "enroll course web":
						case "4":
							thisStudent.EnrollCourse(thisCourseWeb);
							break;
						case "show grades":
						case "5":
							thisStudent.ShowAllGrades();
							break;
						//Except from selecting methods, you can choose to go back and get access...
						//...as another type of user
						case "select other user":
						case "select user":
						case "select":
						case "back":
						case "6":
							answerUser = "back";
							break;
						default:
					}
					break;
				case "Professor":
				case "2":
					answerUserFlag = true;
					if (!answerProfessorFlag) thisProfessor = new Professor(); //δημιουργία αν είναι η πρώτη φορά
					answerProfessorFlag = true;
					
					System.out.println(
							"(1) login , (2) logout , (3) show info ,"
							+"(4) grade student, (5) show grades, "
							+"(6) select other user"
						);
					answer = scanner.nextLine();
					switch (answer) {
						case "login":
						case "1":
							thisProfessor.LogIn();
							break;
						case "logout":
						case "2":
							thisProfessor.LogOut();
							break;
						case "show info":
						case "3":
							thisProfessor.ShowInfo();
							break;
						case "grade student":
						case "4":
							System.out.println("(test enviroment) Give score to 'thisStudent' for course 'thisGradeWeb':");
							try {
								Float value = Float.valueOf(CreateUsers.s.nextLine());
								if (value >=0 && value <=10)
									thisProfessor.GradeStudent(thisStudent, thisGradeWeb, value);
								else System.out.println("Score out of bounds.");
							} catch (Exception e) {
								System.out.println("Invalid Score.");
							}
							break;
						case "show grades":
						case "5":
							thisProfessor.ShowAllGradings();
							break;
						//Except from selecting methods, you can choose to go back and get access...
						//...as another type of user
						case "select other user":
						case "select user":
						case "select":
						case "back":
						case "6":
							answerUser = "back";
							break;
						default:
					}
					break;
				case "Secretary":
				case "3":
					answerUserFlag = true;
					if (!answerSecretaryFlag) thisSecretary = new Secretary(); //δημιουργία αν είναι η πρώτη φορά
					answerSecretaryFlag = true;
					
					System.out.println(
							"(1) login , (2) logout , (3) show info, "
							+"(4) create student, (5) create professor, (6) create course, (7) create grade,"
							+"\n(8) rename course, (9) assing professor, (10) accept all enroll requests, "
							+"(11) select other user"
						);
					answer = scanner.nextLine();
					switch (answer) {
						case "login":
						case "1":
							thisSecretary.LogIn();
							break;
						case "logout":
						case "2":
							scanner.close();
							thisSecretary.LogOut();
							break;
						case "show info":
						case "3":
							thisSecretary.ShowInfo();
							break;
						case "create student":
						case "4":
							System.out.println("Reference of this student instance will not get stored (demonstration only)");
							thisSecretary.CreateStudent();
							break;
						case "create professor":
						case "5":
							System.out.println("Reference of this professor instance will not get stored (demonstration only)");
							thisSecretary.CreateProfessor();
							break;
						case "create course":
						case "6":
							System.out.println("Reference of this course instance will not get stored (demonstration only)");
							thisSecretary.CreateCourse();
							break;
						case "create grade":
						case "7":
							System.out.println("Reference of this grade instance will not get stored (demonstration only)");
							thisSecretary.CreateGrade();
							break;
						case "rename course":
						case "8":
							System.out.println("(test enviroment) Give new name for 'thisCourseWeb':");
							thisSecretary.UpdateCourseName(thisCourseWeb, CreateUsers.s.nextLine());
							break;
						case "assign professor":
						case "assign":
						case "9":
							System.out.println("(Automated action) Assign 'thisProfessor' to 'thisCourseWeb'");
							thisSecretary.AssignProfessorToCourse(thisProfessor, thisCourseWeb);
							break;
						case "accept all enroll requests":
						case "accept all enroll request":
						case "accept enroll requests":
						case "accept enroll request":
						case "accept requests":
						case "accept request":
						case "accept all":
						case "accept":
						case "10":
							System.out.println("Accept all enroll requests for all course");
							thisSecretary.AcceptAllEnrollRequests();
							break;
						//Except from selecting methods, you can choose to go back and get access...
						//...as another type of user
						case "select other user":
						case "select user":
						case "select":
						case "back":
						case "11":
							answerUser = "back";
							break;
						default:
					}
					break;
					
				case "back": //back can be an answer by the method that each user calls
					//A user can select to login,show info etc but can...
					//...also "go back" to selecting other user types
					//so answerUser variable is modified by code and not using UI
					System.out.println("Select User type (only for testing):");
					System.out.println("(1) Student , (2) Professor , (3) Secretary");
					answerUser = scanner.nextLine();
					answerUserFlag = true;
					break;
				default:
					answerUserFlag = false;
					System.out.println("Incorrect User");
			}
		}while (answerUserFlag);
		scanner.close();
	}
}