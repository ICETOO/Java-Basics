import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//We are given a sequence of N playing cards from a standard deck. The input consists of several cards (face + suit), 
//separated by a space. Write a program to calculate and print at the console the frequency of each card face in format 
//"card_face -> frequency". The frequency is calculated by the formula appearances / N and is expressed in percentages
//with exactly 2 digits after the decimal point. The card faces with their frequency should be printed in the order of
//the card face's first appearance in the input. The same card can appear multiple times in the input, but it's face 
//should be listed only once in the output. 

public class _12_CardFrequecies {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String[] cards = scn.nextLine().split(" ");
		Map<String, Integer> faces = new HashMap<>();
		for (int i = 0; i < cards.length; i++) {
			String cardFace = cards[i].substring(0, cards[i].length() - 1);
			if (faces.containsKey(cardFace)) {
				int newValue = faces.get(cardFace) + 1;
				faces.put(cardFace, newValue);
			} else {
				faces.put(cardFace, 1);
			}
		}
		double percentagePerCards = (double) 100 / cards.length;
		for (String face : faces.keySet()) {
			double percentagePerFace = percentagePerCards * faces.get(face);
			System.out.printf("%s -> %.2f%%\n", face, percentagePerFace);
		}
	}
}