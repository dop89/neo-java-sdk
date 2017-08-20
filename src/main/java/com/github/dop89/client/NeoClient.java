package com.github.dop89.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dop89.exception.NeoApiException;
import com.github.dop89.model.GetBalance;
import com.github.dop89.model.GetBlock;
import com.github.dop89.model.Transaction;
import com.github.dop89.model.TxOut;
import com.github.dop89.model.jsonrpc.JsonRPCErrorResponse;
import com.github.dop89.model.jsonrpc.JsonRPCRequest;
import com.github.dop89.model.jsonrpc.JsonRPCResponse;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static com.github.dop89.model.Methods.*;

@SuppressWarnings("Duplicates")
public class NeoClient {

    private static final String URL = "http://seed1.neo.org:20332";

    private ObjectMapper mapper = new ObjectMapper();


    /**
     * Returns the hash of the tallest block in the main chain.
     *
     * @return The hash of the tallest block in the main chain.
     */
    public JsonRPCResponse<String> getBestBlockHash() {

        JsonRPCRequest getBestBlockHash = new JsonRPCRequest<String>(GET_BEST_BLOCK_HASH);
        Content content;

        try {
            content = doPostRequest(getBestBlockHash);
            return mapper.readValue(content.asString(), new TypeReference<JsonRPCResponse<String>>() {
            });

        } catch (IOException ex) {
            System.out.println("Could not get best block");
        }

        return null;
    }

    /**
     * Returns the corresponding block information according to the specified index.
     * The serialized information of the block is returned, represented by a hexadecimal string
     *
     * @param blockId the id of the block
     * @return hex string or null if given blockId is invalid
     */
    public JsonRPCResponse<String> getBlock(Long blockId) {

        Objects.requireNonNull(blockId);

        try {

            JsonRPCRequest getBlock = new JsonRPCRequest<Long>(GET_BLOCK);
            getBlock.setParams(Collections.singletonList(blockId));
            Content content = doPostRequest(getBlock);

            return mapper.readValue(content.asString(), new TypeReference<JsonRPCResponse<String>>() {
            });

        } catch (IOException ex) {
            System.out.println("Could not get Block for " + blockId);
        }

        return null;
    }

    /**
     * Returns the corresponding block information according to the specified index.
     * Detailed information of the corresponding block in Json format string, is returned.
     *
     * @param blockId the id of the block
     * @return block object or null if given blockId is invalid
     */
    public JsonRPCResponse<GetBlock> getBlockVerbose(Long blockId) {

        Objects.requireNonNull(blockId);

        try {

            JsonRPCRequest getBlock = new JsonRPCRequest<Long>(GET_BLOCK);
            getBlock.setParams(Arrays.asList(blockId, 1L));

            Content content = doPostRequest(getBlock);
            return mapper.readValue(content.asString(), new TypeReference<JsonRPCResponse<GetBlock>>() {
            });

        } catch (IOException ex) {
            System.out.println("Could not get Block for " + blockId);
        }

        return null;
    }

    /**
     * Gets the number of blocks in the main chain
     *
     * @return the current block count
     */
    public JsonRPCResponse<Long> getBlockCount() {

        try {

            JsonRPCRequest getBlockCount = new JsonRPCRequest<String>(GET_BLOCK_COUNT);


            Content content = doPostRequest(getBlockCount);
            return mapper.readValue(content.asString(), new TypeReference<JsonRPCResponse<Long>>() {
            });

        } catch (IOException ex) {
            System.out.println("Could not get block count");
        }

        return null;
    }

    /**
     * Returns the hash value of the corresponding block, based on the specified index
     *
     * @param blockId the blockId for which the blockhash should be retrieved
     * @return blockhash or null if block with given id does not exist
     */
    public JsonRPCResponse<String> getBlockHash(Long blockId) {

        Objects.requireNonNull(blockId);

        try {

            JsonRPCRequest getBlockHash = new JsonRPCRequest<Long>(GET_BLOCK_HASH);
            getBlockHash.setParams(Collections.singletonList(blockId));

            Content content = doPostRequest(getBlockHash);
            return mapper.readValue(content.asString(), new TypeReference<JsonRPCResponse<String>>() {
            });

        } catch (IOException ex) {
            System.out.println("Could not get block hash for block " + blockId);
        }

        return null;
    }

    /**
     * Gets the current number of connections for the node
     *
     * @return number of connections for the node
     */
    public JsonRPCResponse<Long> getConnectionCount() {

        try {

            JsonRPCRequest getConnectionCount = new JsonRPCRequest<String>(GET_CONNECTION_COUNT);

            Content content = doPostRequest(getConnectionCount);
            return mapper.readValue(content.asString(), new TypeReference<JsonRPCResponse<Long>>() {
            });

        } catch (IOException ex) {
            System.out.println("Could not get connection count");
        }

        return null;
    }

    /**
     * Obtain the list of unconfirmed transactions in memory
     *
     * @return list of unconfirmed transaction in memory
     */
    public JsonRPCResponse<String[]> getRawMemPool() {

        try {

            JsonRPCRequest getRawMemPool = new JsonRPCRequest<String>(GET_RAW_MEMPOOL);

            Content content = doPostRequest(getRawMemPool);
            return mapper.readValue(content.asString(), new TypeReference<JsonRPCResponse<String[]>>() {
            });

        } catch (IOException ex) {
            System.out.println("Could not get unconfirmed transactions");
        }

        return null;
    }

    /**
     * Returns the corresponding transaction information, based on the specified hash value
     *
     * @param transactionId the transaction id
     * @return information about the transaction or null if transaction id is invalid
     */
    public JsonRPCResponse<String> getRawTransaction(String transactionId) {

        Objects.requireNonNull(transactionId);

        try {

            JsonRPCRequest getRawTransaction = new JsonRPCRequest<>(GET_RAW_TRANSACTION);
            getRawTransaction.setParams(Arrays.asList(transactionId, 0L));


            Content content = doPostRequest(getRawTransaction);
            return mapper.readValue(content.asString(), new TypeReference<JsonRPCResponse<String>>() {
            });

        } catch (IOException ex) {
            System.out.println("Could not get raw transaction " + transactionId);
        }

        return null;
    }

    /**
     * Returns the corresponding transaction information, based on the specified hash value
     *
     * @param transactionId the transaction id
     * @return a transaction object or null if transaction id is invalid
     */
    public JsonRPCResponse<Transaction> getRawTransactionVerbose(String transactionId) {

        Objects.requireNonNull(transactionId);

        try {

            JsonRPCRequest getRawTransaction = new JsonRPCRequest<>(GET_RAW_TRANSACTION);
            getRawTransaction.setParams(Arrays.asList(transactionId, 1L));

            Content content = doPostRequest(getRawTransaction);
            return mapper.readValue(content.asString(), new TypeReference<JsonRPCResponse<Transaction>>() {
            });

        } catch (IOException ex) {
            System.out.println("Could not get raw transaction " + transactionId);
        }

        return null;
    }

    /**
     * Returns the corresponding transaction output information (returned change), based on the specified hash and index
     * @param transactionId the transaction id
     * @param n index of the transaction output to be obtained in the transaction (starts from 0)
     *
     * @return TxOut object or null if any given parameter is invalid
     */
    public JsonRPCResponse<TxOut> getTxOut (String transactionId, Long n) {

        Objects.requireNonNull(transactionId);
        Objects.requireNonNull(n);

        try {

            JsonRPCRequest getRawTransaction = new JsonRPCRequest<>(GET_TXOUT);
            getRawTransaction.setParams(Arrays.asList(transactionId, n));

            Content content = doPostRequest(getRawTransaction);
            return mapper.readValue(content.asString(), new TypeReference<JsonRPCResponse<Transaction>>() {
            });

        } catch (IOException ex) {
            System.out.println("Could not get tx out for block " + transactionId);
        }

        return null;
    }

    public void sendRawTransaction() {
        throw new RuntimeException("Method not implemented yet");
    }

    public void sendToAddress() {
        throw new RuntimeException("Method not implemented yet");
    }

    /**
     * Returns the balance of the corresponding asset in the wallet, based on the specified asset number.
     * Does not work at the moment
     *
     * @param assetId neo asset it
     * @return balance in neo and gas
     */
    public JsonRPCResponse<GetBalance> getBalance(String assetId) {

        throw new RuntimeException("Method not implemented yet");

//        Content content = null;
//
//        JsonRPCRequest getBalanceRequest = new JsonRPCRequest<String>(GET_BALANCE);
//        getBalanceRequest.setParams(Collections.singletonList(assetId));
//
//        try {
//            content = doPostRequest(getBalanceRequest);
//            return mapper.readValue(content.asString(), new TypeReference<JsonRPCResponse<GetBalance>>() {
//            });
//
//        }catch (JsonProcessingException e) {
//            System.out.println("Could not get Balance for " + assetId);
//            throwException(content);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//        return null;
    }

    private Content doPostRequest(JsonRPCRequest request) throws IOException {
        return Request.Post(URL)
                .bodyString(request.toJsonString(), ContentType.APPLICATION_JSON)
                .execute().returnContent();
    }

    private void throwException(Content content) {
        try {

          JsonRPCErrorResponse error = mapper.readValue(content.asString(), JsonRPCErrorResponse.class);

          throw new NeoApiException(error.getError());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
