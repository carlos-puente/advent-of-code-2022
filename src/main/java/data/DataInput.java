package data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataInput {

	private static List<String> getListByPath(final String path) {
		try {
			return Files.readAllLines(Paths.get(path), Charset.defaultCharset());
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

	static String readFile(String path) {
		byte[] encoded = new byte[0];
		try {
			encoded = Files.readAllBytes(Paths.get(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return new String(encoded, Charset.defaultCharset());
	}

	public static String getDataStreamBuffer() {
		return readFile("src/main/resources/inputDay6.txt");
	}

	public static List<String> getCalories() {
		return getListByPath("src/main/resources/inputDay1.txt");
	}

	public static List<String> getFileSystem() {
		return getListByPath("src/main/resources/inputDay7.txt");
	}

	public static List<String> getTheirMovements() {
		return getListByPath("src/main/resources/inputDay2Their.txt");
	}

	public static List<String> getOurMovements() {
		return getListByPath("src/main/resources/inputDay2Our.txt");
	}

	public static List<String> getRucksacks() {
		return getListByPath("src/main/resources/inputDay3.txt");
	}

	public static List<String> getAssignmentPairs() {
		return getListByPath("src/main/resources/inputDay4.txt");
	}

	public static String[] toArray(final List<String> list) {
		return list.toArray(String[]::new);
	}

	public static final Map<Character, Integer> itemsValue = new HashMap<>() {{
		put('a', Integer.valueOf(1));
		put('b', Integer.valueOf(2));
		put('c', Integer.valueOf(3));
		put('d', Integer.valueOf(4));
		put('e', Integer.valueOf(5));
		put('f', Integer.valueOf(6));
		put('g', Integer.valueOf(7));
		put('h', Integer.valueOf(8));
		put('i', Integer.valueOf(9));
		put('j', Integer.valueOf(10));
		put('k', Integer.valueOf(11));
		put('l', Integer.valueOf(12));
		put('m', Integer.valueOf(13));
		put('n', Integer.valueOf(14));
		put('o', Integer.valueOf(17));
		put('p', Integer.valueOf(16));
		put('q', Integer.valueOf(17));
		put('r', Integer.valueOf(18));
		put('s', Integer.valueOf(19));
		put('t', Integer.valueOf(20));
		put('u', Integer.valueOf(21));
		put('v', Integer.valueOf(22));
		put('w', Integer.valueOf(23));
		put('x', Integer.valueOf(24));
		put('y', Integer.valueOf(25));
		put('z', Integer.valueOf(26));
		put('A', Integer.valueOf(27));
		put('B', Integer.valueOf(28));
		put('C', Integer.valueOf(29));
		put('D', Integer.valueOf(30));
		put('E', Integer.valueOf(31));
		put('F', Integer.valueOf(32));
		put('G', Integer.valueOf(33));
		put('H', Integer.valueOf(34));
		put('I', Integer.valueOf(35));
		put('J', Integer.valueOf(36));
		put('K', Integer.valueOf(37));
		put('L', Integer.valueOf(38));
		put('M', Integer.valueOf(39));
		put('N', Integer.valueOf(40));
		put('O', Integer.valueOf(41));
		put('P', Integer.valueOf(42));
		put('Q', Integer.valueOf(43));
		put('R', Integer.valueOf(44));
		put('S', Integer.valueOf(45));
		put('T', Integer.valueOf(46));
		put('U', Integer.valueOf(47));
		put('V', Integer.valueOf(48));
		put('W', Integer.valueOf(49));
		put('X', Integer.valueOf(50));
		put('Y', Integer.valueOf(51));
		put('Z', Integer.valueOf(52));

	}};

	static List<String> stack1 = Stream.of("F", "H", "M", "T", "V", "L", "D").collect(Collectors.toList());
	static List<String> stack2 = Stream.of("P", "N", "T", "C", "J", "G", "Q", "H").collect(Collectors.toList());
	static List<String> stack3 = Stream.of("H", "P", "M", "D", "S", "R").collect(Collectors.toList());
	static List<String> stack4 = Stream.of("F", "V", "B", "L").collect(Collectors.toList());
	static List<String> stack5 = Stream.of("Q", "L", "G", "H", "N").collect(Collectors.toList());
	static List<String> stack6 = Stream.of("P", "M", "R", "G", "D", "B", "W").collect(Collectors.toList());
	static List<String> stack7 = Stream.of("Q", "L", "H", "C", "R", "N", "M", "G").collect(Collectors.toList());
	static List<String> stack8 = Stream.of("W", "L", "C").collect(Collectors.toList());
	static List<String> stack9 = Stream.of("T", "M", "Z", "J", "Q", "L", "D", "R").collect(Collectors.toList());

	public static List<List<String>> getStacks() {
		return new ArrayList<>(
				Stream.of(new ArrayList<>(stack1), new ArrayList<>(stack2), new ArrayList<>(stack3), new ArrayList<>(stack4), new ArrayList<>(stack5),
						new ArrayList<>(stack6), new ArrayList<>(stack7), new ArrayList<>(stack8), new ArrayList<>(stack9)).collect(Collectors.toList()));
	}

	public static List<String> getMovements() {
		return getListByPath("src/main/resources/inputDay5.txt");
	}

}

