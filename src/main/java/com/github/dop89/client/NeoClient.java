package com.github.dop89.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dop89.model.GetBlock;
import com.github.dop89.model.jsonrpc.JsonRPCRequest;
import com.github.dop89.model.jsonrpc.JsonRPCResponse;
import com.github.dop89.model.GetBalance;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;

import static com.github.dop89.model.Methods.GET_BALANCE;
import static com.github.dop89.model.Methods.GET_BEST_BLOCK_HASH;
import static com.github.dop89.model.Methods.GET_BLOCK;

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
            String[] params = {assetId};

            getBalanceRequest.setParams(params);

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

            // set empty parameter list
            getBestBlockHash.setParams(new String[0]);

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

            Long[] params = {blockId};
            getBlock.setParams(params);

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

            Long[] params = {blockId, 1L};
            getBlock.setParams(params);

            Content content = doPostRequest(getBlock);

            return mapper.readValue(content.asString(), new TypeReference<JsonRPCResponse<GetBlock>>() {
            });

        } catch (IOException ex) {
            System.out.println("Could not get Block for " + blockId);
        }


        return null;
    }

    private Content doPostRequest(JsonRPCRequest request) throws IOException {
        return Request.Post(URL)
                .bodyString(request.toJsonString(), ContentType.APPLICATION_JSON)
                .execute().returnContent();
    }

}
