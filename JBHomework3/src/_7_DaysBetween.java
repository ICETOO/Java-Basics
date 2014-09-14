import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//Write a program to calculate the difference between two dates in number of days.
//The dates are entered at two consecutive lines in format day-month-year. 
//Days are in range [1…31]. Months are in range [1…12]. Years are in range [1900…2100]

public class _7_DaysBetween {

	public static void main(String[] args) throws ParseException{
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat formater=new SimpleDateFormat("dd-MM-yyyy");
		String fistDateStr = sc.nextLine();
		String SecondDateStr = sc.nextLine();
		long d1=formater.parse(fistDateStr).getTime();
		long d2=formater.parse(SecondDateStr).getTime();
		System.out.println((d2-d1)/(1000*60*60*24));
	}
}