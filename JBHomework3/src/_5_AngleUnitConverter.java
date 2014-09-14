import java.util.Scanner;

//Write a method to convert from degrees to radians. Write a method to convert from radians to degrees. 
//You are given a number n and n queries for conversion. Each conversion query will consist of a number + space + measure. 
//Measures are "deg" and "rad". Convert all radians to degrees and all degrees to radians.
//Print the results as n lines, each holding a number + space + measure. Format all numbers with 6 digit after the decimal point.


public class _5_AngleUnitConverter {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			double getNum = input.nextDouble();
			String measure = input.next();
			double converted = unitConverter(getNum, measure);
			System.out.printf("%.6f",converted);
		}
	}
	private static double unitConverter(double value, String measure) {
		if (measure.equals("rad"))
			return Math.toDegrees(value);
		else
			return Math.toRadians(value);
	}

}
