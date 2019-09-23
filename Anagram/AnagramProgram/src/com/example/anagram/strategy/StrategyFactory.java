package com.philips.anagram.strategy;

import java.io.IOException;
import java.util.Arrays;

import com.philips.anagram.constants.DetectionAlgorithm;
import com.philips.elasticsearch.metrics.client.Metrics;

public class StrategyFactory {
  private static Metrics metrics = null;

  static {
    try {
      metrics = new Metrics(StrategyFactory.class);
    } catch (final IOException e) {
      e.printStackTrace(System.out);
    }
  }

  private StrategyFactory() {
  }

  public static Strategy getStrategyInstance(final DetectionAlgorithm strategy) {
    final long startTime = System.nanoTime();
    switch (strategy) {
    case DetectionBySorting:
      return new DetectionBySortingStrategy();

    default:
      final long endTime = System.nanoTime();
      metrics.publishFailureMetrics("STRATEGY_FACTORY", Arrays.asList("INVALID_INPUT"), (endTime - startTime));
      throw new IllegalArgumentException("Invalid strategy specified.");
    }
  }
}
