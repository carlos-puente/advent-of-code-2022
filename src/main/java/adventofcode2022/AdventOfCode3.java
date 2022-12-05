package adventofcode2022;

import static data.DataInput.*;

public class AdventOfCode3 {
	public static void main(final String[] args) {
		final String[] rucksacks = toArray(getRucksacks());
		int points = 0;
		for (final String rucksack : rucksacks) {
			final int mid = rucksack.length() / 2; //get the middle of the String
			final String[] parts = { rucksack.substring(0, mid), rucksack.substring(mid) };
			points += getPointsByPriority(parts);

		}
		System.out.println(points);
		points = 0;
		final String[] groupThree = new String[] { "", "", "" };
		int cont = 0;
		for (int i = 0; i < rucksacks.length; i++) {
			groupThree[cont++] = rucksacks[i];
			if (cont % 3 == 0) {
				points += getGroupPointsByPriority(groupThree);
				cont = 0;
			}

		}
		System.out.println(points);
	}

	private static int getGroupPointsByPriority(final String[] groupThree) {
		final char common = '1';
		for (int i = 0; i < groupThree[0].toCharArray().length; i++) {
			for (int j = 0; j < groupThree[1].toCharArray().length; j++) {
				if (groupThree[0].toCharArray()[i] == groupThree[1].toCharArray()[j]) {
					for (int z = 0; z < groupThree[2].toCharArray().length; z++) {
						if (groupThree[2].toCharArray()[z] == groupThree[0].toCharArray()[i]) {
							return itemsValue.get(groupThree[2].toCharArray()[z]);
						}
					}
				}
			}
		}
		return 0;
	}

	private static int getPointsByPriority(final String[] parts) {
		final char common = getCommonItem(parts[0], parts[1]);
		if (common != '1') {
			return itemsValue.get(common);
		}
		return 0;
	}

	private static char getCommonItem(final String part1, final String part2) {
		for (final char part1char : part1.toCharArray()) {
			for (final char part2char : part2.toCharArray()) {
				if (part1char == part2char) {
					return part1char;
				}
			}
		}
		return '1';
	}

}
