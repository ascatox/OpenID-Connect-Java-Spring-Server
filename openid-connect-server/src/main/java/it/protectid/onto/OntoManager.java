package it.protectid.onto;

import it.protectid.model.policy.PolicyModel;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.query.GraphQueryResult;
import org.eclipse.rdf4j.query.QueryResults;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFHandlerException;
import org.eclipse.rdf4j.rio.RDFParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ascatox
 * Reference https://rdf4j.eclipse.org/documentation/
 */

public class OntoManager {

	public static final String BASEURI = "http://www.protectid.it/ontologies/pd-onto#";
	public static final String W3CURI = "http://www.w3.org";
	private static final Logger logger = LoggerFactory.getLogger(OntoManager.class);

	public static PolicyModel createModelFromOntology(String model) throws Exception {
		return doCreateModelFromOntology(IOUtils.toInputStream(model));
	}

	public static PolicyModel createModelFromOntology(InputStream model) throws Exception {
		return doCreateModelFromOntology(model);
	}

	public static PolicyModel doCreateModelFromOntology(InputStream inputStream) throws Exception {
		//TODO
		// Questa parte va interamente rivista sulla base del nuovo modello sulla quale sta lavorando
		// Massimiliano qui va capito come estrare le informazioni dall'Ontologia servirà Sparql https://it.wikipedia.org/wiki/SPARQL ???
		try {
			PolicyModel policyModel = new PolicyModel();
			String baseURI = BASEURI;
			RDFFormat format = RDFFormat.RDFXML;
			try (GraphQueryResult res = QueryResults.parseGraphBackground(inputStream, baseURI, format)) {
				int i = 1;
				while (res.hasNext()) {
					Statement st = res.next();
					String predicate = removeURI(st.getPredicate().toString(), BASEURI);
					String subject = removeURI(st.getSubject().toString(), BASEURI);
					String object = removeURI(st.getObject().toString(), BASEURI);
					if (predicate.contains(W3CURI)) continue;
					logger.debug(i + ") Subject -> " + removeURI(st.getSubject().toString(), BASEURI) + "; Object -> " + removeURI(st.getObject().toString(), BASEURI) + "; Predicate -> " + removeURI(st.getPredicate().toString(), BASEURI));
					policyModel.getAttributes().add(
						new PolicyModel.Attribute(subject, predicate));
					i++;
				}
			}
			return policyModel;
		} catch (RDFParseException e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception(e);
		} catch (RDFHandlerException e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception(e);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception(e);
		} catch (Throwable e) {
			logger.error(e.getLocalizedMessage());
		} finally {
			inputStream.close();
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		InputStream targetStream = null;
		try {
			File onto = new File("/Users/ascatox/Documents/Sviluppo/workspace_oss/OpenID-Connect-Java-Spring-Server/openid-connect-server/src/main/java/it/protectid/model/onto/onto.owl");
			targetStream = FileUtils.openInputStream(onto);
			PolicyModel modelFromOnthology = createModelFromOntology(targetStream);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			targetStream.close();
		}
	}

	private static String removeURI(String iri, String baseURI) {
		return iri.replace(baseURI, "");
	}

}
