import java.util.ArrayList;
import java.util.Scanner;

//Write a program to find all increasing sequences inside an array of integers. 
//The integers are given in a single line, separated by a space.
//Print the sequences in the order of their appearance in the input array, each at a single line. 
//Separate the sequence elements by a space. Find also the longest increasing sequence and print it at the last line.
//If several sequences have the same longest length, print the leftmost of them.

public class _4_IncreasingSequence {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String[] input = scn.nextLine().split(" ");
		int[] sequence = new int[input.length];
		
		ArrayList<Integer> largestSequence = new ArrayList<Integer>();
		ArrayList<Integer> currentSequence = new ArrayList<Integer>();
	
		for (int i = 0; i < input.length; i++) {
			sequence[i] = Integer.parseInt(input[i]);
		}
		largestSequence.add(sequence[0]);
		currentSequence.add(sequence[0]);
		for (int i = 1; i < sequence.length; i++) {
			if (sequence[i - 1] < sequence[i]) {
				System.out.print(sequence[i - 1] + " ");
				currentSequence.add(sequence[i - 1]);

			} else {
				System.out.println(sequence[i - 1]);
				currentSequence.clear();
			}
		}

		if (sequence.length != 1) {
			System.out.println(sequence[sequence.length - 1]);
		}
		System.out.println("Longest: %d");
	}
	

}
