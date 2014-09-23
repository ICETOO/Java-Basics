import java.util.Arrays;
import java.util.Scanner;

//Write a program to enter a number n and n integer numbers and sort and print them.
//Keep the numbers in array of integers: int[].

public class _1_SortNumbers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] inputNumbers = new int[n];
		for (int i = 0; i < n; i++) {
			inputNumbers[i] = scn.nextInt();
		}
		Arrays.sort(inputNumbers);
		for (int i = 0; i < inputNumbers.length; i++) {
			System.out.print(inputNumbers[i] + " ");
		}
	}
}
