package it.protectid.pdw;

import it.protectid.model.authority.Sid;
import it.protectid.model.policy.Ppa;
import it.protectid.repository.JpaSidRepository;
import org.mitre.openid.connect.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class implements the access to the myPersonalDatWallet.
 *
 * @author ascatox
 */
@Service
public class MyPdwManager {

	@Autowired
	JpaSidRepository jpaSidRepository;

	public Sid create(Sid sid) throws Exception {
		return jpaSidRepository.create(sid);
	}
	public void deleteSid(Sid sid) throws Exception {
		jpaSidRepository.delete(sid);
	}
	public List<Sid> getAll(UserInfo userInfo) throws Exception {
		return jpaSidRepository.getAll();
	}

	public Sid getSidById(String id) {
		return null;
	}

	public List<Sid> getSidByDp(String dp) {
		return null;
	}

	public List<Sid> getSidByPpa(String ppa) {
		return null;
	}

	public Ppa createPpa(Ppa ppa) {
		return null;
	}

	public String deletePpa(String idPpa) {
		return null;
	}

	public Ppa getPpaById(String idPpa) {
		return null;
	}

}
