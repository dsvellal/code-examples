/*
 * Copyright
 * @author: dsvellal
 * 
 */
package com.sample.unit.testing.statc.methods;

import static com.sample.unit.testing.constants.ConstantStringClass.DUMMY_EXPECTED_STRING;
import static com.sample.unit.testing.constants.ConstantStringClass.WORLD;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({StaticMethodClass.class})
public class StaticMethodClassTestWithPowerMock {
  @Test
  public void testStaticMethod() {
    PowerMockito.mockStatic(StaticMethodClass.class);
    PowerMockito.when(StaticMethodClass.printHello(Mockito.anyString())).thenReturn(DUMMY_EXPECTED_STRING);

    final String output = StaticMethodClass.printHello(WORLD);

    Assert.assertFalse(output.contains(WORLD));
    Assert.assertEquals(DUMMY_EXPECTED_STRING, output);
  }
}
