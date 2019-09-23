package com.philips.anagram.steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.philips.anagram.constants.ProgramBehaviorKeys;
import com.philips.anagram.constants.ValidationSteps;
import com.philips.anagram.validators.InputValidator;
import com.philips.anagram.validators.ValidationFactory;
import com.philips.elasticsearch.metrics.client.Metrics;

public class Validate implements Step {
  private Metrics metrics = null;

  Validate() {
    try {
      metrics = new Metrics(Validate.class);
    } catch (final IOException e) {
      e.printStackTrace(System.out);
    }
  }

  @Override
  public List<String> execute(final List<String> inputs, final Map<ProgramBehaviorKeys, Object> configs) {
    final long startTime = System.nanoTime();
    final List<ValidationSteps> validationSteps = (List<ValidationSteps>) configs
        .get(ProgramBehaviorKeys.ValidationSteps);

    validationSteps.forEach((validation) -> {
      final InputValidator validator = ValidationFactory.getInputValidatorInstance(validation);
      validator.validate(inputs);
    });

    final long endTime = System.nanoTime();
    metrics.publishSuccessMetrics("STEP_VALIDATE", (endTime - startTime));

    return inputs;
  }
}
