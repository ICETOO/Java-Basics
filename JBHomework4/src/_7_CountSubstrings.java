import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Write a program to find how many times given string appears in given text as substring.
//The text is given at the first input line. The search string is given at the second input line. 
//The output is an integer number. Please ignore the character casing.

public class _7_CountSubstrings {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String text = scn.nextLine().toLowerCase();
		String word = scn.nextLine().toLowerCase();
		
		Pattern stringPattern = Pattern.compile(word);
		Matcher matcher = stringPattern.matcher(text);
		int count = 0;
		while (matcher.find()) {
			count++;
			int firstIndex = matcher.start();
			matcher.region(firstIndex + 1, text.length());
		}
		System.out.println(count);
	}
}
