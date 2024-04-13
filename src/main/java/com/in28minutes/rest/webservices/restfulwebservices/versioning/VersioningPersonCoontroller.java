package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonCoontroller {

//	********** URL versioning - Twitter *************
	
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob",  "Charlie"));
	}
	
//	*********** Request parameter versioning - Amazon ************   
//	[http://localhost:8080/person?version=1]
	
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstVersionOfPersonRequestParameter() {
		return new PersonV1("Bob Charlie");
	}
	
//	http://localhost:8080/person?version=2
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParameter() {
		return new PersonV2(new Name("Bob",  "Charlie"));
	}
	
//	************* Custom headers versioning - Microsoft ***************
//	path same as mentioned in 'path' and an header with key as X-API-VERSION and value as 1 
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeader() {
		return new PersonV1("Bob Charlie");
	}
	
//	path same as mentioned in 'path' and an header with key as X-API-VERSION and value as 2
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		return new PersonV2(new Name("Bob",  "Charlie"));
	}
	
//	************** Media type versioning (a.k.a "content negotiation" or "accept header") - Github
//	SAME-URL produces=application/vnd.company.app-v1+json
	
	@GetMapping(path = "/person/accept", produces =  "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonAcceptHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/accept", produces =  "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		return new PersonV2(new Name("Bob",  "Charlie"));
	}
}
