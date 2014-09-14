import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;


//Write a program to read a text file "Input.txt" holding a sequence of integer numbers, each at a separate line.
//Print the sum of the numbers at the console. Ensure you close correctly the file in case of exception or in case of normal execution.
//In case of exception (e.g. the file is missing), print "Error" as a result.

public class _8_SumNumbers {

	public static void main(String[] args) throws FileNotFoundException{
		ArrayList<Integer> integers = new ArrayList<Integer>();
		Scanner fileScanner = new Scanner(new File("file.txt"));
		while (fileScanner.hasNextInt()){
			integers.add(fileScanner.nextInt());
		}
		long sum =0;
		for (int i = 0; i < integers.size(); i++) {
			sum +=integers.get(i);
		}
		System.out.println(sum);
	}
}