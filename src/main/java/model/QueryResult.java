package model;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class QueryResult {
	private String query;
	private String result;
	private String breakLabel;
	
	public boolean isResultEmpty() {
		return Objects.isNull(result) || result.isEmpty();
	}
	
	public boolean isEmptyHorizontalTab() {
		return Objects.isNull(breakLabel) || breakLabel.isEmpty();
	}
	
	public String getQueryStyle() {
		return isResultEmpty() ? "ui-g-12" : "ui-g-4";
	}
}
