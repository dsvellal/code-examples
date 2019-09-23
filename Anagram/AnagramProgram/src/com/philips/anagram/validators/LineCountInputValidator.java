package com.philips.anagram.validators;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.philips.elasticsearch.metrics.client.Metrics;

public class LineCountInputValidator implements InputValidator {
  private Metrics metrics = null;

  public LineCountInputValidator() {
    try {
      metrics = new Metrics(LineCountInputValidator.class);
    } catch (final IOException e) {
      e.printStackTrace(System.out);
    }
  }

  @Override
  public void validate(final List<String> input) throws IllegalArgumentException {
    final long startTime = System.nanoTime();
    if ((input.size() % 2) != 0) {
      final long endTime = System.nanoTime();
      metrics.publishFailureMetrics("LINE_COUNT_VALIDATOR", Arrays.asList("INPUT_ERROR"), (endTime - startTime));
      throw new IllegalArgumentException("Invalid no. of inputs given");
    }

    final long endTime = System.nanoTime();
    metrics.publishSuccessMetrics("LINE_COUNT_VALIDATOR", (endTime - startTime));
  }
}
