package com.example.anagram.validators;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.example.elasticsearch.metrics.client.Metrics;

public class BasicInputValidator implements InputValidator {
  private Metrics metrics = null;

  BasicInputValidator() {
    try {
      metrics = new Metrics(BasicInputValidator.class);
    } catch (final IOException e) {
      e.printStackTrace(System.out);
    }

  }

  @Override
  public void validate(final List<String> inputs) throws IllegalArgumentException {
    final long startTime = System.nanoTime();
    inputs.forEach((input) -> {
      if (input == null || input.isEmpty()) {
        final long endTime = System.nanoTime();
        metrics.publishFailureMetrics("BASIC_VALIDATOR", Arrays.asList("INPUT_ERROR"), (endTime - startTime));
        throw new IllegalArgumentException("Invalid input string.");
      }
    });

    final long endTime = System.nanoTime();
    metrics.publishSuccessMetrics("BASIC_VALIDATOR", (endTime - startTime));

  }
}
