import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


//Create a class Product to hold products, which have name (string) and price (decimal number). 
//Read from a text file named "Input.txt" a list of products. Each product will be in format name + space + price.
//You should hold the products in objects of class Product
// Sort the products by price and write them in format price + space + name in a file named "Output.txt". 
//Ensure you close correctly all used resources.

public class _9_ListOfProducts {

	public static void main(String[] args) throws FileNotFoundException{
		
		ArrayList<String> input = new ArrayList<String>();
		Scanner fileScanner = new Scanner(new File("file.txt"));
		while (fileScanner.hasNext()) {
			input.add(fileScanner.next());
		}

		
		
		

	}

}
