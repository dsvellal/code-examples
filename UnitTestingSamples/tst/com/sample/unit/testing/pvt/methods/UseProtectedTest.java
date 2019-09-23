/*
 * Copyright
 * @author: dsvellal
 * 
 */
package com.sample.unit.testing.pvt.methods;

import static com.sample.unit.testing.constants.ConstantStringClass.HELLO_WORLD;
import static com.sample.unit.testing.constants.ConstantStringClass.HELLO_WORLD_LOWER_CASE;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sample.unit.testing.samples.pojo.CustomObject;

public class UseProtectedTest {
  private UseProtected useProtectedInstance;

  @Before
  public void setup() {
    useProtectedInstance = new UseProtected();
  }

  @Test
  public void testPrivateMethod1() {
    final String output = useProtectedInstance.privateMethod1(HELLO_WORLD);

    Assert.assertNotNull(output);
    Assert.assertEquals(HELLO_WORLD_LOWER_CASE, output);
  }

  @Test
  public void testPrivateMethod2() {
    final List<String> inputs = Arrays.asList("One", "Two", "Three");

    final CustomObject customObject = useProtectedInstance.privateMethod2(inputs);

    Assert.assertNotNull(customObject);
    Assert.assertNotNull(customObject.getListAsString());
    Assert.assertEquals(inputs.toString(), customObject.getListAsString());
  }

  @Test
  public void testPublicMethod() {
    Assert.assertEquals("Hello", useProtectedInstance.publicMethod());
  }

}
