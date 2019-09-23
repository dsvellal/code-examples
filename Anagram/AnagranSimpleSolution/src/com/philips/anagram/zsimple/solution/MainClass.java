package com.philips.anagram.zsimple.solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Main class that's responsible to figuring out whether given two strings
 * are anagrams or not.
 * 
 * @author dattatrv
 *
 */
public class MainClass {

	/**
	 * Main method that executes when the program is run.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			final Scanner scanner = new Scanner(System.in);
			System.out.println("Enter LHS: ");
			final String lhs = getInput(scanner);
			validate(lhs);
			System.out.println("Enter RHS: ");
			final String rhs = getInput(scanner);
			validate(rhs);

			System.out.println("Is " + lhs + " an anagram of " + rhs + "?");
			System.out.println(isAnagram(lhs, rhs));
		} catch (final IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace(System.out);
		}
	}

	/**
	 * Method to get the input from the user.
	 * @param scanner
	 * @return
	 */
	private static String getInput(Scanner scanner) {
		return scanner.nextLine();
	}

	/**
	 * Method to validate the input given by the user.
	 * @param string
	 */
	private static void validate(String string) {
		if (string == null || string.isEmpty()) {
			throw new IllegalArgumentException(
					"You have entered an invalid string");
		}
	}
	
	/**
	 * Method to process the input given by the user.
	 * @param string
	 * @return
	 */
	private static String processString(String string) {
		final String step1processedString = string.replaceAll(" ", "");
		final String step2ProcessedString = step1processedString.replaceAll(",", "");
		final String step3ProcessedString = step2ProcessedString.replaceAll(".", "");

		return step3ProcessedString;
	}

	/**
	 * Method to figure out whether given two strings are anagrams or not.
	 * The logic here is to:
	 * a) Process the strings to remove punctuation marks.
	 * b) Sort the alphabets of the strings.
	 * c) Compare them, in a case-insensitive manner.
	 * If they are equal, then the strings are anagrams. If not, they are not anagrams.
	 * @param lhs
	 * @param rhs
	 * @return
	 */
	private static boolean isAnagram(String lhs, String rhs) {
		final String processedLHS = processString(lhs);
		final String processedRHS = processString(rhs);

		final String sortedLHS = sortString(processedLHS);
		final String sortedRHS = sortString(processedRHS);

		return sortedLHS.equalsIgnoreCase(sortedRHS);
	}

	/**
	 * Method to the alphabets of a string.
	 * The logic here is to leverage java API to sort the array
	 * & not to write our own sorting algorithm.
	 * @param string
	 * @return
	 */
	private static String sortString(String string) {
		final char[] charactersOfString = string.toCharArray();
		Arrays.sort(charactersOfString);
		return new String(charactersOfString);
	}

}
