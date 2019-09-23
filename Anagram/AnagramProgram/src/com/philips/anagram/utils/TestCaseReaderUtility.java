package com.philips.anagram.utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.philips.elasticsearch.metrics.client.Metrics;

public class TestCaseReaderUtility {
  private static final String defaultTestCasesDirectoryPath = "testInputs";
  private static Metrics metrics = null;

  static {
    try {
      metrics = new Metrics(TestCaseReaderUtility.class);
    } catch (final IOException e) {
      e.printStackTrace(System.out);
    }
  }

  private TestCaseReaderUtility() {

  }

  public static List<String> getLinesFromTestCase(final String testCasesDirectoryPath, final int testCaseNumber) {
    final long startTime = System.nanoTime();
    final List<String> lines = FileUtility.getListOfStringFromDirectoryAndFileNumber(testCasesDirectoryPath,
        testCaseNumber, defaultTestCasesDirectoryPath);

    if (lines == null || lines.size() != 2) {
      final long endTime = System.nanoTime();
      metrics.publishFailureMetrics("GET_LINES", Arrays.asList("EMPTY_FILE"), (endTime - startTime));
      throw new IllegalArgumentException(
          "No. of lines found in the specified directory: " + testCasesDirectoryPath + " is not equal to 2.");
    }

    final long endTime = System.nanoTime();
    metrics.publishSuccessMetrics("GET_LINES", (endTime - startTime));
    return lines;
  }
}
