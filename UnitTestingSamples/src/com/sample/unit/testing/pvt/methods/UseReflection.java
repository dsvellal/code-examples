/*
 * Copyright
 * @author: dsvellal
 * 
 */
package com.sample.unit.testing.pvt.methods;

import static com.sample.unit.testing.constants.ConstantStringClass.HELLO;

import java.util.List;

import com.sample.unit.testing.samples.pojo.CustomObject;

public class UseReflection {

  public String publicMethod() {
    return HELLO;
  }

  private String privateMethod1(final String str) {
    return str.trim().toLowerCase();
  }

  private CustomObject privateMethod2(final List<String> strings) {
    return new CustomObject(strings);
  }

}
