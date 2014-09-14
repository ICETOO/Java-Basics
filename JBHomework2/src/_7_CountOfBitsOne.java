import java.util.Scanner;

//Write a program to calculate the count of bits 1 in the binary representation of given integer number n.

public class _7_CountOfBitsOne {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a = input.nextInt();
		int counter = 0;
		
		for (int i = 0; i < 32; i++) {
			int someNumber = (a >> i);
			if ((someNumber & 1) == 1) {
				counter++;
			}
		}
		System.out.println(counter);
	}
}
