package org.rakiworld.streams;

import java.util.Map;
import java.util.stream.Stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

import java.util.Arrays;

public class StreamFlatMap {

	public static void main(String[] args) {
		Stream<String> words = Stream.of("Welcome", "to", "world", "of", "micro services");

		Map<String, Long> letterToCount = words.map(w -> w.split("")) // Stream<String[]>
				.flatMap(Arrays::stream).collect(groupingBy(identity(), counting()));
		System.out.println(letterToCount);
	}
}
