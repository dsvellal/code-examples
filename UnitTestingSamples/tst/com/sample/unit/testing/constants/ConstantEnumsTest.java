/*
 * Copyright
 * @author: dsvellal
 *
 */
package com.sample.unit.testing.constants;

import static com.sample.unit.testing.constants.ConstantStringClass.FOUR;
import static com.sample.unit.testing.constants.ConstantStringClass.ONE;

import org.junit.Assert;
import org.junit.Test;

public class ConstantEnumsTest {
  @Test
  public void testConstantEnums() {
    Assert.assertNotNull(ConstantEnums.values());
    Assert.assertEquals(3, ConstantEnums.values().length);
    Assert.assertEquals(ConstantEnums.ONE, ConstantEnums.valueOf(ONE));
  }

  @Test
  (expected = IllegalArgumentException.class)
  public void testConstantEnumsException() {
    ConstantEnums.valueOf(FOUR);
  }

}
