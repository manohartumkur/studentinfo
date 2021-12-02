package com.finonyx.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finonyx.app.model.Name;
import com.finonyx.app.model.PersonV1;
import com.finonyx.app.model.PersonV2;

@RestController
public class PersonVersioningController {

	@GetMapping("/v1/person")
	public PersonV1 getPersonV1() {

		return new PersonV1("Manohara P H");
	}

	@GetMapping("/v2/person")
	public PersonV2 getPersonV2() {

		return new PersonV2(new Name("Manohara", "P H"));
	}

	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramsV1() {

		return new PersonV1("Manohara P H");
	}

	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramsV2() {

		return new PersonV2(new Name("Manohara", "P H"));
	}

	@GetMapping(value = "/person/header", headers  = "version=1")
	public PersonV1 headerV1() {

		return new PersonV1("Manohara P H");
	}

	@GetMapping(value = "/person/header", headers  = "version=2")
	public PersonV2 headerV2() {

		return new PersonV2(new Name("Manohara", "P H"));
	}
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
}
