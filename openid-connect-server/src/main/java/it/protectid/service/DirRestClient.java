package it.protectid.service;

import it.protectid.crypto.AsymmetricCryptography;
import it.protectid.crypto.GenerateKeys;
import it.protectid.model.dir.ObjectRequestDir;
import it.protectid.model.authority.Sid;
import it.protectid.utils.JsonConverter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.PublicKey;

/**
 * @author clod16
 */
@Service
public class DirRestClient {
	//FIXME: insert correct URL for BC
	private static final String URL_SAWTOOTH_POST = "http://localhost:8080/sawtooth";
	private static final String URL_SAWTOOTH_GET = "http://localhost:8080/sawtooth/state";

	AsymmetricCryptography asymmetricCryptography;

	public enum Function {
		getPIP, insertPIP, deletePIP, getDP, insertDP, deleteDP, getSID, insertSID, deleteSID, getPPM, insertPPM, deletePPM, getPPA, insertPPA, deletePPA, getPDC, insertPDC, deletePDC
	}

	public String invoke(String fcn, String payloadJson, boolean isPost) {
		try {
			Sid sid = (Sid) JsonConverter.jsonToObject(payloadJson, Sid.class);
			if (checkSign(sid)) {
				sid.setSig(""); // dopo i controlli sulla SIG, viene azzerata per inserirla sul registro pubblico
				String sidJson = JsonConverter.objectToJson(sid);
				ObjectRequestDir req = new ObjectRequestDir(fcn, sidJson);
				String reqDirJSON = JsonConverter.objectToJson(req);
				HttpHeaders httpHeaders = new HttpHeaders();
				httpHeaders.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<String> requestBody = new HttpEntity<>(reqDirJSON, httpHeaders);
				RestTemplate restTemplate = new RestTemplate();
				if (isPost) {
					return restTemplate.postForObject(URL_SAWTOOTH_POST, requestBody, String.class);
				} else {
					//SEE @ascatox : nel documento non c'é traccia di alcuna get, mauro non le predisposte.
					// Dobbiamo pensare noi se in qualche passaggio magari servono, in caso negativo penso che HLS sia ok per le sole post/update!
					return restTemplate.getForObject(URL_SAWTOOTH_GET, String.class);
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

	private boolean checkSign(Sid sid) {
		try {
			if (sid.getId() != null && sid.getPip() != null) {
				AsymmetricCryptography ac = new AsymmetricCryptography();
				GenerateKeys generateKeys = new GenerateKeys(1024);
				if (sid.getPip() != null) {
					final PublicKey pk = generateKeys.getPublicKey();
				}
				//FIXME: dove trovo le chiavi pubbliche/private per controllare le firme della SID???
				//TODO see UC07B point 2.*
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
