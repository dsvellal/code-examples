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

import com.philips.anagram.constants.StepsToExecute;

public class StepFactory {
  private StepFactory() {
  }

  public static Step getStepInstance(final StepsToExecute step) {
    Step stepInstance = null;
    switch (step) {
    case Validate:
      stepInstance = new Validate();
      break;

    case PreProcess:
      stepInstance = new Process();
      break;

    case Detect:
      stepInstance = new Check();
      break;
    }
    return stepInstance;
  }
}
