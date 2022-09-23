package com.example.anagram.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.example.anagram.constants.ProgramBehaviorKeys;
import com.example.anagram.constants.StepsToExecute;
import com.example.anagram.steps.Step;
import com.example.anagram.steps.StepFactory;
import com.example.elasticsearch.metrics.client.Metrics;

public class MainClassOrchestrator {
  private Metrics metrics = null;

  public MainClassOrchestrator() {
    try {
      metrics = new Metrics(MainClassOrchestrator.class);
    } catch (final IOException e) {
      e.printStackTrace(System.out);
    }
  }

  public List<String> orchestrate(List<String> inputs, final Map<ProgramBehaviorKeys, Object> behaviorProperties) {
    final List<String> copiedInput = new ArrayList<>();
    for (final String input : inputs) {
      copiedInput.add(input);
    }

    final long startTime = System.nanoTime();
    final List<StepsToExecute> steps = getListOfStepsToExecute(
        behaviorProperties.get(ProgramBehaviorKeys.StepsToExecute));
    for (final StepsToExecute step : steps) {
      final Step stepToExecute = StepFactory.getStepInstance(step);

      inputs = stepToExecute.execute(inputs, behaviorProperties);
    }

    final long endTime = System.nanoTime();
    metrics.publishSuccessMetrics("ORCHESTRATOR", (endTime - startTime));

    System.out.println("Inputs: " + copiedInput);
    System.out.println("Behavior: " + behaviorProperties);
    System.out.println("Output: " + inputs);

    return inputs;
  }

  private List<StepsToExecute> getListOfStepsToExecute(final Object object) {
    if (!object.getClass().getName().contains("List")) {
      metrics.publishFailureMetrics("GET_LIST_OF_STEPS", Arrays.asList("NON_LIST_DATATYPE"), 0);
      throw new IllegalArgumentException("Expected a list, recieved a non-list datatype!");
    }

    return (List<StepsToExecute>) object;
  }
}
