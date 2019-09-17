package it.protectid.onto;

import com.google.gson.Gson;
import it.protectid.model.policy.PolicyModel;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PolicyModelReader {

	public static PolicyModel readModel(String model) {
		return doReadModel(model);
	}

	public static PolicyModel sortFieldsByFinalityAndMandatory(PolicyModel policyModel) {
		List<PolicyModel.Attribute> personalDataFiltered = policyModel.getPersonalData().stream()
			.sorted(Comparator.comparing(PolicyModel.Attribute::getMandatory))
			.sorted(Comparator.comparing(PolicyModel.Attribute::getFinality))
			.collect(Collectors.toList());
		return new PolicyModel(personalDataFiltered);
	}

	private static PolicyModel doReadModel(String model) {
		Gson gson = new Gson();
		return gson.fromJson(model, PolicyModel.class);
	}


	public static void main(String[] args) throws IOException {
		InputStream fileInputStream = null;
		try {
			File json = new File("/Users/ascatox/Documents/Sviluppo/workspace_oss/OpenID-Connect-Java-Spring-Server/openid-connect-server/src/main/java/it/protectid/onto/ppm.json");
			fileInputStream = fileInputStream = FileUtils.openInputStream(json);
			String theString = IOUtils.toString(fileInputStream, "UTF-8");
			readModel(theString);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fileInputStream.close();
		}
	}

}
