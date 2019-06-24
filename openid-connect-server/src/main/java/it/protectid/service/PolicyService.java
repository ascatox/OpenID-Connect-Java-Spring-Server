package it.protectid.service;

import it.protectid.dir.DIRService;
import it.protectid.model.policy.Ppm;
import it.protectid.repository.JpaPpmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {

	@Autowired
	DIRService dirService;
	JpaPpmRepository jpaPpmRepository;

	public Ppm retrievePpm(String ppm){
		return null;
	}


}
