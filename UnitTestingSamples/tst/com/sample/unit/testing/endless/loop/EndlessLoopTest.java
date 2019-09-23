/*
 * Copyright
 * @author: dsvellal
 *
 */
package com.sample.unit.testing.endless.loop;

import static com.sample.unit.testing.constants.ConstantStringClass.RETURN_STRING;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EndlessLoopTest {
  private EndlessLoop testObjInstance;

  @Before
  public void setup() {
    testObjInstance = new EndlessLoop();
  }

  @Test
  public void testEndlessLoopMethod() {
    final String output = testObjInstance.endlessLoopMethod();
    final String expectedOutput = RETURN_STRING;

    Assert.assertNotNull(output);
    Assert.assertEquals(expectedOutput, output);
  }
}
