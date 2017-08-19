package com.github.dop89.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetBalance {

    @JsonProperty("balance")
    private String balance;

    @JsonProperty("gas")
    private String gas;

}
