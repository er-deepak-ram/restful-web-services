package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
//@JsonIgnoreProperties({"lastName", "password"})  // Similar class level annotation
public class UserHavingPassword {

	private String firstName;
	private String lastName;
	
	@JsonIgnore		// Static filtering -> it will be filtered out in JSON response
	private String password;
}
