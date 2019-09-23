/*
 * Copyright
 * @author: dsvellal
 *
 */
package com.sample.unit.testing.endless.loop;
import static com.sample.unit.testing.constants.ConstantStringClass.INSIDE_LOOP;
import static com.sample.unit.testing.constants.ConstantStringClass.RETURN_STRING;

public class EndlessLoopModified {
  private final long circuitBreakerCount;

  public EndlessLoopModified(final long circuitBreakerCount) {
    this.circuitBreakerCount = circuitBreakerCount;
  }

  public String endlessLoopMethod() {
    long count = 0;

    while (true) {
      count = count + 1;
      System.out.println(INSIDE_LOOP);

      if (count > circuitBreakerCount) {
        break;
      }
    }

    return RETURN_STRING;
  }

}
