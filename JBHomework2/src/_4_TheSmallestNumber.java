import java.util.Arrays;
import java.util.Scanner;

//Write a program that finds the smallest of three numbers.

public class _4_TheSmallestNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] smallest = new int[3];
		for (int i = 0; i < 3; i++) {
			 smallest[i] = input.nextInt();
		}
		
		Arrays.sort(smallest);
		System.out.println(smallest[0]);
	}

}
