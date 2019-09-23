package com.philips.anagram.processors;

import java.util.List;
import java.util.Map;

import com.philips.anagram.constants.ProgramBehaviorKeys;

public interface InputProcessor {
	List<String> process(List<String> inputs, Map<ProgramBehaviorKeys, Object> configs);
}
