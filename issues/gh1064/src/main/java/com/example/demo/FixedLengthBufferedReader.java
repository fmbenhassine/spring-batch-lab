package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class FixedLengthBufferedReader extends BufferedReader {

	public static final int DEFAULT_LINE_LENGTH = 32;
	private int length;

	public FixedLengthBufferedReader(Reader in) {
		this(in, DEFAULT_LINE_LENGTH);
	}
	
	public FixedLengthBufferedReader(Reader in, int length) {
		super(in);
		this.length = length;
	}

	// FIXME quick and dirty: add sanity checks, etc 
	@Override
	public String readLine() throws IOException {
		int next = read();
		if (next == -1) {
			return null;
		}
		StringBuilder buffer = new StringBuilder();
		buffer.append((char)next);
		for (int i = 1; i < length; i++) {
			next = read();
			if (next != -1) {
				buffer.append((char)next);
			} else {
				break;
			}
		}
		return buffer.toString();
	}
}
