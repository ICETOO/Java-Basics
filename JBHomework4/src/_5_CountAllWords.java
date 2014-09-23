import java.util.ArrayList;
import java.util.Scanner;


//Write a program to count the number of words in given sentence. Use any non-letter character as word separator.

public class _5_CountAllWords {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String text = scn.nextLine();
		String[] words = text.split("([A-Z]*[a-z]*)\\w+");
		
		int counter = words.length - 1;
		System.out.println(counter);
		

	}

}
