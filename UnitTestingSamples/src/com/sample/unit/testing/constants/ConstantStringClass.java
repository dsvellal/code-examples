/*
 * Copyright
 * @author: dsvellal
 *
 */
package com.sample.unit.testing.constants;

public class ConstantStringClass {
  public static final String PUBLIC_STATIC_FINAL_STRING = "PSFS";
  public static final String HELLO = "Hello";
  public static final String WORLD = "World";
  public static final String HELLO_WORLD = HELLO + " " + WORLD;
  public static final String HELLO_WORLD_LOWER_CASE = HELLO_WORLD.toLowerCase();
  public static final String DUMMY_EXPECTED_STRING = "dummyExpectedString";
  public static final String EMPTY_STR = "";
  public static final String NOT_EMPTY_STR = "NotEmptyString";
  public static final String ONE = "ONE";
  public static final String FOUR = "FOUR";
  public static final String SYSOUT_MSG = "sysout message";
  public static final String SYSERR_MSG = "syserr message";
  public static final String INSIDE_LOOP = "Inside loop";
  public static final String RETURN_STRING = "DummyReturnString";
  public static final String ES_INDEX = "dummyIndex";
  public static final String ES_TYPE = "dummyType";

  public static final long CIRCUIT_BREAKER_COUNT = 10;

  private ConstantStringClass() {

  }

}
