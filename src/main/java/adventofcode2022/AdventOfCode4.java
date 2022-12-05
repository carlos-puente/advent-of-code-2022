package adventofcode2022;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import data.DataInput;

public class AdventOfCode4 {
	public static void main(final String[] args) {
		final List<String> assignments = DataInput.getAssignmentPairs();
		int overlaps = 0;
		int partialOverlaps = 0;
		for (final String assignmentsPair : assignments) {
			final String[] pairs = assignmentsPair.split(",");
			final String[] pair1 = pairs[0].split("-");
			final String[] pair2 = pairs[1].split("-");
			if (checkOverlapping(Integer.valueOf(pair1[0]), Integer.valueOf(pair1[1]), Integer.valueOf(pair2[0]), Integer.valueOf(pair2[1]))) {
				overlaps++;
			}
			if (checkPartialOverlapping(Integer.valueOf(pair1[0]), Integer.valueOf(pair1[1]), Integer.valueOf(pair2[0]), Integer.valueOf(pair2[1]))) {
				partialOverlaps++;
			}
		}
		System.out.println(overlaps);
		System.out.println(partialOverlaps);
	}

	private static boolean checkOverlapping(final int firstSectionStart, final int firstSectionEnd, final int secondSectionStart,
			final int secondSectionEnd) {
		return (firstSectionStart <= secondSectionStart && firstSectionEnd >= secondSectionEnd) ||
				(secondSectionStart <= firstSectionStart && secondSectionEnd >= firstSectionEnd);
	}

	private static boolean checkPartialOverlapping(final int firstSectionStart, final int firstSectionEnd, final int secondSectionStart,
			final int secondSectionEnd) {
		final List<Integer> section1Elements = IntStream.rangeClosed(firstSectionStart, firstSectionEnd)
				.boxed().collect(Collectors.toList());
		final List<Integer> section2Elements = IntStream.rangeClosed(secondSectionStart, secondSectionEnd)
				.boxed().collect(Collectors.toList());
		final List<Integer> result =
				section1Elements.stream().filter(section1 ->
						section2Elements.stream().anyMatch(section2 -> section1 == section2)).collect(Collectors.toList());
		return !result.isEmpty();
	}

}
