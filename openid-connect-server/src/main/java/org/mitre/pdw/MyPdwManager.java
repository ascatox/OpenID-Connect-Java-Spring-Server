package org.mitre.pdw;

import org.mitre.openid.connect.model.UserInfo;
import org.mitre.protectid.model.authority.Sid;
import org.mitre.protectid.model.policy.Ppa;
import org.mitre.protectid.service.IdentityGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class implements the access to the myPersonalDatWallet.
 * @author ascatox
 */
@Service
public class MyPdwManager {
	@Autowired

	IdentityGenerator identityGenerator;

	public Sid create(Sid sid){
		return null;
	}


	public String deleteSid(Sid sid){
		return null;
	}


	public List<Sid> getAll(UserInfo userInfo){
		return null;
	}


	public Sid getSidById(String id){
		return null;
	}

	public List<Sid> getSidByDp(String dp){
		return null;
	}

	public List<Sid> getSidByPpa(String ppa){
		return null;
	}

	public Ppa createPpa(Ppa ppa){
		return null;
	}

	public String deletePpa(String idPpa){
		return null;
	}

	public Ppa getPpaById(String idPpa){
		return null;
	}

}
