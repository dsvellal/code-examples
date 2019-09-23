package com.philips.anagram.constants;

public enum Whitespaces {
	SPACE(" "), TAB("\\t"), LINE("\\n");

	private String whitespace;

	Whitespaces(String whitespace) {
		this.whitespace = whitespace;
	}
	
	public String getValue() {
		return this.whitespace;
	}

}
