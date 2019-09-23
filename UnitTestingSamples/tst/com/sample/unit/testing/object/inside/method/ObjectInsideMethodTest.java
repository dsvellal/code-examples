/*
 * Copyright
 * @author: dsvellal
 *
 */
package com.sample.unit.testing.object.inside.method;

import static com.sample.unit.testing.constants.ConstantStringClass.DUMMY_EXPECTED_STRING;
import static com.sample.unit.testing.constants.ConstantStringClass.ONE;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.sample.unit.testing.samples.pojo.CustomObject;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ObjectInsideMethod.class})
public class ObjectInsideMethodTest {

  @Test
  public void testObjectInstantiationInsideMethod() throws Exception {
    final List<String> input = Arrays.asList(ONE);
    final CustomObject mockedCustomObject = PowerMockito.mock(CustomObject.class);
    PowerMockito.whenNew(CustomObject.class).withArguments(Mockito.anyList()).thenReturn(mockedCustomObject);
    PowerMockito.when(mockedCustomObject.getListAsString()).thenReturn(DUMMY_EXPECTED_STRING);

    final ObjectInsideMethod objectInsideMethodInstance = new ObjectInsideMethod();
    final String output = objectInsideMethodInstance.objectInstantiationInsideMethod(input);

    Assert.assertNotNull(output);
    Assert.assertEquals(DUMMY_EXPECTED_STRING, output);
  }

}
