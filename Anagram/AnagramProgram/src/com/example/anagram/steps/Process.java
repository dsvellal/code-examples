package com.example.anagram.steps;

import java.util.List;
import java.util.Map;

import com.example.anagram.constants.PreProcessingSteps;
import com.example.anagram.constants.ProgramBehaviorKeys;
import com.example.anagram.processors.InputProcessor;
import com.example.anagram.processors.InputProcessorFactory;

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
