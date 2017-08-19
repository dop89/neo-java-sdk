package com.github.dop89.model.jsonrpc;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dop89.model.Methods;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonRPCRequest<T> {

    @JsonProperty("jsonrpc")
    private String jsonRPC = "2.0";

    @JsonProperty("id")
    private int id = 1;

    @JsonProperty("method")
    private String method;

    @JsonProperty("params")
    private T [] params;


    public JsonRPCRequest(Methods method) {
        this.method = method.getMethodName();
    }


    @JsonIgnore
    public String toJsonString() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

}
