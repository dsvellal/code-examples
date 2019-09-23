/*
 * Copyright
 * @author: dsvellal
 *
 */
package com.sample.unit.testing.mocking.samples;

import static com.sample.unit.testing.constants.ConstantStringClass.EMPTY_STR;
import static com.sample.unit.testing.constants.ConstantStringClass.NOT_EMPTY_STR;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import com.sample.unit.testing.samples.pojo.CustomObject;

public class MockingExamplesTest {

  private MockingExamples mockingExamplesInstance;
  private CustomObject mockedCustomObject;

  @Before
  public void setup() {
    mockedCustomObject = PowerMockito.mock(CustomObject.class);
    mockingExamplesInstance = new MockingExamples(mockedCustomObject);
  }

  @Test
  public void testMethodReturningVoidBooleanTrueReturn() {
    mockSetup(EMPTY_STR);
    final boolean isEmpty = mockingExamplesInstance.emptyTheListOfStrings();
    Assert.assertTrue(isEmpty);
    verifyMockCalls();
  }

  @Test
  public void testMethodReturningVoidBooleanFalseReturn() {
    mockSetup(NOT_EMPTY_STR);
    final boolean isEmpty = mockingExamplesInstance.emptyTheListOfStrings();
    Assert.assertFalse(isEmpty);
    verifyMockCalls();
  }

  private void mockSetup(final String returnString) {
    Mockito.doNothing().when(mockedCustomObject).removeAllStringFromList();
    Mockito.doReturn(returnString).when(mockedCustomObject).getListAsString();
  }

  private void verifyMockCalls() {
    Mockito.verify(mockedCustomObject, Mockito.times(1)).getListAsString();
    Mockito.verify(mockedCustomObject, Mockito.times(1)).removeAllStringFromList();
  }
}
