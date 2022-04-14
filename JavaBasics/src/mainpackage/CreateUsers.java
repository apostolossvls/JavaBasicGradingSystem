package mainpackage;

import java.util.ArrayList;
import java.util.Scanner;

import fileManagement.SaveManager;
import userManagement.*;

import java.io.*;

public class CreateUsers implements Serializable {
	
	//auto generated serialVersionUID
	private static final long serialVersionUID = -6770288624567376574L;

	public static final Scanner s = new Scanner(System.in); //One and only scanner for the program
	
	public static void main(String[] args) {
		
		/*
		//Προσπάθεια ανάγνωσης λίστας allUsers από αρχείο
		Object objUsers = SaveManager.Load("users.txt");
		if (objUsers != null) {
			User.allUsers = (ArrayList<User>) objUsers;
			System.out.println("Data retrieved successfully.");
		}
		
		//Προσπάθεια ανάγνωσης λίστας programs από αρχείο
		objUsers = SaveManager.Load("programs.txt");
		if (objUsers != null) {
			Admin.programs = (ArrayList<Program>) objUsers;
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
	
	static void Auto() {
		
		//create 3 users one of each
		System.out.println("* Creating 3  users.");
		Student thisStudent = new Student();
		//Admin thisAdmin = new Admin();
		System.out.println("* 3  users got created. \n");
		
		System.out.println("* Starting automatic calling methods.\n");
		
		//calling methods "register"
		System.out.println("* Registering all users:");
		System.out.println("* Register 'Student' with username:'foo1', password: '12345', name: 'nameFoo1', surname: 'dummy1', Registration Number: 'p12345'");
		//thisStudent.Register("foo1", "12345", "nameFoo1", "dummy1", "p12345");
		System.out.println("* Register 'Seller' with username:'foo2', password: '12345', name: 'nameFoo2', surname: 'dummy2'");
		//thisSeller.Register("foo2", "12345", "nameFoo2", "dummy2");
		System.out.println("* Register 'Administrator' with username:'foo3', password: '12345', name: 'nameFoo3', surname: 'dummy3'");
		//thisAdmin.Register("foo3", "12345", "nameFoo3", "dummy3");
		System.out.println("* All accounts registered. \n");
		
		//calling methods "Login"
		System.out.println("* Login with all users:");
		System.out.println("* Login 'Client' with username:'foo1', password: '12345'");
		thisStudent.LogIn("foo1", "12345");
		System.out.println("* Login 'Seller' with username:'foo2', password: '12345'");
		//thisSeller.LogIn("foo2", "12345");
		System.out.println("* Login 'Administrator' with username:'foo3', password: '12345'");
		//thisAdmin.LogIn("foo3", "12345");
		System.out.println("* All accounts are logged in. \n");
		
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
		System.out.println("* Completed.\n");
		
		System.out.println("* Finally, Log out from a user and save user to file:");
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