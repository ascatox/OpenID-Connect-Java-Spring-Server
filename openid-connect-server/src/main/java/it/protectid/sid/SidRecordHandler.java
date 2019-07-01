package it.protectid.sid;

import it.protectid.crypto.GenerateKeys;
import it.protectid.dir.DIRService;
import it.protectid.model.authority.Pip;
import it.protectid.model.authority.Sid;
import it.protectid.utils.JsonConverter;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class SidRecordHandler {

	private GenerateKeys generateKeys;
	private DIRService dir;
	Sid sid = new Sid();

	public Sid generateRecord(Pip pip) {
		PrivateKey privateKey = generateKeys.getPrivateKey();
		PublicKey publicKey = generateKeys.getPublicKey();
		String SID = generateSID(publicKey);
		String SIG = generateSIG(privateKey);
		String pipId = pip.getId();
		sid.setId(SID);
		sid.setPip(pipId);
		sid.setCrtLevel(Sid.CERT_LEVEL_LOW); //FIXME
		sid.setSig(SIG);
		try {
			dir.invoke("insertSID", JsonConverter.objectToJson(sid)); //TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sid;
	}


	private String generateSID(PublicKey publicKey) {

		try {

			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] mdBytes = messageDigest.digest(publicKey.toString().getBytes());
			BigInteger bigInteger = new BigInteger(1, mdBytes);
			StringBuilder hashtextSID = new StringBuilder(bigInteger.toString(16));

			while (hashtextSID.length() < 32) {
				hashtextSID.insert(0, "0");
			}

			return hashtextSID.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}

	private String generateSIG(PrivateKey privateKey) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] mdBytes = messageDigest.digest(privateKey.toString().getBytes());
			BigInteger bigInteger = new BigInteger(1, mdBytes);
			StringBuilder hashtextSIG = new StringBuilder(bigInteger.toString(16));

			while (hashtextSIG.length() < 32) {
				hashtextSIG.insert(0, "0");
			}

			return hashtextSIG.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}


}
