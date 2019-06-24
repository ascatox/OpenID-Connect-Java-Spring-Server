package it.protectid.utils;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.impl.LinkedHashModel;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFParser;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.rio.helpers.StatementCollector;

public class OntoConverter {


	public static String createModelFromOnthology(String model){
		RDFParser rdfParser = Rio.createParser(RDFFormat.RDFXML);
		Model modelRdf = new LinkedHashModel();
		rdfParser.setRDFHandler(new StatementCollector(modelRdf));
		//rdfParser.parse();
		return null;
	}

}
