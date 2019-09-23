/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */

package philips.swcoe.xpers.samples.tdd.main;

import java.util.Arrays;
import philips.swcoe.xpers.samples.tdd.utility.AnagramValidationUtility;

/**
 * This class checks if two given strings are anagrams of each other or not.
 *
 * @author dsvellal
 */
public class Anagram {
  private static final String IS = "is";
  private static final String IS_NOT = "is not";

  private static Anagram anagramInstance = null;

  private Anagram() {

  }

  /**
   * Method to return the singleton instance of anagram.
   *
   * @return
   */
  public static Anagram getInstance() {
    if (anagramInstance == null) {
      anagramInstance = new Anagram();
    }

    return anagramInstance;
  }

  /**
   * This method checks if two given strings, string1, and string2 are anagrams of each other or
   * not. It does so by doing the following: 1. Checking if both strings have same length 2. Sorting
   * the strings, and check if the sorted strings are same or not.
   *
   * @param subject - first string
   * @param candidate - second string
   * @return
   */
  public String isAnagram(final String subject, final String candidate) {
    final boolean isAnagram;

    try {
      AnagramValidationUtility.getInstance().validateInput(subject, candidate);
    } catch (final IllegalArgumentException e) {
      return e.getMessage();
    }

    final String processedSubject = preProcess(subject);
    final String processedCandidate = preProcess(candidate);

    if (!isLengthSame(processedSubject, processedCandidate)) {
      return IS_NOT;
    }

    final String sortedSubjectString = sortString(processedSubject);
    final String sortedCandidateString = sortString(processedCandidate);

    isAnagram = compare(sortedSubjectString, sortedCandidateString);

    return isAnagram ? IS : IS_NOT;
  }

  /**
   * Private method to return string without spaces.
   * @param str - input string.
   * @return
   */
  private String preProcess(final String str) {
    return str.replaceAll(" ", "");
  }

  private boolean compare(final String sortedSubjectString, final String sortedCandidateString) {
    return sortedSubjectString.equals(sortedCandidateString);
  }

  private boolean isLengthSame(final String string1, final String string2) {
    return (string1.length() == string2.length());
  }

  private String sortString(final String str) {
    final char[] strCharArray = str.toCharArray();
    Arrays.sort(strCharArray);
    return Arrays.toString(strCharArray);
  }
}
