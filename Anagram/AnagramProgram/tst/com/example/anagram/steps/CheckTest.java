/*
 * Copyright of Philips, 2019
 *
 * This file is subject to the terms and conditions defined by Philips,
 * visit https://www.ip.philips.com/licensing/ for more details.
 *
 * @author: dsvellal@philips.com
 *
 */
package com.philips.anagram.steps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.philips.anagram.constants.DetectionAlgorithm;
import com.philips.anagram.constants.ProgramBehaviorKeys;
import com.philips.elasticsearch.metrics.client.Metrics;

public class CheckTest {

  private Metrics mockedMetricsClient;
  private Map<ProgramBehaviorKeys, Object> configs;

  @Before
  public void setup() {
    mockedMetricsClient = Mockito.mock(Metrics.class);
    configs = new HashMap<>();
    configs.put(ProgramBehaviorKeys.DetectionAlgorithm, DetectionAlgorithm.DetectionBySorting);
  }

  @Test
  public void testCheckIsAnagramCase() {
    final Check check = new Check();
    check.setMetricsClient(mockedMetricsClient);
    Mockito.doNothing().when(mockedMetricsClient).publishSuccessMetrics(Mockito.anyString(), Mockito.anyLong());
    final List<String> inputs = Arrays.asList("abc", "acb");
    final List<String> outputs = check.execute(inputs, configs);
    Assert.assertEquals("[Is Anagram: true]", outputs.toString());
  }

  @Test
  public void testCheckIsNotAnagramCase() {
    final Check check = new Check();
    check.setMetricsClient(mockedMetricsClient);
    Mockito.doNothing().when(mockedMetricsClient).publishSuccessMetrics(Mockito.anyString(), Mockito.anyLong());
    final List<String> inputs = Arrays.asList("abd", "acb");
    final List<String> outputs = check.execute(inputs, configs);
    Assert.assertEquals("[Is Anagram: false]", outputs.toString());
  }
}
