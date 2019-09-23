package com.philips.anagram.constants;

import org.junit.Assert;
import org.junit.Test;

public class PreProcessingStepsTest {

  @Test
  public void testPreProcessingSteps() {
    Assert.assertNotNull(PreProcessingSteps.values());
    Assert.assertEquals(3, PreProcessingSteps.values().length);
    Assert.assertTrue(PreProcessingSteps.valueOf("CaseNormalizer") instanceof PreProcessingSteps);
    Assert.assertTrue(PreProcessingSteps.valueOf("WhiteSpaceRemover") instanceof PreProcessingSteps);
    Assert.assertTrue(PreProcessingSteps.valueOf("PunctuationRemover") instanceof PreProcessingSteps);
  }

}
