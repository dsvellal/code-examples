/*
 * Copyright
 * @author: dsvellal
 *
 */
package com.sample.unit.testing.system.messages;

import static com.sample.unit.testing.constants.ConstantStringClass.SYSERR_MSG;
import static com.sample.unit.testing.constants.ConstantStringClass.SYSOUT_MSG;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SystemMessagesTest {
  private PrintStream sysout;
  private PrintStream syserr;

  private final ByteArrayOutputStream mySysout = new ByteArrayOutputStream();
  private final ByteArrayOutputStream mySyserr = new ByteArrayOutputStream();

  @Before
  public void setupStreams() {
    sysout = System.out;
    syserr = System.err;

    System.setOut(new PrintStream(mySysout));
    System.setErr(new PrintStream(mySyserr));
  }

  @After
  public void revertStreams() {
    System.setOut(sysout);
    System.setErr(syserr);
  }

  @Test
  public void testSysoutMethod() {
    final SystemMessages testObjInstance = new SystemMessages();
    final String expectedSysoutMessage = SYSOUT_MSG;

    testObjInstance.printSystemOutMessage();

    Assert.assertEquals(expectedSysoutMessage, mySysout.toString().trim());
  }

  @Test
  public void testSyserrMethod() {
    final SystemMessages testObjInstance = new SystemMessages();
    final String expectedSyserrMessage = SYSERR_MSG;

    testObjInstance.printSystemErrorMessage();

    Assert.assertEquals(expectedSyserrMessage, mySyserr.toString().trim());
  }

}
