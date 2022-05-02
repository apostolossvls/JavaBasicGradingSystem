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
					//SimulateUI();
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
		
		System.out.println("*--- Secretary methods ---*\n");
		
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
		
		System.out.println("* Other methods will be demonstrated later. (Accept enroll requests etc)\n");
		
		System.out.println("*--- Professor methods ---*\n");
		
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
		
		//admin
		/*
		System.out.println("*--- Admin methods ---*\n");
		
		System.out.println("* 'Admin' creates a 'Client' (Waiting for input):");
		thisAdmin.CreateUser();
		System.out.println("* Creation completed.\n");
		
		System.out.println("* Show all users:");
		thisAdmin.ShowAllUsers();
		System.out.println("* Completed.\n");
		
		System.out.println("* 'Admin' updates a client's information (Waiting for input):");
		thisAdmin.UpdateUser();
		System.out.println("* Update completed.\n");
		
		System.out.println("* Search for user:");
		thisAdmin.SearchUser();
		System.out.println("* Completed.\n");
		
		System.out.println("* Delete a user:");
		thisAdmin.RemoveUser();
		System.out.println("* Completed.\n");
		
		System.out.println("* 'Admin' creates an 'Admin':");
		thisAdmin.CreateAdmin();
		System.out.println("* Completed.\n");
		
		//program
		System.out.println("* Add 2 programs:");
		System.out.println("* Adding a program with name:"
			+ "'program1', benefits: '500', fixed charge: '20', extra charge per minute: 0.2");
		thisAdmin.AddProgram("program1", 500f, 20f, 0.2f);
		System.out.println("* Completed.");
		System.out.println("* Adding a program with name:"
			+ "'program2', benefits: '1000', fixed charge: '30', extra charge per minute: 0.2");
		thisAdmin.AddProgram("program2", 1000f, 30f, 0.2f);
		System.out.println("* Completed.\n");
		
		System.out.println("* Show all programs");
		thisAdmin.ShowPrograms();
		System.out.println("* Completed.\n");
		
		System.out.println("* Remove a program:");
		System.out.println("* Removing program with index: 0");
		thisAdmin.RemoveProgram(0);
		System.out.println("* Completed.\n");
		
		//seller
		System.out.println("*--- Seller methods ---*\n");
		
		System.out.println("* Add the client to the Seller's clients:");
		thisSeller.InsertClient(thisClient);
		System.out.println("* Completed.\n");
		
		System.out.println("* Show all of his clients:");
		thisSeller.ShowClients();
		System.out.println("* Completed.\n");
		
		System.out.println("* Set the client's program :");
		System.out.println("* Setting this client's program to program with index 0:");
		thisSeller.ChangeClientProgram(thisClient.GetPhoneNumber(), Admin.programs.get(0));
		System.out.println("* Completed.\n");
		
		System.out.println("* Create a bill for the client:");
		thisSeller.CreateBill(thisClient.GetPhoneNumber(), 1);
		System.out.println("* Completed.\n");
		
		System.out.println("* Remove the client to the Seller's clients:");
		thisSeller.RemoveClient(thisClient);
		System.out.println("* Completed.\n");
		*/
		
		//Student
		System.out.println("*--- Student methods ---*\n");
		
		System.out.println("* Shows info of 'Student':");
		thisStudent.ShowInfo();
		
		System.out.println("* Finally, Log out from a user:");
		thisStudent.LogOut();
	}
	
	/*
	static void SimulateUI() {
		//για την πρώτη άσκηση όπου η υλοποίηση δεν έχει ολοκληρωθεί, υπάρχει ο παρακάτω τρόπος user interface
		//στην αρχή ο χρήστης επιλέγει το account / δικαιώματα όπου θα έχει
		//μετά μπορεί να επιλέγει τις λειτουργείες όπου του επιτρέπονται και να τις εκτελεί
		System.out.println("Account (only for testing):");
		System.out.println("(1) Client , (2) Seller , (3) Admin");
		
		Scanner scanner = new Scanner(System.in);
		String answerAccount = scanner.nextLine();
		
		boolean answerAccountflag=false; //αν επιλεχθηκε σωστό account
		do {
			System.out.println("*-----------*");
			System.out.println("Enter Action");
			String answer;
			switch (answerAccount) {
				case "Client":
				case "1":
					answerAccountflag=true;
					Client thisClient = new Client();
					System.out.println(
						"(1) login , (2) logout , (3) register ,"
						+ "(4) Call (5) ShowInfo , (6) ShowCallHistory , (7) PayBill"
					);
					answer = scanner.nextLine();
					switch (answer) {
						case "login":
						case "1":
							thisClient.LogIn();
							break;
						case "logout":
						case "2":
							thisClient.LogOut();
							break;
						case "register":
						case "3":
							thisClient.Register();
							break;
						case "Call":
						case "4":
							thisClient.MakeCall();
							break;
						case "ShowInfo":
						case "5":
							thisClient.ShowInfo();
							break;
						case "ShowCallHistory":
						case "6":
							thisClient.ShowCallHistory();
							break;
						case "PayBill":
						case "7":
							thisClient.PayBill();
							break;
						default:
					}
					break;
				case "Seller":
				case "2":
					answerAccountflag=true;
					Seller thisSeller = new Seller();
					System.out.println(
						"(1) login , (2) logout , (3) register ,"
						+ "(4) ShowClients , (5) InsertClient , (6) RemoveClient ,"
						+ "(7) CreateBill , (8) ChangeClientProgram"
					);
					answer = scanner.nextLine();
					switch (answer) {
						case "login":
						case "1":
							thisSeller.LogIn();
							break;
						case "logout":
						case "2":
							thisSeller.LogOut();
							break;
						case "register":
						case "3":
							thisSeller.Register();
							break;
						case "ShowClients":
						case "4":
							thisSeller.ShowClients();
							break;
						case "InsertClient":
						case "5":
							System.out.println("Not yet implemented using UI");
							break;
						case "RemoveClient":
						case "6":
							thisSeller.RemoveClient();
							break;
						case "CreateBill":
						case "7":
							thisSeller.CreateBill();
							System.out.println("Not yet implemented using UI");
							break;
						case "ChangeClientProgram":
						case "8":
							thisSeller.ChangeClientProgram();
							break;
						default:
					}
					break;
				case "Admin":
				case "3":
					answerAccountflag=true;
					Admin thisAdmin = new Admin();
					System.out.println(
						"(1) login , (2) logout , (3) register ,"
						+ "(4) CreateUser , (5) UpdateUser , (6) RemoveUser ,"
						+ "(7) SearchUser , (8) ShowAllUsers"
						+ "(9) AddProgram , (10) RemoveProgram, (11) ShowPrograms"
					);
					answer = scanner.nextLine();
					switch (answer) {
						case "login":
						case "1":
							thisAdmin.LogIn();
							break;
						case "logout":
						case "2":
							scanner.close();
							thisAdmin.LogOut();
							break;
						case "register":
						case "3":
							thisAdmin.Register();
							break;
						case "CreateUser":
						case "4":
							thisAdmin.CreateUser();
							break;
						case "UpdateUser":
						case "5":
							thisAdmin.UpdateUser();
							break;
						case "RemoveUser":
						case "6":
							thisAdmin.RemoveUser();
							break;
						case "SearchUser":
						case "7":
							thisAdmin.SearchUser();
							break;
						case "ShowAllUsers":
						case "8":
							thisAdmin.ShowAllUsers();
							break;
						case "AddProgram":
						case "9":
							thisAdmin.AddProgram();
							break;
						case "RemoveProgram":
						case "10":
							thisAdmin.RemoveProgram();
							break;
						case "ShowPrograms":
						case "11":
							thisAdmin.ShowPrograms();
							break;
						default:
					}
					break;
				default:
					answerAccountflag=false;
					System.out.println("Incorrect Account");
			}
		}while (answerAccountflag);
		scanner.close();
	}
	*/
}