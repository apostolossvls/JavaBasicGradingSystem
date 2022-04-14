package fileManagement;

import java.io.*;

public class SaveManager {
	
	public static boolean Save(Object obj, String pathName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(pathName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(obj);
			out.close();
			fileOut.close();
			System.out.println("Saved in "+pathName);
			}
		catch (IOException i) {
			i.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static Object Load (String path) {
		System.out.println("Reading from memory.");
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Object obj = in.readObject();
			in.close();
			fileIn.close();
			return obj;
		} 
		catch (FileNotFoundException f) {
			//f.printStackTrace();
			System.out.println("File not found.");
			return null;
		}
		catch (IOException i) {
			i.printStackTrace();
			return null;
		}
		catch (ClassNotFoundException c) {
			c.printStackTrace();
			return null;
		}
	}
}
