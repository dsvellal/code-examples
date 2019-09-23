/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */

package philips.swcoe.xpers.samples.tdd.main;

import org.junit.Assert;
import org.junit.Test;
import philips.swcoe.xpers.samples.tdd.main.Anagram;

/**
 * This is the unit-test file that'll help in unit-testing the Anagram class.
 *
 * @author 320038909
 */
public class AnagramTest {
  private static final String STR1 = "abc";
  private static final String STR2 = "cba";
  private static final String STR3 = "abcd";
  private static final String STR4 = "bad";
  private static final String IS = "is";
  private static final String IS_NOT = "is not";

  @Test
  public void getAnagramInstance() {
    final Anagram anagram = Anagram.getInstance();

    Assert.assertNotNull(anagram);
    Assert.assertTrue(anagram instanceof Anagram);
  }

  @Test
  public void checkAnagramInstanceSingletonProperty() {
    final Anagram instance1 = Anagram.getInstance();
    final Anagram instance2 = Anagram.getInstance();

    Assert.assertEquals(instance1.hashCode(), instance2.hashCode());
  }

  @Test
  public void checkIsAnagramForAnagramStrings() {
    final String actualResult = Anagram.getInstance().isAnagram(STR1, STR2);

    Assert.assertEquals(IS, actualResult);
  }

  @Test
  public void checkIsAnagramForNonAnagramStrings() {
    final String actualResult = Anagram.getInstance().isAnagram(STR1, STR4);

    Assert.assertEquals(IS_NOT, actualResult);
  }

  @Test
  public void checkIsAnagramWithNullString1() {
    final String actualResult = Anagram.getInstance().isAnagram(null, STR2);

    Assert.assertEquals("subject is null", actualResult);
  }

  @Test
  public void checkIsAnagramWithNullString2() {
    final String actualResult = Anagram.getInstance().isAnagram(STR1, null);

    Assert.assertEquals("candidate is null", actualResult);
  }

  @Test
  public void checkIsAnagramWithBothNullStrings() {
    final String actualResult = Anagram.getInstance().isAnagram(null, null);

    Assert.assertEquals("both subject and candidate are null", actualResult);
  }

  @Test
  public void checkIsAnagramWithDifferentLengthStrings() {
    final String actualResult = Anagram.getInstance().isAnagram(STR1, STR3);

    Assert.assertEquals(IS_NOT, actualResult);
  }
}
