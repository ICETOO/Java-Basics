import java.util.Scanner;

public class _3_PointsInsideFigure {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double x = input.nextDouble();
		double y = input.nextDouble();
		
		boolean isInFigureOne = (x >= 12.5 && x <= 22.5 && y >= 6 && y <= 8.5);
		boolean isInFigureTwo = (x >= 12.5 && x <= 17.5 && y >= 8.5 && y <= 13.5);
		boolean isInFigureThree = (x >= 20 && x <= 22.5 && y >= 8.5 && y <= 13.5);
		
		if (isInFigureOne || isInFigureTwo || isInFigureThree) {
			System.out.println("Inside");
		}
		else {
			System.out.println("Outside");
		}
	}
}