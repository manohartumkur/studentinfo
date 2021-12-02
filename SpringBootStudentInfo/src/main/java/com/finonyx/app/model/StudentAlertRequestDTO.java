package com.finonyx.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentAlertRequestDTO extends StudentAlertDTO {

	@JsonProperty("Username")
	private String Username;

	@JsonProperty("Password")
	private String Password;

}