package it.protectid.service;

import it.protectid.model.authority.Sid;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * @author clod16
 */
public class DIRService {

	static final String URL_SAWTOOTH = "http://localhost:8080/sawtooth";

	public String post(String payload) {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> requestBody = new HttpEntity<>(payload, httpHeaders);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(URL_SAWTOOTH, requestBody, String.class);

	}
}
