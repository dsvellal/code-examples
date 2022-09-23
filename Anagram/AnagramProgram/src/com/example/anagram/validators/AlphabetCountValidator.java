package com.example.anagram.validators;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.example.elasticsearch.metrics.client.Metrics;

public class AlphabetCountValidator implements InputValidator {
  private Metrics metrics = null;

  AlphabetCountValidator() {
    try {
      metrics = new Metrics(AlphabetCountValidator.class);
    } catch (final IOException e) {
      e.printStackTrace(System.out);
    }

  }

  @Override
  public void validate(final List<String> input) throws IllegalArgumentException {
    final long startTime = System.nanoTime();
    if (input.get(0).length() != input.get(1).length()) {
      final long endTime = System.nanoTime();
      metrics.publishFailureMetrics("COUNT_VALIDATOR", Arrays.asList("COUNT_DIFF"), (endTime - startTime));
      throw new IllegalArgumentException("Inputs provided are of different lenghts. Therefore can not be anagrams");
    }
    final long endTime = System.nanoTime();
    metrics.publishSuccessMetrics("COUNT_VALIDATOR", (startTime - endTime));
  }

}
