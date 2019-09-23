package com.philips.anagram.constants;

import org.junit.Assert;
import org.junit.Test;

public class ProgramBehaviorKeysTest {

  @Test
  public void testProgramBehaviorKeys() {
    Assert.assertNotNull(ProgramBehaviorKeys.values());
    Assert.assertEquals(6, ProgramBehaviorKeys.values().length);
    Assert.assertTrue(ProgramBehaviorKeys.valueOf("StepsToExecute") instanceof ProgramBehaviorKeys);
    Assert.assertTrue(ProgramBehaviorKeys.valueOf("PreProcessingSteps") instanceof ProgramBehaviorKeys);
    Assert.assertTrue(ProgramBehaviorKeys.valueOf("ValidationSteps") instanceof ProgramBehaviorKeys);
    Assert.assertTrue(ProgramBehaviorKeys.valueOf("Punctuations") instanceof ProgramBehaviorKeys);
    Assert.assertTrue(ProgramBehaviorKeys.valueOf("Whitespaces") instanceof ProgramBehaviorKeys);
    Assert.assertTrue(ProgramBehaviorKeys.valueOf("DetectionAlgorithm") instanceof ProgramBehaviorKeys);
  }
}
