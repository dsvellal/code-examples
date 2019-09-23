/*
 * Copyright
 * @author: dsvellal
 *
 */
package com.sample.unit.testing.system.messages;

import static com.sample.unit.testing.constants.ConstantStringClass.SYSERR_MSG;
import static com.sample.unit.testing.constants.ConstantStringClass.SYSOUT_MSG;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class SystemMessagesTestJUnitRule {

  @Rule
  public SystemOutResource mySysout = new SystemOutResource();

  @Rule
  public SystemErrorResource mySyserr = new SystemErrorResource();


  @Test
  public void testSysoutMessage() {
    final SystemMessages testObjInstance = new SystemMessages();

    testObjInstance.printSystemOutMessage();
    testObjInstance.printSystemErrorMessage();

    Assert.assertEquals(SYSOUT_MSG, mySysout.asString().trim());
    Assert.assertEquals(SYSERR_MSG, mySyserr.asString().trim());
  }

}
