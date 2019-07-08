package it.protectid.dir;

import it.protectid.dir.model.ObjectRequest;
import it.protectid.model.authority.Sid;
import it.protectid.utils.JsonConverter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author clod16
 */
@Service
public class RestClientBC {
	//FIXME: insert correct URL for BC
	private static final String URL_SAWTOOTH_POST = "http://localhost:8080/sawtooth";
	private static final String URL_SAWTOOTH_GET = "http://localhost:8080/sawtooth/state";


	public enum Function {
		getPIP, insertPIP, deletePIP, getDP, insertDP, deleteDP, getSID, insertSID, deleteSID, getPPM, insertPPM, deletePPM, getPPA, insertPPA, deletePPA, getPDC, insertPDC, deletePDC
	}

	public String invoke(String fcn, String payloadJson, boolean isPost) {
		ObjectRequest req = new ObjectRequest(fcn, payloadJson);
		try {
			String regJSON = JsonConverter.objectToJson(req);

			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> requestBody = new HttpEntity<>(regJSON, httpHeaders);
			RestTemplate restTemplate = new RestTemplate();
			if (checkSign(payloadJson)) {
				if (isPost) {
					return restTemplate.postForObject(URL_SAWTOOTH_POST, requestBody, String.class);
				} else {
					//SEE @ascatox : nel documento non c'é traccia di alcuna get, mauro non le predisposte.
					// Dobbiamo pensare noi se in qualche passaggio magari servono, in caso negativo penso che HLS sia ok per solo post/update!
					return restTemplate.getForObject(URL_SAWTOOTH_GET, String.class);
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}


	private boolean checkSign(String payload) {

		try {
			Sid sid = (Sid) JsonConverter.jsonToObject(payload, Sid.class);
			if (sid.getId() != null && sid.getPip() != null) {
				//TODO see UC07B point 2.*
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
