/*
 * Copyright of Philips, 2019
 *
 * This file is subject to the terms and conditions defined by Philips,
 * visit https://www.ip.philips.com/licensing/ for more details.
 *
 */
package com.philips.anagram.processors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.philips.anagram.constants.ProgramBehaviorKeys;

public class CaseNormalizerInputProcessor implements InputProcessor {

  CaseNormalizerInputProcessor() {
  }

  @Override
  public List<String> process(final List<String> inputs, final Map<ProgramBehaviorKeys, Object> configs) {
    final List<String> processedStringList = new ArrayList<>();
    inputs.forEach((input) -> {
      processedStringList.add(input.toLowerCase());
    });

    return processedStringList;
  }

}
