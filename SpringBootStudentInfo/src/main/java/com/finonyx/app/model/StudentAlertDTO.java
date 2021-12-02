package com.finonyx.app.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentAlertDTO {

	@Size(min = 1, message = "Student Number should be atleast one character")
	@JsonProperty("StudentNumber")
	private String StudentNumber;

	@JsonProperty("AccountNumber")
	@Size(min = 1, message = "Account Number should be atleast one character")
	@NotEmpty
	private String AccountNumber;
	@JsonProperty("TransactionCode")
	@Size(min = 1, message = "Transaction Code should be atleast one character")
	@NotEmpty
	private String TransactionCode;

	@JsonProperty("PaymentMode")
	@Size(min = 1, message = "payment mode should be atleast one character")
	@NotEmpty
	private String PaymentMode;

	@JsonProperty("Amount")
	@NotNull(message = "Amount should not be empty")
	private Double Amount;

	@JsonProperty("TransactionDate")
	@NotEmpty(message = "Transaction code should not be empty")
	private String TransactionDate;
}