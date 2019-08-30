package it.eng.quorum;

import org.web3j.quorum.Node;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author clod16
 */
public interface Quorum {

	public String entryPointQuorum(String payload, String sig);

}
