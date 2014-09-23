import java.util.ArrayList;
import java.util.Scanner;

//Write a program that enters an array of strings and finds in it the largest sequence of equal elements. 
//If several sequences have the same longest length, print the leftmost of them. 
//The input strings are given as a single line, separated by a space.

public class _3_LargestSequence {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String[] words = scn.nextLine().split(" ");

		ArrayList<String> largestSequence = new ArrayList<String>();
		ArrayList<String> currentSequence = new ArrayList<String>();

		largestSequence.add(words[0]);
		currentSequence.add(words[0]);
		for (int i = 1; i < words.length; i++) {
			if (!words[i].equals(words[i - 1])) {
				currentSequence.clear();
			}
			currentSequence.add(words[i]);
			if (currentSequence.size() > largestSequence.size()) {
				largestSequence = new ArrayList<String>(currentSequence);
			}
		}
		for (String word : largestSequence) {
			System.out.printf("%s ", word);
		}
	}
}
