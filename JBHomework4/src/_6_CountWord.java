import java.util.Scanner;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;


//Write a program to find how many times a word appears in given text. The text is given at the first input line. 
//The target word is given at the second input line. The output is an integer number.
//Please ignore the character casing. Consider that any non-letter character is a word separator. 

public class _6_CountWord {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String text = scn.nextLine().toLowerCase();
		String word = scn.nextLine().toLowerCase();
		String[] counter = null;
		if (word.length() > 1) {
			counter = text.split("\\b" + word);
			System.out.println(counter.length - 1);
		}else if (word.length() == 1) {
			counter = text.split(" " + word + "\\b");
			System.out.println(counter.length -1);
		}
	}
}
