/*
 * Copyright of Philips, 2019
 *
 * This file is subject to the terms and conditions defined by Philips,
 * visit https://www.ip.philips.com/licensing/ for more details.
 *
 */
package com.philips.anagram.steps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.philips.anagram.constants.DetectionAlgorithm;
import com.philips.anagram.constants.ProgramBehaviorKeys;
import com.philips.anagram.strategy.Strategy;
import com.philips.anagram.strategy.StrategyFactory;
import com.philips.elasticsearch.metrics.client.Metrics;

public class Check implements Step {

  private Metrics metrics = null;

  Check() {
    try {
      metrics = new Metrics(Check.class);
    } catch (final IOException e) {
      e.printStackTrace(System.out);
    }
  }

  @Override
  public List<String> execute(final List<String> inputs, final Map<ProgramBehaviorKeys, Object> configs) {
    final long startTime = System.nanoTime();
    final List<String> output = new ArrayList<>();
    final DetectionAlgorithm detectionAlgo = DetectionAlgorithm
        .valueOf(configs.get(ProgramBehaviorKeys.DetectionAlgorithm).toString());
    final Strategy strategy = StrategyFactory.getStrategyInstance(detectionAlgo);

    for (int i = 0; i < inputs.size(); i++) {
      final String lhs = inputs.get(i);
      final String rhs = inputs.get(i + 1);
      i = i + 1;

      final boolean isAnagram = strategy.isAnagram(lhs, rhs);
      output.add("Is Anagram: " + isAnagram);
    }

    final long endTime = System.nanoTime();

    metrics.publishSuccessMetrics("STEP_CHECK", (endTime - startTime));
    return output;
  }

  void setMetricsClient(final Metrics mockedMetricsClient) {
    this.metrics = mockedMetricsClient;
  }

}
