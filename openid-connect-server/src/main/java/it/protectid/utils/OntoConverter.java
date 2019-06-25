package it.protectid.utils;

import it.protectid.model.policy.PolicyModel;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.query.GraphQueryResult;
import org.eclipse.rdf4j.query.QueryResults;
import org.eclipse.rdf4j.rio.RDFFormat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OntoConverter {

	public static PolicyModel createModelFromOnthology(String model) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(model.getBytes());
		PolicyModel policyModel = new PolicyModel();
		String baseURI = "";
		RDFFormat format = RDFFormat.RDFXML;
		try (GraphQueryResult res = QueryResults.parseGraphBackground(inputStream, baseURI, format)) {
			while (res.hasNext()) {
				Statement st = res.next();
				// ... do something with the resulting statement here.
				// FIXME
				policyModel.getAttributes().add(new PolicyModel.Attribute(st.getPredicate().toString(), st.getObject().toString()));
			}
		}
		return policyModel;
	}

}
