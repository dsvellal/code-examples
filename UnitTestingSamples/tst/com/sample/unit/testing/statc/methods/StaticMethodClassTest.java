/*
 * Copyright
 * @author: dsvellal
 * 
 */
package com.sample.unit.testing.statc.methods;

import static com.sample.unit.testing.constants.ConstantStringClass.HELLO_WORLD;
import static com.sample.unit.testing.constants.ConstantStringClass.WORLD;

import org.junit.Assert;
import org.junit.Test;

public class StaticMethodClassTest {

  @Test
  public void testStaticMethod() {
    Assert.assertEquals(HELLO_WORLD, StaticMethodClass.printHello(WORLD));
  }

}
