/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package philips.swcoe.xpers.samples.tdd.utility;

/**
 * Validation class for anagram. The logic validates passed strings for null, blank, alphabets and
 * numbers. The logic throws IllegalArgumentException if the passed string - is null, - is blank -
 * is not an alphabet and not a number.
 *
 * @author dsvellal
 */
public class AnagramValidationUtility {
  private static final String BLANK = "";

  private static AnagramValidationUtility anagramValidationUtility = null;

  private AnagramValidationUtility() {}

  public static AnagramValidationUtility getInstance() {
    if (anagramValidationUtility == null) {
      anagramValidationUtility = new AnagramValidationUtility();
    }

    return anagramValidationUtility;
  }

  public void validateInput(final String subject, final String candidate) {
    checkFor(subject, candidate, null);
    checkFor(subject, candidate, BLANK);
    checkSubjectAndCandidateForValidAlphabets(subject, candidate);
  }

  private void checkSubjectAndCandidateForValidAlphabets(
      final String subject, final String candidate) {
    final boolean isSubjectValid = checkStringValidity(subject);
    final boolean isCandidateValid = checkStringValidity(candidate);

    if (!isSubjectValid && !isCandidateValid) {
      throw new IllegalArgumentException("subject and candidate are not words or phrases");
    }

    if (!isSubjectValid) {
      throw new IllegalArgumentException("subject is not a word or phrase");
    }

    if (!isCandidateValid) {
      throw new IllegalArgumentException("candidate is not a word or phrase");
    }
  }

  /**
   * This method checks for a string if it contains valid lowercase, uppercase, number of a space as characters.
   * If none of these are found, then the character is considered as invalid, and the appropriate flag value is returned. 
   * @param str - Input string against which characters are checked for being valid
   * @return - true or false, depending on the output of the rules mentioned in the description
   */
  private boolean checkStringValidity(final String str) {
    boolean isValidChar = false;
    for (int i = 0; i < str.length(); i++) {
      final char charAtI = str.charAt(i);
      isValidChar =
          ((charAtI >= 'a' && charAtI <= 'z')
              || (charAtI >= 'A' && charAtI <= 'Z')
              || (charAtI >= '0' && charAtI <= '9')
              || charAtI == ' ');
      if (!isValidChar) {
        break;
      }
    }

    return isValidChar;
  }

  private void checkFor(final String subject, final String candidate, final String condition) {
    checkSubjectAndCandidate(subject, candidate, condition);
    check(subject, "subject", condition);
    check(candidate, "candidate", condition);
  }

  private void check(final String str, final String type, final String condition) {
    if (condition == null && str == null) {
      throw new IllegalArgumentException(type + " is null");
    }

    if (condition != null && condition.equals(BLANK) && str.isEmpty()) {
      throw new IllegalArgumentException(type + " is blank");
    }
  }

  private void checkSubjectAndCandidate(
      final String subject, final String candidate, final String condition) {
    if (condition == null && subject == null && candidate == null) {
      throw new IllegalArgumentException("both subject and candidate are null");
    }

    if (condition != null && condition.equals(BLANK) && subject.isEmpty() && candidate.isEmpty()) {
      throw new IllegalArgumentException("both subject and candidate are blank");
    }
  }
}
