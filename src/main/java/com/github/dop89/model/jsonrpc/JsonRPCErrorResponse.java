package com.github.dop89.model.jsonrpc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dop89.model.Error;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonRPCErrorResponse {

    @JsonProperty("jsonrpc")
    private String jsonRPC = "2.0";

    @JsonProperty("id")
    private int id;

    @JsonProperty("error")
    private Error error;

}
