package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public UserHavingPassword filtering() {
		return new UserHavingPassword("Deepak", "Ram", "Daksh");
	}
	
	@GetMapping("/filtering-list")
	public List<UserHavingPassword> filteringList() {
		return Arrays.asList(new UserHavingPassword("Deepak", "Ram", "Daksh"),
				new UserHavingPassword("Hugh", "Jackman", "Wolverine"),
				new UserHavingPassword("Robert", "Downey Jr", "Ironman"));
	}
}
