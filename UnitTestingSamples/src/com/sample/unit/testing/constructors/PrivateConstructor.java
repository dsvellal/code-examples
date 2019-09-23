/*
 * Copyright
 * @author: dsvellal
 *
 */
package com.sample.unit.testing.constructors;
import static com.sample.unit.testing.constants.ConstantStringClass.EMPTY_STR;
import static com.sample.unit.testing.constants.ConstantStringClass.HELLO_WORLD;

import java.util.Objects;

public class PrivateConstructor {
  private final String string;

  public PrivateConstructor() {
    this(EMPTY_STR);
  }

  private PrivateConstructor(final String string) {
    this.string = Objects.requireNonNull(string, "This string can not be null");
  }

  public String getHelloWorldString() {
    return HELLO_WORLD;
  }

  public String getString() {
    return this.string;
  }

}
