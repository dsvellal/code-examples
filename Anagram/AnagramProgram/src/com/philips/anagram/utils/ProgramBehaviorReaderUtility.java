package com.philips.anagram.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.philips.anagram.constants.ConstantsToDataTypeMapping;
import com.philips.anagram.constants.PreProcessingSteps;
import com.philips.anagram.constants.ProgramBehaviorKeys;
import com.philips.anagram.constants.Punctuations;
import com.philips.anagram.constants.StepsToExecute;
import com.philips.anagram.constants.ValidationSteps;
import com.philips.anagram.constants.Whitespaces;
import com.philips.elasticsearch.metrics.client.Metrics;

public class ProgramBehaviorReaderUtility {
  private static final String defaultBehaviorConfigurationDirectory = "BehaviorConfigurations";
  private static Metrics metrics = null;

  static {
    try {
      metrics = new Metrics(ProgramBehaviorReaderUtility.class);
    } catch (final IOException e) {
      e.printStackTrace(System.out);
    }
  }

  private ProgramBehaviorReaderUtility() {
  }

  public static Map<ProgramBehaviorKeys, Object> getProgramBehaviorMap(final String programBehaviorConfigPathString,
      final int beahviorConfigurationNumber) {
    final long startTime = System.nanoTime();
    final List<String> lines = FileUtility.getListOfStringFromDirectoryAndFileNumber(programBehaviorConfigPathString,
        beahviorConfigurationNumber, defaultBehaviorConfigurationDirectory);
    final long endTime = System.nanoTime();
    metrics.publishSuccessMetrics("GET_BEHAVIOR", (endTime - startTime));
    return parseLinesAndGetProgramBehaviorMap(lines);
  }

  private static Map<ProgramBehaviorKeys, Object> parseLinesAndGetProgramBehaviorMap(final List<String> lines) {
    final long startTime = System.nanoTime();
    final Map<ProgramBehaviorKeys, Object> programBehaviorMap = new HashMap<>();
    for (final String line : lines) {
      final List<String> keyValues = StringUtility.getTokens(line, "=");
      final String key = keyValues.get(0);
      final Object values = getValuesFromKeyValuesList(keyValues);
      programBehaviorMap.put(ProgramBehaviorKeys.valueOf(key), values);
    }
    final long endTime = System.nanoTime();
    metrics.publishSuccessMetrics("PARSE_LINES", (endTime - startTime));
    return programBehaviorMap;
  }

  private static Object getValuesFromKeyValuesList(final List<String> keyValues) {
    final long startTime = System.nanoTime();
    final String key = keyValues.get(0);
    final List<String> values = keyValues.subList(1, keyValues.size());
    final ProgramBehaviorKeys programBehaviorKey = ProgramBehaviorKeys.valueOf(key);
    final Class<?> typeOfClass = ConstantsToDataTypeMapping.getMapInstance().get(programBehaviorKey);

    if (typeOfClass == null) {
      final long endTime = System.nanoTime();
      metrics.publishFailureMetrics("GET_VALUES", Arrays.asList("CLASS_TYPE"), (endTime - startTime));
      throw new IllegalArgumentException(
          "Unable to get typeOfClass for the specified programBehaviorKey: " + programBehaviorKey.toString());
    }

    if (typeOfClass.getName().contains("String")) {
      if (values.size() != 1) {
        final long endTime = System.nanoTime();
        metrics.publishFailureMetrics("GET_VALUES", Arrays.asList("TYPE_ERROR"), (endTime - startTime));
        throw new IllegalArgumentException(
            "A list has been provided in place of a string. Please check the value of the configuration: " + key);
      }

      final long endTime = System.nanoTime();
      metrics.publishSuccessMetrics("GET_VALUES", (endTime - startTime));
      return values.get(0);
    } else if (typeOfClass.getName().contains("List")) {
      final List<Object> enumList = getValuesOfEnums(key, values.get(0));
      final long endTime = System.nanoTime();
      metrics.publishSuccessMetrics("GET_VALUES", (endTime - startTime));
      return enumList;
    }

    final long endTime = System.nanoTime();
    metrics.publishFailureMetrics("GET_VALUES", Arrays.asList("UNSUPPORTED_DATATYPE"), (endTime - startTime));
    throw new IllegalArgumentException(
        "Unsupported data-type passed for values. Supported ones are List<String> or String");
  }

  private static List<Object> getValuesOfEnums(final String key, final String listAsValue) {
    final long startTime = System.nanoTime();
    final List<String> values = StringUtility.getTokens(listAsValue, ",");
    final List<Object> enumList = new ArrayList<>();
    // TODO: Repition of code, for each of the siwtch case. Remove repition.
    switch (key) {
    case "PreProcessingSteps":
      for (final String value : values) {
        final PreProcessingSteps step = PreProcessingSteps.valueOf(value);
        if (step == null) {
          final long endTime = System.nanoTime();
          metrics.publishFailureMetrics("GET_ENUMS", Arrays.asList("PARSE_ERROR"), (endTime - startTime));
          throw new IllegalArgumentException(
              "Unable to parse value: " + value + " into an object of constant type: PreProcessingSteps");
        }
        enumList.add(step);
      }
      break;
    case "Punctuations":
      for (final String value : values) {
        boolean valueFound = false;
        for (final Punctuations punctuation : Punctuations.values()) {
          if (punctuation.getValue().equals(value)) {
            enumList.add(punctuation);
            valueFound = true;
            break;
          }
        }

        if (!valueFound) {
          final long endTime = System.nanoTime();
          metrics.publishFailureMetrics("GET_ENUMS", Arrays.asList("VALUE_NOT_FOUND"), (endTime - startTime));
          throw new IllegalArgumentException(
              "Unable to parse value: " + value + " into an object of constant type: Punctuations");
        }
      }
      break;
    case "StepsToExecute":
      for (final String value : values) {
        final StepsToExecute stepToExecute = StepsToExecute.valueOf(value);
        if (stepToExecute == null) {
          final long endTime = System.nanoTime();
          metrics.publishFailureMetrics("GET_ENUMS", Arrays.asList("PARSE_ERROR"), (endTime - startTime));
          throw new IllegalArgumentException(
              "Unable to parse value: " + value + " into an object of constant type: StepsToExecute");
        }
        enumList.add(stepToExecute);
      }
      break;
    case "ValidationSteps":
      for (final String value : values) {
        final ValidationSteps validationStep = ValidationSteps.valueOf(value);
        if (validationStep == null) {
          final long endTime = System.nanoTime();
          metrics.publishFailureMetrics("GET_ENUMS", Arrays.asList("PARSE_ERROR"), (endTime - startTime));
          throw new IllegalArgumentException(
              "Unable to parse value: " + value + " into an object of constant type: ValidationSteps");
        }
        enumList.add(validationStep);
      }
      break;
    case "Whitespaces":
      for (final String value : values) {
        boolean valueFound = false;
        for (final Whitespaces whitespace : Whitespaces.values()) {
          if (whitespace.getValue().equals(value)) {
            enumList.add(whitespace);
            valueFound = true;
            break;
          }
        }
        if (!valueFound) {
          final long endTime = System.nanoTime();
          metrics.publishFailureMetrics("GET_ENUMS", Arrays.asList("PARSE_ERROR"), (endTime - startTime));
          throw new IllegalArgumentException(
              "Unable to parse value: " + value + " into an object of constant type: WhiteSpaces");
        }
      }
      break;
    default:
      final long endTime = System.nanoTime();
      metrics.publishFailureMetrics("GET_ENUMS", Arrays.asList("INVALID_INPUT"), (endTime - startTime));
      throw new IllegalArgumentException("Unable to parse the type of constant provided: " + key);

    }

    final long endTime = System.nanoTime();
    metrics.publishSuccessMetrics("GET_ENUMS", (endTime - startTime));
    return enumList;
  }
}
