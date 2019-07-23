package it.protectid.service;

import it.protectid.crypto.AsymmetricCryptography;
import it.protectid.crypto.GenerateKeys;
import it.protectid.model.authority.Sid;
import it.protectid.pdw.MyPdwManager;
import it.protectid.repository.JpaSidRepository;
import it.protectid.utils.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author ascatox
 */
@Service
public class IdentityGenerator {
	@Autowired
	private DirRestClient dirRestClient;
	@Autowired
	private JpaSidRepository jpaSidRepository;
	@Autowired
	private MyPdwManager myPdwManager;

	public Sid generateSID(String pid, String addrPip, String addrDp) throws Exception {
		/**
		 *
		 * 1.1. Genera una coppia asimmetrica di chiavi crittografiche: chiave pubblica (PK) e chiave privata (SK).
		 *
		 **/
		GenerateKeys gk = new GenerateKeys(1024);
		gk.createKeys();
		final PrivateKey sk = gk.getPrivateKey();
		final PublicKey pk = gk.getPublicKey();
		/**
		 * 1.2. Deriva da PK una stringa alfanumerica che rappresenti l’indirizzo pubblico della SID, applicando un algoritmo di hashing.
		 */
		final String addrSid = gk.hashKey(pk.getEncoded());
		Sid sid = new Sid();
		sid.setPip(addrPip);
		AsymmetricCryptography ac = new AsymmetricCryptography();
		final String sig = ac.encryptText(sid.toString(), sk);
		final String address = ac.encryptText(sid.toString(), pk);
		sid.setSig(sig);
		sid.setAddr(address);
		sid.setCrtLevel(Sid.CERT_LEVEL_LOW); //TODO
		dirRestClient.invoke(DirRestClient.Function.insertSID.name(), JsonConverter.objectToJson(sid), true);
		jpaSidRepository.create(sid);
		myPdwManager.create(pid, addrDp, address, sk.toString(), pk.toString(), null);
		return sid;
	}
}
