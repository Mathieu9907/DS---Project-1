// Authors: Mathieu Berthier and Jason Zou

import instructor.ResArrayBag;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GuessingGame {

	public static LBag<Integer> createBag(int numberOfIntegers, int rangeLimit) {
		LBag<Integer> arr = new LBag<>();
		
		for (int i = 0; i < numberOfIntegers; i++) {
			arr.add((int) (Math.random() * rangeLimit) + 1);
		}
		
		return arr;
	}
	
	public static LBag<Integer> convertToIntBag(String str) {
		LBag<Integer> intBag = new LBag<>();
		String[] strArray = str.split(" ");
		
		for (int i = 0; i < strArray.length; i++) {
			intBag.add(Integer.parseInt(strArray[i]));
		}
		
		return intBag;
	}
	
	/*
	@SuppressWarnings("resource")
	public static ArrayList<LBag<Integer>> startGame(Scanner input) {
		input = new Scanner(System.in);
		ArrayList<LBag<Integer>> solutionAndGuessBag = new ArrayList<>();
		
		System.out.print("How many integers would you like to guess? ");
		int numberOfIntegers = input.nextInt();
		System.out.print("What should the range of each integer be (1 to n)?\n\tn = ");
		int rangeLimit = input.nextInt();
		
		LBag<Integer> solutionBag = createArray(numberOfIntegers, rangeLimit);
		
		System.out.println("Enter " + numberOfIntegers
				+ " integers in the range 1 to " + rangeLimit + ". Entries may be duplicate.");
		String guess = input.next();
		LBag<Integer> guessBag = convertToIntArray(guess);
		
		solutionAndGuessBag.add(solutionBag);
		solutionAndGuessBag.add(guessBag);
		
		return solutionAndGuessBag;
	}
	*/
	
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		int intersectVal;
		
		do {
			System.out.print("How many integers would you like to guess? ");
			int numberOfIntegers = input.nextInt();
			System.out.print("What should the range of each integer be (1 to n)?\n\tn = ");
			int rangeLimit = input.nextInt();
			
			LBag<Integer> solutionBag = createBag(numberOfIntegers, rangeLimit);
			LBag<Integer> guessBag;
			int numberOfMatches;
			
			String newLineCleaner = input.nextLine(); // removes "new line" symbol
			
			do {
				System.out.printf("Enter " + numberOfIntegers
						+ " integer%s in the range 1 to " + rangeLimit + ". Entries may be duplicate.%n",
						numberOfIntegers > 1 ? "s" : "");
				
				String guess = input.nextLine();
				guessBag = convertToIntBag(guess);
				
				while (guessBag.getCurrentSize() > solutionBag.getCurrentSize()) {
					System.out.println("Too many numbers in guess!");
					guess = input.nextLine();
					guessBag = convertToIntBag(guess);
				}
			    numberOfMatches = solutionBag.intersection(guessBag);
			    
				if (numberOfMatches < numberOfIntegers)
					System.out.println(numberOfMatches + " of your guesses are correct.");

			} while (numberOfMatches < numberOfIntegers);
			
			System.out.print("Congrats! The right combination was ");
			
			Object[] solutionArray = solutionBag.toArray();
			
			for (int i = 0 ; i < solutionBag.getCurrentSize() ; i++) {
				System.out.print(solutionArray[i] + " ");
			}
			
			System.out.print("\nPlay again? ");
			
		} while (input.nextLine().equalsIgnoreCase("Yes"));
		
		System.exit(0);
		
		
		
	}

}
