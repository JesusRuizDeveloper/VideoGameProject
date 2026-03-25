package co.edu.uptc.cruds.model;

import java.util.Date;

public class Student extends Person {
	private static int numberId;
	private String code;

	public Student(String code) {
		super();
		this.code = code;
	}

	public Student(String name, String numberID, String code, Date birthday) {
		super(name, numberID, birthday);
		this.code = code;
		this.id = ++numberId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Student [code=" + code + ", name=" + name + ", numberID=" + numberID + ", birthdate="
				+ birthdate + ", id=" + id + "]";
	}
	
	
}
