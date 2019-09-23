package com.philips.anagram.constants;

import org.junit.Assert;
import org.junit.Test;

public class DetectionAlgorithmTest {

  @Test
  public void testDetectionAlgorithm() {
    Assert.assertNotNull(DetectionAlgorithm.values());
    Assert.assertEquals(1, DetectionAlgorithm.values().length);
    Assert.assertTrue(DetectionAlgorithm.valueOf("DetectionBySorting") instanceof DetectionAlgorithm);
  }

}
