package adventofcode2022;

import static data.DataInput.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdventOfCode5 {
	public static void main(final String[] args) {
		final List<String> movements = getMovements();
		List<List<String>> stacks = new ArrayList<>(getStacks());
		List<List<String>> stacks2 = new ArrayList<>(getStacks());
		for (final String movement : movements) {
			final String[] splittedMovements = movement.split(",");
			moveStacks(
					stacks,
					Integer.valueOf(splittedMovements[0]),
					Integer.valueOf(splittedMovements[1]) - 1,
					Integer.valueOf(splittedMovements[2]) - 1
			);
			moveStacksFull(
					stacks2,
					Integer.valueOf(splittedMovements[0]),
					Integer.valueOf(splittedMovements[1]) - 1,
					Integer.valueOf(splittedMovements[2]) - 1
			);
		}
		System.out.println(showTopStaks(stacks));
		System.out.println(showTopStaks(stacks2));
	}

	private static String showTopStaks(List<List<String>> stacks) {
		String tops = "";
		for (List<String> stack : stacks) {
			tops += stack.get(0);
		}
		return tops;
	}

	private static void moveStacks(List<List<String>> stacks, final Integer elementsToMove, final Integer from, final Integer to) {
		for (int i = 0; i < elementsToMove; i++) {
			final String element = stacks.get(from).get(0);
			stacks.get(from).remove(0);
			Collections.reverse(stacks.get(to));
			stacks.get(to).add(element);
			Collections.reverse(stacks.get(to));
		}
	}

	private static void moveStacksFull(List<List<String>> stacks, final Integer numElementsToMove, final Integer from, final Integer to) {
		List<String> elementsToBeMoved = getStackElementsToMove(stacks, numElementsToMove, from);
		Collections.reverse(elementsToBeMoved);
		Collections.reverse(stacks.get(to));
		stacks.get(to).addAll(elementsToBeMoved);
		Collections.reverse(stacks.get(to));
	}

	private static List<String> getStackElementsToMove(List<List<String>> stacks, Integer numElementsToMove, Integer from) {
		List<String> elementsToBeMoved = new ArrayList<>();
		for (int i = 0; i < numElementsToMove; i++) {
			elementsToBeMoved.add(stacks.get(from).get(0));
			stacks.get(from).remove(0);
		}
		return elementsToBeMoved;
	}
}
