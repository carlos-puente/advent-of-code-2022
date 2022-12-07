package adventofcode2022.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Directory {
	String name;
	Directory parent;
	List<Directory> subdirectories;
	List<File> files;

}
