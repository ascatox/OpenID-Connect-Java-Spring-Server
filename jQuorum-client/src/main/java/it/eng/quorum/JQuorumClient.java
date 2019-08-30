package it.eng.quorum;

import org.web3j.quorum.Node;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author clod16
 */
public interface JQuorumClient {

    String sendSync(String payload) throws IOException;
    String sendAsync(String payload) throws ExecutionException, InterruptedException;
    void sendPrivateTransaction(Node sourceNode, Node destNode, String requestId, String payload) throws Exception;

}
