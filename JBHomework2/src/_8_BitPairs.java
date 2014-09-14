import java.util.Scanner;


//Write a program to count how many sequences of two equal bits ("00" or "11") can be found in
//the binary representation of given integer number n (with overlapping).

public class _8_BitPairs {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int binary = input.nextInt();
		String number = Integer.toBinaryString(binary);
		int pairs = 0;
		for (int i = 0; i < number.length() ; i++) {
			if ((((binary >> i) & 1) == 1) && (((binary >> i + 1) & 1) == 1)) {
				pairs++;
			}else if ((((binary >> i) & 1) == 0) && (((binary >> i + 1) & 1) == 0)) {
				pairs++;
			}else {
				
			}
		}
		System.out.println(pairs);
	}
}
