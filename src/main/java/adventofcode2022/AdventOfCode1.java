package adventofcode2022;

import static data.DataInput.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AdventOfCode1 {

	public static void main(final String[] args) {

		long sumCalories = 0;
		final List<Long> elves = new ArrayList<>();
		for (final String calory : getCalories()) {
			if (!calory.isEmpty()) {
				sumCalories = sumCalories + Long.valueOf(calory);
			} else {
				elves.add(sumCalories);
				sumCalories = 0;
			}
		}
		System.out.println("The Elf carrying the most calories carries: " + Collections.max(elves) + " calories");

		//PART 2
		Collections.sort(elves, Collections.reverseOrder());
		System.out.println("The Elves carrying the most calories are carrying: " + elves.subList(0, 3));
		System.out.println("And in total they are carrying: " +
				elves.subList(0, 3).stream().collect(Collectors.summingLong(Long::longValue))
				+ " calories");
	}

}
