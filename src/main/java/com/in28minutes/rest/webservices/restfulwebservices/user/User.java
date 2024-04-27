package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

	private Integer id;
	
	@Size(min = 2, message = "User name should have at least 2 characters")
	@JsonProperty("user_name")	// this annotation is used to give different name in response JSON
	private String name;
	
	@Past(message = "Date of birth should be any past date")
	@JsonProperty("birth_date")
	private LocalDate birthDate;
}
