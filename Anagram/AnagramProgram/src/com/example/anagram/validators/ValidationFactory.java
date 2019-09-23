package com.philips.anagram.validators;

import java.util.Arrays;

import com.philips.anagram.constants.ValidationSteps;
import com.philips.elasticsearch.metrics.client.Metrics;

public class ValidationFactory {
  private static Metrics metrics = null;

  static {
    try {
      metrics = new Metrics(ValidationFactory.class);
    } catch (final Exception e) {
      e.printStackTrace(System.out);
    }
  }

  private ValidationFactory() {

  }

  public static InputValidator getInputValidatorInstance(final ValidationSteps validator) {
    final long startTime = System.nanoTime();
    switch (validator) {
    case Basic:
      return new BasicInputValidator();

    case Line:
      return new LineCountInputValidator();

    case AlphabetCount:
      return new AlphabetCountValidator();

    default:
      final long endTime = System.nanoTime();
      metrics.publishFailureMetrics("VALIDATION_FACTORY", Arrays.asList("INPUT_ERROR"), (endTime - startTime));
      throw new IllegalArgumentException("Invalid validator specified.");
    }
  }

}
