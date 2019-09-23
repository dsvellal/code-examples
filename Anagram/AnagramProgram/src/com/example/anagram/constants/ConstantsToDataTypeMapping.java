package com.philips.anagram.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConstantsToDataTypeMapping {
	private Map<ProgramBehaviorKeys, Class<?>> programBehaviorConstantsToDataTypeMap = new HashMap<>();

	private ConstantsToDataTypeMapping() {
		initialize();
	}

	private static ConstantsToDataTypeMapping singletonInstance;

	private void initialize() {
		programBehaviorConstantsToDataTypeMap.put(ProgramBehaviorKeys.DetectionAlgorithm, String.class);
		programBehaviorConstantsToDataTypeMap.put(ProgramBehaviorKeys.PreProcessingSteps,
				Collections.<String>emptyList().getClass());
		programBehaviorConstantsToDataTypeMap.put(ProgramBehaviorKeys.Punctuations,
				Collections.<String>emptyList().getClass());
		programBehaviorConstantsToDataTypeMap.put(ProgramBehaviorKeys.StepsToExecute,
				Collections.<String>emptyList().getClass());
		programBehaviorConstantsToDataTypeMap.put(ProgramBehaviorKeys.ValidationSteps,
				Collections.<String>emptyList().getClass());
		programBehaviorConstantsToDataTypeMap.put(ProgramBehaviorKeys.Whitespaces,
				Collections.<String>emptyList().getClass());
	}

	public static Map<ProgramBehaviorKeys, Class<?>> getMapInstance() {
		if (singletonInstance == null) {
			singletonInstance = new ConstantsToDataTypeMapping();
		}

		return singletonInstance.programBehaviorConstantsToDataTypeMap;

	}
}
