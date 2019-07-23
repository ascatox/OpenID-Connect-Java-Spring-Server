package it.protectid.service;

import it.protectid.onto.OntoManager;
import it.eng.protectid.model.policy.PolicyModel;
import it.eng.protectid.model.policy.Ppm;
import it.protectid.repository.JpaPpmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PolicyService {
	@Autowired
	DirRestClient dirRestClient;
	@Autowired
	JpaPpmRepository jpaPpmRepository;

	public PolicyModel retrievePpm(String ppmFromRequest) throws Exception {
		//TODO
		// Questa parte va interamente rivista sulla base del nuovo modello sulla quale sta lavorando
		// Massimiliano è la parte iniziale dove la policy ricavata dal modello Ontologico viene estratta e mostrata
		Ppm ppm = null;
		if (StringUtils.isEmpty(ppmFromRequest)) {
			List<Ppm> ppms = jpaPpmRepository.getAll();
			ppm = ppms.get(0);
		} else ppm = jpaPpmRepository.getById(ppmFromRequest);
		return OntoManager.createModelFromOntology(ppm.getModel	());
	}


	public void acceptPpa(String pid, String sid){

		//TODO
		// Questa è la parte centrale della gestione della Policy
		// è la parte post accettazione della Policy dove uno prendi i dati e fa tutto il giro
		// descritto 07C al punto 6
	}

}
