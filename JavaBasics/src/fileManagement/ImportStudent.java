package fileManagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import userManagement.Student;


public class ImportStudent {
	
	// one student per line, userName@password@name@surname@registrationNumber, no spaces, the registrationNumber must contain only digits 
 
	public static void  Import(String path) throws FileNotFoundException {
		 // Creating an instance of Inputstream
        InputStream is = new FileInputStream(path);
 
        // Try block to check for exceptions
        try (Scanner sc = new Scanner( is, StandardCharsets.UTF_8.name())) {
 
            // It holds true till there is single element left in the object with usage of hasNext() method
            while (sc.hasNextLine()) {
            	
            	String line = sc.nextLine();
                String[] arrOfStr = line.split("@", 0);
                
                try {
                	 Integer num = Integer.valueOf(arrOfStr[4]);
                	 Student student = new Student(arrOfStr[0],arrOfStr[1],arrOfStr[2],arrOfStr[3],num);
                     
                     student.ShowInfo();
                }catch(NumberFormatException e) {
                	 System.out.println("Make sure the Registration Number cointains only Digits");
                }catch(ArrayIndexOutOfBoundsException e) {
                	System.out.println("Make sure the text is properly formatted");
                }
               
              
                
            }
        }
	}
}