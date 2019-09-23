/*
 * Copyright
 * @author: dsvellal
 *
 */
package com.sample.unit.testing.constructors;

import static com.sample.unit.testing.constants.ConstantStringClass.DUMMY_EXPECTED_STRING;
import static com.sample.unit.testing.constants.ConstantStringClass.EMPTY_STR;
import static com.sample.unit.testing.constants.ConstantStringClass.HELLO_WORLD;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

public class PrivateConstructorTest {

  @Test
  public void testPrivateConstructor() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

    // This code errors out: PrivateConstructor constructor = new PrivateConstructor(EXPECTED_STRING);

    final Constructor<PrivateConstructor> privateConstructor = PrivateConstructor.class.getDeclaredConstructor(String.class);
    Assert.assertEquals(false, privateConstructor.isAccessible());

    privateConstructor.setAccessible(true);

    final PrivateConstructor privateConstructorInstance = privateConstructor.newInstance(DUMMY_EXPECTED_STRING);

    Assert.assertNotNull(privateConstructorInstance);
    Assert.assertEquals(DUMMY_EXPECTED_STRING, privateConstructorInstance.getString());
  }

  @Test
  public void testPublicConstructor() {
    final PrivateConstructor privateConstructorInstance = new PrivateConstructor();
    Assert.assertEquals(EMPTY_STR, privateConstructorInstance.getString());
  }

  @Test
  public void testPublicMethod() {
    final PrivateConstructor privateConstructorInstance = new PrivateConstructor();
    Assert.assertEquals(HELLO_WORLD, privateConstructorInstance.getHelloWorldString());
  }

}
