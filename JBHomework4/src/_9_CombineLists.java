import java.util.ArrayList;
import java.util.Scanner;

//Write a program that reads two lists of letters l1 and l2 and combines them:
//appends all letters c from l2 to the end of l1, but only when c does not appear in l1. 
//Print the obtained combined list.
//All lists are given as sequence of letters separated by a single space, each at a separate line. 
//Use ArrayList<Character> of chars to keep the input and output lists.

public class _9_CombineLists {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String firstLine = scn.nextLine();
		String secondLine = scn.nextLine();

		ArrayList<Character> firstList = new ArrayList<Character>();

		for (int i = 0; i < firstLine.length(); i += 2) {
			firstList.add(firstLine.charAt(i));
		}

		ArrayList<Character> secondList = new ArrayList<Character>();

		for (int i = 0; i < secondLine.length(); i += 2) {
			secondList.add(secondLine.charAt(i));
		}
		secondList.removeAll(firstList);
		firstList.addAll(secondList);
		for (Character ch : firstList) {
			System.out.print(ch + " ");
		}
	}
}
