package com.github.dop89.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonRPCResponse<T extends JsonRPCMethod> {


    @JsonProperty("jsonrpc")
    private String jsonRPC = "2.0";

    @JsonProperty("id")
    private int id;

    @JsonProperty("result")
    private T method;

}
