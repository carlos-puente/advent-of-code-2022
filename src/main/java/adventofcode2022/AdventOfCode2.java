package adventofcode2022;

import static data.DataInput.*;

import java.util.HashMap;
import java.util.Map;

import data.DataInput;

public class AdventOfCode2 {
	static final String ROCK = "A";
	static final String PAPER = "B";
	static final String OUR_ROCK = "X";
	static final String OUR_PAPER = "Y";
	static final String OUR_SCISSORS = "Z";
	static final String LOSE = "X";
	static final String WIN = "Z";

	static final int WINING_POINTS = 6;
	static final int DRAW_POINTS = 3;

	static final Map<String, Integer> pointsBySelectedShape = new HashMap<>() {{
		put(OUR_ROCK, Integer.valueOf(1));
		put(OUR_PAPER, Integer.valueOf(2));
		put(OUR_SCISSORS, Integer.valueOf(3));
	}};

	public static void main(final String[] args) {
		final String[] theirMovements = DataInput.toArray(getTheirMovements());
		final String[] ourMovements = DataInput.toArray(getOurMovements());
		//PART1
		int points = 0;
		for (int i = 0; i < theirMovements.length; i++) {
			points = points + getRoundPoints(theirMovements[i], ourMovements[i]);
		}
		System.out.println(points);

		//PART 2
		points = 0;
		for (int i = 0; i < theirMovements.length; i++) {
			points = points + getStrategyRoundPoints(theirMovements[i], ourMovements[i]);
		}
		System.out.println(points);

	}

	/**
	 * @param theirMovement
	 * 		A for Rock, B for Paper, and C for Scissors
	 * @param ourMovement
	 * 		X for Rock, Y for Paper, and Z for Scissors
	 * @return points (1 for Rock, 2 for Paper, and 3 for Scissors) + (0 if you lost, 3 if the round was a draw, and 6 if you won).
	 */
	private static int getRoundPoints(final String theirMovement, final String ourMovement) {
		final int points = pointsBySelectedShape.get(ourMovement);
		if (ROCK.equalsIgnoreCase(theirMovement)) {
			if (OUR_PAPER.equalsIgnoreCase(ourMovement)) {
				return points + WINING_POINTS;
			} else if (OUR_SCISSORS.equalsIgnoreCase(ourMovement)) {
				return points;
			}
			return points + DRAW_POINTS;
		} else if (PAPER.equalsIgnoreCase(theirMovement)) {
			if (OUR_ROCK.equalsIgnoreCase(ourMovement)) {
				return points;
			} else if (OUR_SCISSORS.equalsIgnoreCase(ourMovement)) {
				return points + WINING_POINTS;
			}
			return points + DRAW_POINTS;
		} else {
			if (OUR_ROCK.equalsIgnoreCase(ourMovement)) {
				return points + WINING_POINTS;
			} else if (OUR_PAPER.equalsIgnoreCase(ourMovement)) {
				return points;
			}
			return points + DRAW_POINTS;
		}
	}

	/**
	 * Obtains the shape based in our strategy, and gets the points for this round.
	 *
	 * @param theirMovement
	 * 		A for Rock, B for Paper, and C for Scissors
	 * @param ourDecission
	 * 		X  lose, Y  draw, and Z  win
	 * @return points (1 for Rock, 2 for Paper, and 3 for Scissors) + (0 if you lost, 3 if the round was a draw, and 6 if you won).
	 */
	private static int getStrategyRoundPoints(final String theirMovement, final String ourDecission) {
		final String shape = getShapeByStrategy(theirMovement, ourDecission);
		return getRoundPoints(theirMovement, shape);
	}

	/**
	 * Returns the shape needed to lose, draw or win based in the movement of our rival.
	 *
	 * @param theirMovement
	 * 		A for Rock, B for Paper, and C for Scissors
	 * @param ourDecission
	 * 		X  lose, Y  draw, and Z  win
	 * @return X for Rock, Y for Paper, and Z for Scissors
	 */
	private static String getShapeByStrategy(final String theirMovement, final String ourDecission) {
		if (ROCK.equalsIgnoreCase(theirMovement)) {
			if (LOSE.equalsIgnoreCase(ourDecission)) {
				return OUR_SCISSORS;
			} else if (WIN.equalsIgnoreCase(ourDecission)) {
				return OUR_PAPER;
			}
			return OUR_ROCK;
		} else if (PAPER.equalsIgnoreCase(theirMovement)) {
			if (LOSE.equalsIgnoreCase(ourDecission)) {
				return OUR_ROCK;
			} else if (WIN.equalsIgnoreCase(ourDecission)) {
				return OUR_SCISSORS;
			}
			return OUR_PAPER;
		} else {
			if (LOSE.equalsIgnoreCase(ourDecission)) {
				return OUR_PAPER;
			} else if (WIN.equalsIgnoreCase(ourDecission)) {
				return OUR_ROCK;
			}
			return OUR_SCISSORS;
		}
	}

}
