package it.eng.jquorum;

import it.eng.jquorum.wrapper.contract.Greeter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.quorum.Node;
import org.web3j.quorum.Quorum;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class jQuorum {

    private static final Logger log = LoggerFactory.getLogger(jQuorum.class);

    private static final BigInteger GAS_PRICE = DefaultGasProvider.GAS_PRICE;
    private static final BigInteger GAS_LIMIT = DefaultGasProvider.GAS_LIMIT;

    public String sendSync(String payload) throws IOException {
        Quorum quorum = Quorum.build(new HttpService("http://localhost:22001"));
        Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
        return web3ClientVersion.getWeb3ClientVersion();
    }


    public String sendAsync(String payload) throws ExecutionException, InterruptedException {
        Quorum quorum = Quorum.build(new HttpService("http://localhost:22001"));
        Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().sendAsync().get();
        return web3ClientVersion.getWeb3ClientVersion();
    }

    public static void sendPrivateTransaction(Node sourceNode, Node destNode, String requestId, String payload) throws Throwable {

        log.info("Preparation of calls to Quorum network...");

        Quorum quorum = Quorum.build(new HttpService(sourceNode.getUrl()));
        final EthAccounts ethAccounts = quorum.ethAccounts().send();
        final String ethFirstAccount = ethAccounts.getAccounts().get(0);
        final List<String> privateFor = sourceNode.getPublicKeys();

        EngClientTransactionManager transactionManager =
                new EngClientTransactionManager(
                        quorum,
                        ethFirstAccount, ethFirstAccount, privateFor);
        ContractGasProvider contractGasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);
        //Greeter.deploy(jquorum, transactionManager, contractGasProvider, "Ciao Prof. Conte").send();
        final Greeter greeter = Greeter.load("0xaa0b763cd8899196f9efce1e7b77b63c5671fbd8", quorum, transactionManager, contractGasProvider);
        final RemoteCall<String> greet = greeter.greet();
        String message = greet.send();
        System.out.println("Greeter: " + message);

        // final RemoteFunctionCall<TransactionReceipt> transactionReceiptRemoteFunctionCall = contract.create(payload);
        // log.info("Remote call received... " + transactionReceiptRemoteFunctionCall.toString());
    }

    public static void main(String[] args) {
        Node sourceNode = new Node("enode://aebba9c44ac82778d941b4ee05c8e9e2e22038c1433dcc8beb740095168ac96f1f00bb7c30efbb8f2e382e3b0013c39eda630495f9a5db49b2b19b7a34351386@127.0.0.1:22000",
                Arrays.asList("TBV2LgoE9CKTSoSZEI0mTQ6dzvykJaVwH745qouMXgs="), "http://127.0.0.1:22000");
        try {
            sendPrivateTransaction(sourceNode, sourceNode, null, "Ciao Giuseppi");
        } catch (Throwable e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
