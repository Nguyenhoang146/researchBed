package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Researcher {
	private Long id;
	private String researchRef;
	private String name;
	private Long age;
	private Long isStudent;
}
