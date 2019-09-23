/*
 * Copyright
 * @author: dsvellal
 * 
 */
package com.sample.unit.testing.statc.methods;

import static com.sample.unit.testing.constants.ConstantStringClass.HELLO;
public class StaticMethodClass {

  private StaticMethodClass() {

  }

  public static String printHello(final String name) {
    return HELLO + " " + name;
  }

}
