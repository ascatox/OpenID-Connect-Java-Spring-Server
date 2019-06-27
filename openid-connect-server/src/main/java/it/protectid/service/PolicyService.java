package it.protectid.service;

import it.protectid.dir.DIRService;
import it.protectid.model.policy.PolicyModel;
import it.protectid.model.policy.Ppm;
import it.protectid.repository.JpaPpmRepository;
import it.protectid.utils.OntoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PolicyService {
	@Autowired
	DIRService dirService;
	@Autowired
	JpaPpmRepository jpaPpmRepository;

	public PolicyModel retrievePpm(String ppmFromRequest) throws Exception {
		Ppm ppm = null;
		if (StringUtils.isEmpty(ppmFromRequest)) {
			List<Ppm> ppms = jpaPpmRepository.getAll();
			ppm = ppms.get(0);
		} else ppm = jpaPpmRepository.getById(ppmFromRequest);
		return OntoConverter.createModelFromOntology(ppm.getModel	());
	}


}
