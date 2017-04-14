package dostupidcrap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
	static Scanner scanner;

	public static void main(String[] args) {
		File file = new File("in.txt");
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = new String(); 
		while(scanner.hasNextLine()){
			s = scanner.nextLine();
			stringToIntArray(s);
		}
	}

	public static void stringToIntArray(String s){
			byte[] f = s.getBytes();
			for (int i = 0; i < f.length; i++){
				f[i] = (byte) (f[i] - 16);
			}

			System.out.println(s);
	}
}
