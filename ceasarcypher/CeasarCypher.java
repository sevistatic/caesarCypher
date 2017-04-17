package ceasarCypher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

//TODO figure out what the input text says.
//TODO remember how to package into a .jar file
//TODO implement guards on helper methods

public class CeasarCypher {
	static Scanner scanner;

	public static void main(String[] args) {
		File file = new File("in1.txt");
		String encodedString = new String();

		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while(scanner.hasNextLine()){
			encodedString = scanner.nextLine();
			displayAllShifts(encodedString);
		}
	}

/**
*	Shifts the text repeatedly until all possible letter shifts have been done.
*/
	public static void displayAllShifts(String encodedString){
		for (int amountToShift = 0; amountToShift < 26; amountToShift++){
			String decodedString = shiftRight(encodedString, amountToShift);
			System.out.println(amountToShift + " -> " + decodedString);
			System.out.println();
		}
	}

	/**
	* Shifts the letters in the string forward by the amount shifted, wrapping
	* back to the beginning of the alphabet
	*/
	public static String shiftRight(String encodedString, int amountToShift){
		ArrayList<Character> decodedCharArray = new ArrayList<Character>();

		for (char character : encodedString.toLowerCase().toCharArray()){
			if (isALetter(character)){
				int index = charToIndex(character);
				int shiftedIndex = (index + amountToShift) % 26;//shift to new index
				decodedCharArray.add(indexToChar(shiftedIndex));
			}
			else{
				decodedCharArray.add(character);//don't shift
			}
		}
		return arrayListOfCharsToString(decodedCharArray);
	}

	/**
	* converts an ArrayList of type Character into a String
	*/
	public static String arrayListOfCharsToString(ArrayList<Character> list){
		String result = "";
		for (int i = 0; i < list.size(); i++){
			result =  result + list.get(i);
		}
		return result;
	}

	/**
	* returns true if the character falls within the ASCII table for lowercase letters
	* @param character must be a lowercase character
	*/
	public static boolean isALetter(char character){
		int charNumber = ((int)character) - 97;
		return (charNumber >= 0 && charNumber <= 25);
	}

	/**
	* converts a lowercase character to its index in the alphabet.
	* e.g. a is 0, b is 1, etc.
	* @param character must be a lowercase character
	*/
	public static int charToIndex(char character){
		return ((int)character) - 97;
	}

	/**
	* converts from an alphabet index to a lowercase character
	* @param index must be an integer between 0 and 25
	*/
	public static char indexToChar(int index){
		return (char)(index + 97);
	}
}
