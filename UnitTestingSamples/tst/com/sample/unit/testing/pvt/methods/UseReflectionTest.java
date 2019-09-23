/*
 * Copyright
 * @author: dsvellal
 *
 */
package com.sample.unit.testing.pvt.methods;

import static com.sample.unit.testing.constants.ConstantStringClass.HELLO;
import static com.sample.unit.testing.constants.ConstantStringClass.HELLO_WORLD;
import static com.sample.unit.testing.constants.ConstantStringClass.HELLO_WORLD_LOWER_CASE;
import static com.sample.unit.testing.constants.ConstantStringClass.ONE;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sample.unit.testing.samples.pojo.CustomObject;

public class UseReflectionTest {
  private static final String PRIVATE_METHOD_1 = "privateMethod1";
  private static final String PRIVATE_METHOD_2 = "privateMethod2";
  private UseReflection useReflectionInstance;

  @Before
  public void setup() {
    useReflectionInstance = new UseReflection();
  }

  @Test
  public void testPrivateMethod1() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    final Method method = UseReflection.class.getDeclaredMethod(PRIVATE_METHOD_1, String.class);
    method.setAccessible(true);
    final String output = (String) method.invoke(useReflectionInstance, HELLO_WORLD);

    Assert.assertNotNull(output);
    Assert.assertEquals(HELLO_WORLD_LOWER_CASE, output);
  }

  @Test
  public void testPrivateMethod2() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    final List<String> inputs = Arrays.asList(ONE);

    final Method method = UseReflection.class.getDeclaredMethod(PRIVATE_METHOD_2, List.class);
    method.setAccessible(true);
    final CustomObject output = (CustomObject) method.invoke(useReflectionInstance, inputs);

    Assert.assertNotNull(output);
    Assert.assertNotNull(output.getListAsString());
    Assert.assertEquals(inputs.toString(), output.getListAsString());
  }

  @Test
  public void testPublicMethod() {
    Assert.assertEquals(HELLO, useReflectionInstance.publicMethod());
  }

}
