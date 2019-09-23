package com.philips.anagram.validators;

import java.util.List;

public interface InputValidator {
	void validate(List<String> input) throws IllegalArgumentException;
}
