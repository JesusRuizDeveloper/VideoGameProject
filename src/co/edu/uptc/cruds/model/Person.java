package co.edu.uptc.cruds.model;

import java.util.Date;

public class Person extends BaseClass {
	protected String name;
	protected String numberID;
	protected Date birthdate;
	
	public Person() {
		
	}
	
	public Person(String name, String numberID, Date birthdate) {
		super();
		this.name = name;
		this.numberID = numberID;
		this.birthdate = birthdate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumberID() {
		return numberID;
	}
	public void setNumberID(String numberID) {
		this.numberID = numberID;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
}
