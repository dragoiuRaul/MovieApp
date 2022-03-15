package ro.pex.movie.model.dto;

import java.util.List;

public class ExcelWorkSheetDto<T> {

	private String name;
	private List<T> content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

}
