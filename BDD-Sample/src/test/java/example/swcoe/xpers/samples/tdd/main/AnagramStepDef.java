/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */

package philips.swcoe.xpers.samples.tdd.main;

import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AnagramStepDef {
  private static final Anagram ANAGRAM_INSTANCE = Anagram.getInstance();
  private String actualMessage;

  @When("I ask if the word or phrase {string} is an anagram of the word or phrase {string}")
  public void checksAnagramForStrings(final String subject, final String candidate) {
    actualMessage = checkAnagram(subject, candidate);
  }

  @Then("I see a message - can not check for anagram because {string}")
  public void validateException(final String expectedExceptionMessage) {
    Assert.assertEquals(expectedExceptionMessage, actualMessage);
  }

  @Then("I see a message {string} {string} an anagram of {string}")
  public void checksAnagramForValidCases(
      final String subject, final String expectedMessage, final String candidate) {
    Assert.assertEquals(expectedMessage, actualMessage);
  }

  /**
   * Generic method that checks whether two given strings are anagrams or not! Throws an exception
   * if any of the passed strings are not valid strings.
   *
   * @param subject - This can be a word or a phrase.
   * @param candidate - This can be a word or a phrase.
   * @return
   */
  private String checkAnagram(final String subject, final String candidate) {
    return ANAGRAM_INSTANCE.isAnagram(subject, candidate);
  }
}
