package it.protectid.pdw;

import it.eng.protectid.model.authority.Sid;
import it.eng.protectid.model.policy.Ppa;
import it.eng.protectid.model.pdw.Pdw;
import it.protectid.pdw.repository.JpaPdwRepository;
import it.protectid.repository.JpaPipRepository;
import it.protectid.repository.JpaSidRepository;
import it.protectid.service.SidRecordService;
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
	private SidRecordService sidRecordService;

	@Autowired
	private JpaPipRepository jpaPipRepository;

	@Autowired
	private JpaSidRepository jpaSidRepository;

	@Autowired
	private JpaPdwRepository jpaPdwRepository;


	public MyPdwManager() {
	}

	//private Pip defaultPip = jpaPipRepository.getById("1"); //TODO

	public Pdw create(String pid, String addrDp, String addrSid, String sk, String pk, String ppa) throws Exception {
		Pdw pdw = new Pdw(pid, addrSid, pk, sk, addrDp, ppa);
		jpaPdwRepository.create(pdw);
		return pdw;
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
