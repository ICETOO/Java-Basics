import java.util.Random;
import java.util.Scanner;

//Write a program to generate n random hands of 5 different cards form a standard suit of 52 cards.

public class _6_RandomHands {

	public static void main(String[] args) {
		
		String[] faces = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
				"Q", "K", "A" };
			char[] suits = { '♣', '♦', '♥', '♠' };
			Scanner input = new Scanner(System.in);
				
			String[] deckCards = new String[52];
			int i =0;
			for (String c : faces) {
				for (char ca : suits) {
					deckCards[i] = c+ca;
					i++;	
					}
				}
			int n = input.nextInt();
				
			Random rnd = new Random();
				for (int j = 0; j < n; j++) {
					for (int j1 = 0; j1 < 5; j1++) {
						int random = rnd.nextInt(52);
						System.out.print(deckCards[random]);
				}
				System.out.println();
				}
	}
}
