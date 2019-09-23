/*
 * Copyright
 * @author: dsvellal
 *
 */
package com.sample.unit.testing.mocking.samples;

import com.sample.unit.testing.samples.pojo.CustomObject;

public class MockingExamples {
  private final CustomObject customObject;

  public MockingExamples(final CustomObject customObject) {
    this.customObject = customObject;
  }

  public boolean emptyTheListOfStrings(){
    customObject.removeAllStringFromList();
    return customObject.getListAsString().isEmpty();
  }

}
