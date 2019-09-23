/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package swcoe.xpers.sample.tdd;

import static org.junit.Assert.assertEquals;
import static swcoe.xpers.sample.tdd.AnagramChecker.checkForAnagram;
import org.junit.Test;


public class AnagramTest
{
  private static final String VALID_ANAGRAM_MSG = "words presented are anagrams of each other";
  @Test
  public void validateSubjectAndCandidateAsValidAnagramsOfEachOther() {
    assertEquals(VALID_ANAGRAM_MSG,
        checkForAnagram("god", "dog"));
  }

  @Test
  public void validateSubjectAndCandidateAsNotValidAnagramsOfEachOther() {
    assertEquals("words presented are not anagrams of each other",
        checkForAnagram("dumb", "dunb"));
  }

  @Test
  public void subjectAndCandidateContainDifferentCaseTypes() {
    assertEquals(VALID_ANAGRAM_MSG,
        checkForAnagram("Dog", "God"));
  }

}

