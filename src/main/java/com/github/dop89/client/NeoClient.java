package com.github.dop89.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dop89.model.GetBalance;
import com.github.dop89.model.JsonRPCRequest;
import com.github.dop89.model.JsonRPCResponse;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;

public class NeoClient {

    private static final String URL = "http://test1.cityofzion.io:8880";

    private ObjectMapper mapper = new ObjectMapper();


    public JsonRPCResponse<GetBalance> getBalance(String assetId) {

        try {

            JsonRPCRequest getBalanceRequest = new JsonRPCRequest(new GetBalance());
            String[] params = {assetId};

            getBalanceRequest.setParams(params);

            Content content =  Request.Post(URL)
                    .bodyString(getBalanceRequest.toJsonString(), ContentType.APPLICATION_JSON)
                    .execute().returnContent();

            return mapper.readValue(content.asString(), new TypeReference<JsonRPCResponse<GetBalance>>() {});

        } catch (IOException ex) {
            System.out.println("Could not get Balance for " + assetId);
        }

        return null;
    }

}
