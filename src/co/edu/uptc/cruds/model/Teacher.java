package co.edu.uptc.cruds.model;

public class Teacher extends Person {
	private String codeCourse;
	
	public Teacher() {
		
	}
	
	public Teacher(String codeCourse) {
		super();
		this.codeCourse = codeCourse;
	}

	public String getCodeCourse() {
		return codeCourse;
	}

	public void setCodeCourse(String codeCourse) {
		this.codeCourse = codeCourse;
	}
	
}
