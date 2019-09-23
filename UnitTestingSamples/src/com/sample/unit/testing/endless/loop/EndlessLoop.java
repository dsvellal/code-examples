/*
 * Copyright
 * @author: dsvellal
 *
 */
package com.sample.unit.testing.endless.loop;
import static com.sample.unit.testing.constants.ConstantStringClass.INSIDE_LOOP;
import static com.sample.unit.testing.constants.ConstantStringClass.RETURN_STRING;

public class EndlessLoop {

  public String endlessLoopMethod() {
    while (true) {
      // some logic that has a potential to become infinite!
      System.out.println(INSIDE_LOOP);
      if (true) {
        break;
      }
    }

    return RETURN_STRING;
  }

}
