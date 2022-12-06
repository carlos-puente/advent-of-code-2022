package adventofcode2022;

import static data.DataInput.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdventOfCode6 {
	public static void main(final String[] args) {
		String streamBuffer = getDataStreamBuffer();
		int part1Solution = getSolution(streamBuffer, 4);
		int part2Solution = getSolution(streamBuffer, 14);
		System.out.println("part 1 solution: " + part1Solution);
		System.out.println("part 2 solution: " + part2Solution);
	}

	private static int getSolution(String streamBuffer, int numberOfCharacters) {
		char[] dataStreamBuffer = streamBuffer.toCharArray();
		for (int i = 0; i < dataStreamBuffer.length; i++) {
			try {
				List<Character> list = new ArrayList<>();
				for (int j = 0; j < numberOfCharacters; j++) {
					list.add(dataStreamBuffer[i + j]);
				}
				Set<Character> set = new HashSet<>(list);
				if (set.size() == numberOfCharacters) {
					String sequence = list.toString().replaceAll("\\[|\\]", "").replaceAll(",", "").replaceAll(" ", "");
					return streamBuffer.indexOf(sequence) + numberOfCharacters;
				}
			} catch (IndexOutOfBoundsException ex) {
				System.out.println("finished: sequence not found");
				break;
			}
		}
		return -1;
	}
}
