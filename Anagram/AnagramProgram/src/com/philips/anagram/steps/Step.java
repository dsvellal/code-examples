package com.philips.anagram.steps;

import java.util.List;
import java.util.Map;

import com.philips.anagram.constants.ProgramBehaviorKeys;

public interface Step {
	List<String> execute(List<String> inputs, Map<ProgramBehaviorKeys, Object> configs);
}
