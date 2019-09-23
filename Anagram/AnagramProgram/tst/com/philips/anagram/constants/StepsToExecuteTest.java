package com.philips.anagram.constants;

import org.junit.Assert;
import org.junit.Test;

public class StepsToExecuteTest {

  @Test
  public void testStepsToExecute() {
    Assert.assertNotNull(StepsToExecute.values());
    Assert.assertEquals(3, StepsToExecute.values().length);
    Assert.assertTrue(StepsToExecute.valueOf("Validate") instanceof StepsToExecute);
    Assert.assertTrue(StepsToExecute.valueOf("PreProcess") instanceof StepsToExecute);
    Assert.assertTrue(StepsToExecute.valueOf("Detect") instanceof StepsToExecute);
  }


}
