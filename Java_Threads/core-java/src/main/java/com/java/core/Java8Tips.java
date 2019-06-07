package com.java.core;

import java.awt.Point;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import javax.swing.text.Segment;

/**
 * How should we change our coding habits from old to new Java, here are some examples.
 * @author harshul.varshney
 *
 */
public class Java8Tips {
	
	private String comment;
	/* 1.
	 * Do not return null to indicate absence of a value, Use Optional
	 */
	public Optional<String> getComment() {
		return Optional.ofNullable(comment);
	}
	
	/* 2.
	 * DO NOT USE ARRAYS TO PASS VALUES TO AND FROM THE API, Use Stream
	 */
	public Stream<String> comments() {
		return Stream.of(comment);
	}
	
	/* 3.
	 * favor composition with functional interfaces and lambdas over inheritance
	 */
	
	/* 4.
	 * ensure that the API methods check the parameter invariants before they are acted upon, like:
	 */
	public void addToSegment(Segment segment, Point point) {
		Objects.requireNonNull(segment);
		Objects.requireNonNull(point);
		//segment.add(point);
	}
}
