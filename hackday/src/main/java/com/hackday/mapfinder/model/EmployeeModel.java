/**
 * 
 */
package com.hackday.mapfinder.model;

/**
 * @author FFSY
 *
 */
public class EmployeeModel {

	private String firstName;
	private String lastName;
	private String title;
	private String phoneNumer;
	private String cubicle;
	private String alias;
	private String supervisorAlias;

	// employee photo !!

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fName) {
		this.firstName = fName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lName) {
		this.lastName = lName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhoneNumer() {
		return phoneNumer;
	}

	public void setPhoneNumer(String phoneNumer) {
		this.phoneNumer = phoneNumer;
	}

	public String getCubicle() {
		return cubicle;
	}

	public void setCubicle(String d) {
		this.cubicle = d;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getSupervisorAlias() {
		return supervisorAlias;
	}

	public void setSupervisorAlias(String supervisorAlias) {
		this.supervisorAlias = supervisorAlias;
	}
	

}
