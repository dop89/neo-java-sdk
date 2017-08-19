package com.github.dop89.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dop89.model.GetBalance;
import com.github.dop89.model.GetBlock;
import com.github.dop89.model.jsonrpc.JsonRPCRequest;
import com.github.dop89.model.jsonrpc.JsonRPCResponse;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import static com.github.dop89.model.Methods.*;

@SuppressWarnings("Duplicates")
public class NeoClient {

    private static final String URL = "http://test1.cityofzion.io:8880";

    private ObjectMapper mapper = new ObjectMapper();


    /**
     * Returns the balance of the corresponding asset in the wallet, based on the specified asset number.
     * Does not work at the moment
     *
     * @param assetId neo asset it
     * @return balance in neo and gas
     */
    public JsonRPCResponse<GetBalance> getBalance(String assetId) {

        try {

            JsonRPCRequest getBalanceRequest = new JsonRPCRequest<String>(GET_BALANCE);
            getBalanceRequest.setParams(Collections.singletonList(assetId));
            Content content = doPostRequest(getBalanceRequest);

            return mapper.readValue(content.asString(), new TypeReference<JsonRPCResponse<GetBalance>>() {
            });

        } catch (IOException ex) {
            System.out.println("Could not get Balance for " + assetId);
        }

        return null;
    }


    /**
     * Returns the hash of the tallest block in the main chain.
     *
     * @return The hash of the tallest block in the main chain.
     */
    public JsonRPCResponse<String> getBestBlockHash() {

        try {

            JsonRPCRequest getBestBlockHash = new JsonRPCRequest<String>(GET_BEST_BLOCK_HASH);
            Content content = doPostRequest(getBestBlockHash);

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
     * @param blockId the id of the block
     * @return hex string
     */
    public JsonRPCResponse<String> getBlock(Long blockId) {

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
     * @param blockId the id of the block
     * @return hex string
     */
    public JsonRPCResponse<GetBlock> getBlockVerbose(Long blockId) {

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
     * @return
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
     * @param blockId
     * @return
     */
    public JsonRPCResponse<String> getBlockHash(Long blockId) {

        try {

            JsonRPCRequest getBlockHash = new JsonRPCRequest<Long>(GET_BEST_BLOCK_HASH);
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
     * @return
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
     * @return
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
     * @param transactionId
     * @return
     */
    public JsonRPCResponse<String> getRawTransaction(String transactionId) {

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

    private Content doPostRequest(JsonRPCRequest request) throws IOException {
        return Request.Post(URL)
                .bodyString(request.toJsonString(), ContentType.APPLICATION_JSON)
                .execute().returnContent();
    }

}
