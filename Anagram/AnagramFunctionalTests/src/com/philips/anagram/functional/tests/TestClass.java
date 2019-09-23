/*
 * Copyright of Philips, 2019
 *
 * This file is subject to the terms and conditions defined by Philips,
 * visit https://www.ip.philips.com/licensing/ for more details.
 *
 */
package com.philips.anagram.functional.tests;

import java.util.List;
import java.util.Map;

import com.philips.anagram.constants.ProgramBehaviorKeys;
import com.philips.anagram.main.MainThread;
import com.philips.anagram.utils.FileUtility;
import com.philips.anagram.utils.ProgramBehaviorReaderUtility;

/**
 *
 */
public class TestClass {

  /** The Constant NO_OF_TCS. */
  private static final int NO_OF_TCS = 5;

  /** The Constant NO_OF_BEHAVIORS. */
  private static final int NO_OF_BEHAVIORS = 3;

  /** The Constant NO_OF_EXECUTIONS. */
  private static final int NO_OF_EXECUTIONS = 1;

  /** The Constant WAIT_TIME_IN_SECS. */
  private static final int WAIT_TIME_IN_SECS = 1;

  /**
   *
   *
   * @param args
   */
  public static void main(final String[] args) {

    int count = 0;
    while (count < NO_OF_EXECUTIONS) {
      count = count + 1;
      try {
        Thread.sleep(WAIT_TIME_IN_SECS * 1000);
        final int testcaseNo = (Double.valueOf(Math.random() * 10).intValue() % NO_OF_TCS) + 1;
        final int behaviorPropertyNo = (Double.valueOf(Math.random() * 10).intValue() % NO_OF_BEHAVIORS) + 1;

        final Map<ProgramBehaviorKeys, Object> behaviorProperties = ProgramBehaviorReaderUtility
            .getProgramBehaviorMap("", 4);
        final List<String> inputs = FileUtility.getListOfStringFromDirectoryAndFileNumber("", 6, "testInputs");

        final MainThread mainThread = new MainThread(behaviorProperties, inputs);
        final Thread thread = new Thread(mainThread);
        thread.start();
        thread.join();

      } catch (final Exception e) {
        e.printStackTrace(System.out);
      }
    }

    System.exit(0);
  }
}
