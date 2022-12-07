package adventofcode2022;

import static data.DataInput.*;

import java.util.ArrayList;
import java.util.List;

import adventofcode2022.dto.Directory;
import adventofcode2022.dto.File;

public class AdventOfCode7 {
	static Directory root = null;
	static List<Long> directorySize = new ArrayList<>();

	public static void main(final String[] args) {

		List<String> fileSystem = getFileSystem();

		Directory currentDirectory = null;
		for (String command : fileSystem) {
			String[] parts = command.split(" ");
			if (parts[0].equalsIgnoreCase("$")) {
				if (parts[1].equalsIgnoreCase("cd")) {
					if (parts[2].equalsIgnoreCase("/")) {
						root = new Directory("/", null, new ArrayList<>(), new ArrayList<>());
						currentDirectory = root;
					} else if (parts[2].equalsIgnoreCase("..")) {
						currentDirectory = currentDirectory.getParent();
					} else {
						currentDirectory = findCurrentDirectory(parts[2], currentDirectory);

					}
				}
			} else {
				if (parts[0].equalsIgnoreCase("dir")) {
					currentDirectory.getSubdirectories().add(new Directory(parts[1], currentDirectory, new ArrayList<>(), new ArrayList<>()));
				} else {
					currentDirectory.getFiles().add(new File(parts[1], Long.valueOf(parts[0])));
				}
			}
		}

		long total = searchSizes(root);
		System.out.println("part1: " +
				directorySize.stream()
						.filter(value -> value <= 100000).
						reduce(0l, Long::sum)
		);

		System.out.println("part2: " +
				directorySize.stream()
						.filter(element -> element.longValue() > 30000000 - (70000000 - total))
						.mapToLong(v -> v.longValue())
						.min()
						.getAsLong()
		);
	}

	private static Directory findCurrentDirectory(String directoryName, Directory parentDirectory) {
		for (Directory directory : parentDirectory.getSubdirectories()) {
			if (directory.getName().equalsIgnoreCase(directoryName)) {
				return directory;
			}
		}
		return null;
	}

	private static long searchSizes(Directory directory) {
		long sum = 0;
		sum = sum + getFilesSize(directory.getFiles());
		if (directory.getSubdirectories() != null && !directory.getSubdirectories().isEmpty()) {
			for (Directory subDirectory : directory.getSubdirectories()) {
				sum = sum + searchSizes(subDirectory);
			}
		}
		directorySize.add(sum);
		return sum;
	}

	private static long getFilesSize(List<File> files) {
		long sum = 0;
		if (files != null && !files.isEmpty()) {
			for (File file : files) {
				sum += file.getSize();
			}
		}
		return sum;
	}

}
