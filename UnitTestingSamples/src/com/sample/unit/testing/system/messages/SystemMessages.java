/*
 * Copyright
 * @author: dsvellal
 *
 */
package com.sample.unit.testing.system.messages;
import static com.sample.unit.testing.constants.ConstantStringClass.SYSERR_MSG;
import static com.sample.unit.testing.constants.ConstantStringClass.SYSOUT_MSG;

public class SystemMessages {

  public void printSystemOutMessage() {
    System.out.println(SYSOUT_MSG);
  }

  public void printSystemErrorMessage() {
    System.err.println(SYSERR_MSG);
  }

}
