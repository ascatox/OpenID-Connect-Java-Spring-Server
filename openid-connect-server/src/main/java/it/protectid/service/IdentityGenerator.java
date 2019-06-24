package it.protectid.service;

import it.protectid.crypto.AsymmetricCryptography;
import it.protectid.crypto.GenerateKeys;
import it.protectid.model.authority.Sid;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;

/**
 * @author ascatox
 */
@Service
public class IdentityGenerator {

	public String generateSID(String addrPip) throws NoSuchProviderException,
		NoSuchAlgorithmException,
		NoSuchPaddingException,
		InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
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
		Sid sid = new Sid(addrSid, addrPip);
		AsymmetricCryptography ac = new AsymmetricCryptography();
		final String encryptedSid = ac.encryptText(sid.toString(), sk);
		return encryptedSid;
	}
}
