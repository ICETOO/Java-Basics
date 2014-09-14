import java.util.Scanner;


//Write a program to generate and print all symmetric numbers in given range [start…end] (0 ≤ start ≤ end ≤ 999). 
//A number is symmetric if its digits are symmetric toward its middle. 
//For example, the numbers 101, 33, 989 and 5 are symmetric, but 102, 34 and 997 are not symmetric. 

public class _1_SymmetricNumbersInRange {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int start = input.nextInt();
		int end = input.nextInt();
		for (int i = start; i <= end; i++) {
			if (i < 10) {
				System.out.println(i);
			}
			else if (i > 10 && i < 100 ) {
				if (i % 11 == 0) {
					System.out.println(i);
				}
			}
			else if (i > 100 && i < 999 ) {
				int c = i % 10;
				int b = ((i - c)  % 100) / 10;
				int a = (i - (b * 10 + c)  % 1000) / 100;
				
				if (a == c || (((a + c) / 2.0) == b && (a + c - 2) / 2.0 == b)) {
					System.out.println(i);
				}
			}
		}
	}
}
