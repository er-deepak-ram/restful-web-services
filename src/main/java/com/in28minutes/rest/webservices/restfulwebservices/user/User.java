package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

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
	private String name;
	
	@Past(message = "Date of birth should be any past date")
	private LocalDate birthDate;
}
