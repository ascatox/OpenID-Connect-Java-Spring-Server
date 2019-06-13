package it.protectid.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 * @author ascatox
 */
@Controller
public class PolicyController {

	@RequestMapping(value = "/authorize", method = RequestMethod.POST)
	public void subscription(WebRequest request) {
		//TODO Business Logic to implement policy emission
	}

	@RequestMapping(value = "/approve", method = RequestMethod.POST)
	public void approve(WebRequest request) {
		//TODO Business Logic to implement policy consensus
	}


}
