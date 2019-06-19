package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Paper {
	private Long id;
	private String paperRef;
	private String title;
	private Long wordCount;
	private Long isStudentPaper;
}
