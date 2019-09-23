package com.philips.anagram.constants;

import org.junit.Assert;
import org.junit.Test;

public class ValidationStepsTest {

  // Basic, Line, AlphabetCount;

  @Test
  public void testValidationSteps() {
    Assert.assertNotNull(ValidationSteps.values());
    Assert.assertEquals(3, ValidationSteps.values().length);
    Assert.assertTrue(ValidationSteps.valueOf("Basic") instanceof ValidationSteps);
    Assert.assertTrue(ValidationSteps.valueOf("Line") instanceof ValidationSteps);
    Assert.assertTrue(ValidationSteps.valueOf("AlphabetCount") instanceof ValidationSteps);
  }

}
