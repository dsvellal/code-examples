package example.swcoe.xpers.samples.tdd.utility;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test class for AnagramValidationUtility.
 *
 * @author dsvellal
 *
 */
public class AnagramValidationUtilityTest {

  @Test
  public void testGetInstance() {
    final AnagramValidationUtility validationUtility = AnagramValidationUtility.getInstance();

    Assert.assertNotNull(validationUtility);
  }

  @Test
  public void testSingletonInstanceProperty() {
    final AnagramValidationUtility instance1 = AnagramValidationUtility.getInstance();
    final AnagramValidationUtility instance2 = AnagramValidationUtility.getInstance();

    Assert.assertEquals(instance1.hashCode(), instance2.hashCode());
  }

  @Test
  public void testSubjectNull() {
    testForValues(null, "abc", "subject is null");
  }

  @Test
  public void testCandidateNull() {
    testForValues("abc", null, "candidate is null");
  }

  @Test
  public void testSubjectAndCandidateNull() {
    testForValues(null, null, "both subject and candidate are null");
  }

  @Test
  public void testSubjectBlank() {
    testForValues("", "abc", "subject is blank");
  }

  @Test
  public void testCandidateBlank() {
    testForValues("abc", "", "candidate is blank");
  }

  @Test
  public void testSubjectAndCandidateBlank() {
    testForValues("", "", "both subject and candidate are blank");
  }

  @Test
  public void testSubjectForPunctuation() {
    testForValues("#", "abc", "subject is not a word or phrase");
  }

  @Test
  public void testCandidateForPunctuation() {
    testForValues("abc", "#", "candidate is not a word or phrase");
  }

  @Test
  public void testSubjectAndCandidateForPunctuation() {
    testForValues("#", "#", "subject and candidate are not words or phrases");
  }

  @Test
  public void testSubjectAndCandidateForValidLowercaseString() {
    AnagramValidationUtility.getInstance().validateInput("a", "a");
  }

  @Test
  public void testSubjectAndCandidateForValidUppercaseString() {
    AnagramValidationUtility.getInstance().validateInput("A", "A");
  }

  @Test
  public void testSubjectAndCandidateForValidNumber() {
    AnagramValidationUtility.getInstance().validateInput("9", "8");
  }

  @Test
  public void testSubjectAndCandidateForSpace() {
    AnagramValidationUtility.getInstance().validateInput(" ", " ");
  }



  private void testForValues(final String subject, final String candidate, final String expectedExceptionMessage) {
    try {
      AnagramValidationUtility.getInstance().validateInput(subject, candidate);
      Assert.assertFalse(true);
    } catch (final IllegalArgumentException e) {
      Assert.assertEquals(expectedExceptionMessage, e.getMessage());
    }
  }
}
