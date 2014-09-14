import java.util.Scanner;

//Write a program that enters 3 points in the plane (as integer x and y coordinates), 
//calculates and prints the area of the triangle composed by these 3 points. 
//Round the result to a whole number. In case the three points do not form a triangle, 
//print "0" as result.
public class _2_TriangleArea {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int xA = input.nextInt();
		int yA = input.nextInt();
		int xB = input.nextInt();
		int yB = input.nextInt();
		int xC = input.nextInt();
		int yC = input.nextInt();
		
		int area = (int)Math.abs((xA * (yB - yC) + xB * (yC - yA) + xC * (yA - yB)) / 2);
		
		System.out.printf("The area is: %d", area);
	}
}