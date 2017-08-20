package com.github.dop89.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TxOut {

    @JsonProperty("n")
    private Long n;

    @JsonProperty("asset")
    private String asset;

    @JsonProperty("value")
    private String value;

    @JsonProperty("address")
    private String address;

}
