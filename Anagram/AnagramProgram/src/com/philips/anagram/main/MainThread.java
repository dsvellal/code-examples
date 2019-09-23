package com.philips.anagram.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.philips.anagram.constants.ProgramBehaviorKeys;

public class MainThread implements Runnable {

  private Map<ProgramBehaviorKeys, Object> behaviorProperties = new HashMap<>();
  private final List<String> inputs;

  public MainThread(final Map<ProgramBehaviorKeys, Object> behaviorProperties, final List<String> inputs) {
    this.behaviorProperties = behaviorProperties;
    this.inputs = inputs;
  }

  @Override
  public void run() {
    final MainClassOrchestrator orchestrator = new MainClassOrchestrator();
    orchestrator.orchestrate(inputs, behaviorProperties);
  }
}
