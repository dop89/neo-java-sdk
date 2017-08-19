package com.github.dop89.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetBalance implements JsonRPCMethod {

    @JsonProperty("Balance")
    private String balance;

    @JsonProperty("Gas")
    private String gas;

    @Override
    public String getMethod() {
        return "getbalance";
    }
}
