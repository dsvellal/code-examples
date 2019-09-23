/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package swcoe.xpers.sample.tdd;

import java.util.Arrays;

public class AnagramChecker
{
  private static final String IS_ANAGRAM = "words presented are anagrams of each other";
  private static final String IS_NOT_ANAGRAM = "words presented are not anagrams of each other";
  private AnagramChecker() {
    throw new IllegalStateException();
  }

  public static String checkForAnagram(String subject, String candidate) {
    return (sortAndCaseNormalize(candidate).equals(sortAndCaseNormalize(subject))) ? IS_ANAGRAM : IS_NOT_ANAGRAM;
  }

  private static String sortAndCaseNormalize(String string) {
    final char[] charsOfString = string.toLowerCase().toCharArray();
    Arrays.sort(charsOfString);
    return Arrays.toString(charsOfString);
  }
}
