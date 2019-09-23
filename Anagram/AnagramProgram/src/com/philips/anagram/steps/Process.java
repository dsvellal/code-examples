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

import java.util.List;
import java.util.Map;

import com.philips.anagram.constants.PreProcessingSteps;
import com.philips.anagram.constants.ProgramBehaviorKeys;
import com.philips.anagram.processors.InputProcessor;
import com.philips.anagram.processors.InputProcessorFactory;

public class Process implements Step {

  Process() {
  }

  @Override
  public List<String> execute(List<String> inputs, final Map<ProgramBehaviorKeys, Object> configs) {
    final List<Object> processorSteps = getListOfPreprocessingSteps(
        configs.get(ProgramBehaviorKeys.PreProcessingSteps));

    for (final Object processorStep : processorSteps) {
      final InputProcessor processor = InputProcessorFactory
          .getInputProcessorInstance((PreProcessingSteps) processorStep);
      inputs = processor.process(inputs, configs);
    }

    return inputs;
  }

  private List<Object> getListOfPreprocessingSteps(final Object object) {
    if (!object.getClass().getName().contains("List")) {
      throw new IllegalArgumentException("Unable to process the object. Expected a list, received a non-list type!");
    }

    return (List<Object>) object;
  }
}
