package it.protectid.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ascatox
 */
@Controller
public class PolicyController {

	@RequestMapping(value = "/authorize", method = RequestMethod.POST)
	public void subscription() {
		//TODO Business Logic to implement policy emssion

	}

	@RequestMapping(value = "/approve", method = RequestMethod.POST)
	public void approve() {
		//TODO Business Logic to implement policy consensus

	}


}
