package com.github.dop89.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonRPCRequest {

    @JsonIgnore
    private JsonRPCMethod method;

    @JsonProperty("jsonrpc")
    private String jsonRPC = "2.0";

    @JsonProperty("params")
    private String [] params;

    @JsonProperty("id")
    private int id = 1;


    public JsonRPCRequest(JsonRPCMethod method) {
        this.method = method;
    }


    @JsonProperty("method")
    public String getMethod() {
        return method.getMethod();
    }

    @JsonIgnore
    public String toJsonString() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

}
