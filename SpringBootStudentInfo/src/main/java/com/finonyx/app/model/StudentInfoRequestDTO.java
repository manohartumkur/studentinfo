package com.finonyx.app.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "StudentNumber", "Username", "Password" })
@Generated("finonyx")
public class StudentInfoRequestDTO {

	@JsonProperty("StudentNumber")
	private String StudentNumber;
	@JsonProperty("Username")
	private String Username;

	@JsonProperty("Password")
	private String Password;

	@JsonProperty("StudentNumber")
	public String getStudentNumber() {
		return StudentNumber;
	}

	@JsonProperty("StudentNumber")
	public void setStudentNumber(String StudentNumber) {
		this.StudentNumber = StudentNumber;
	}

	@JsonProperty("Password")
	public String getPassword() {
		return Password;
	}

	@JsonProperty("Username")
	public String getUsername() {
		return Username;
	}

	@JsonProperty("Username")
	public void setUsername(String Username) {
		this.Username = Username;
	}

	@JsonProperty("Password")
	public void setPassword(String Password) {
		this.Password = Password;
	}

}