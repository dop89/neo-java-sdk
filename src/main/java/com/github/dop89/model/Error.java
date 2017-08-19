package com.github.dop89.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Error {

    @JsonProperty("code")
    private Long code;
    @JsonProperty("message")
    private String message;

}
