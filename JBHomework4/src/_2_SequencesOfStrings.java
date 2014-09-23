import java.util.Scanner;

//Write a program that enters an array of strings and finds in it all sequences of equal elements. 
//The input strings are given as a single line, separated by a space.

public class _2_SequencesOfStrings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String[] words = scn.nextLine().split(" ");
		
		if (words.length == 1) {
			System.out.println(words[0]);
		}
		
		for (int i = 0; i < words.length - 1; i++) {
			if (words[i].equals(words[i + 1])) {
				System.out.print(words[i] + " ");

			} else {
				System.out.println(words[i]);
			}
		}
		
		if (words.length != 1) {
			System.out.print(words[words.length - 1]);
		}
	}
}
