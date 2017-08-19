package com.github.dop89.model.jsonrpc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
// TODO better typing here (T extends JsonRPCMethod) ...
public class JsonRPCResponse<T> {


    @JsonProperty("jsonrpc")
    private String jsonRPC = "2.0";

    @JsonProperty("id")
    private int id;

    @JsonProperty("result")
    private T result;

}
