package it.protectid.service;

import it.eng.protectid.model.authority.Pip;
import it.eng.protectid.model.authority.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SidRecordService {
	@Autowired
	private IdentityGenerator identityGenerator;
	private static final Logger logger = LoggerFactory.getLogger(SidRecordService.class);

	public Sid generateRecord(Pip pip) throws Exception {
		return identityGenerator.generateSID(pip.getId(), "", ""); //FIXME
	}


}
