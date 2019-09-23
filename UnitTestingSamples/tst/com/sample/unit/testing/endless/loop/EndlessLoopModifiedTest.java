/*
 * Copyright
 * @author: dsvellal
 *
 */
package com.sample.unit.testing.endless.loop;

import static com.sample.unit.testing.constants.ConstantStringClass.CIRCUIT_BREAKER_COUNT;
import static com.sample.unit.testing.constants.ConstantStringClass.RETURN_STRING;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EndlessLoopModifiedTest {

  private EndlessLoopModified endlessLoopModifiedInstance;

  @Before
  public void setup() {
    endlessLoopModifiedInstance = new EndlessLoopModified(CIRCUIT_BREAKER_COUNT);
  }

  @Test
  public void testEndlessLoopMethod() {
    final String output = endlessLoopModifiedInstance.endlessLoopMethod();
    final String expectedOutput = RETURN_STRING;

    Assert.assertNotNull(output);
    Assert.assertEquals(expectedOutput, output);
  }

}
