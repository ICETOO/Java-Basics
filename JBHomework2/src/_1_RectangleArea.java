import java.util.Scanner;

//Write a program that enters the sides of a rectangle (two integers a and b)
//and calculates and prints the rectangle's area.

public class _1_RectangleArea {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter two integers for sides of rectangle.");
		int a = input.nextInt();
		int b = input.nextInt();
		int area = a * b;
		System.out.println("The are is: " + area);
	}
}
