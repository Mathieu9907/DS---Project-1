// Authors: Mathieu Berthier and Jason Zou

import instructor.ResArrayBag;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GuessingGame {

	public static LBag<Integer> createArray(int numberOfIntegers, int rangeLimit) {
		LBag<Integer> arr = new LBag<>();
		
		for (int i = 0; i < numberOfIntegers; i++) {
			arr.add((int) (Math.random() * rangeLimit) + 1);
		}
		
		return arr;
	}
	
	public static LBag<Integer> convertToIntArray(String str) {
		LBag<Integer> intBag = new LBag<>();
		int lastPostSpaceIndex = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				intBag.add(Integer.parseInt(str.substring(lastPostSpaceIndex, i - 1)));
				if (i + 1 < str.length()) {
					lastPostSpaceIndex = i + 1;
				}
			}
		}
		
		return intBag;
	}
	
	public static ArrayList<LBag<Integer>> startGame(Scanner input) {
		input = new Scanner(System.in);
		ArrayList<LBag<Integer>> solutionAndGuessBag = new ArrayList<>();
		
		System.out.print("How many integers would you like to guess? ");
		int numberOfIntegers = input.nextInt();
		System.out.print("What should the range of each integer be (1 to n)?\n\tn = ");
		int rangeLimit = input.nextInt();
		
		LBag<Integer> solutionBag = createArray(numberOfIntegers, rangeLimit);
		
		System.out.println("Enter 4 integers in the range 1 to " + rangeLimit + ". Entries may be duplicate.");
		String guess = input.next();
		LBag<Integer> guessBag = convertToIntArray(guess);
		
		solutionAndGuessBag.add(solutionBag);
		solutionAndGuessBag.add(guessBag);
		
		return solutionAndGuessBag;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		ArrayList<LBag<Integer>> solutionAndGuessBag = startGame(input);
		LBag<Integer> solutionBag = solutionAndGuessBag.get(0);
		LBag<Integer> guessBag = solutionAndGuessBag.get(1);
		
		int intersectVal;
		
		do {
			intersectVal = solutionBag.intersection(guessBag);
			if (intersectVal == 4) {
				System.out.println("Well done! Play again?");
				if (input.equals("Yes")) {
					startGame(input);
				}
				System.exit(0);
			}
			else {
				System.out.println(intersectVal + " of your guesses are correct. Guess again");
			}
		} while (!input.equals("quit"));
		
		
		
		
	}

}
