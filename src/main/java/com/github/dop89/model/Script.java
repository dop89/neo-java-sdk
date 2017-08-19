package com.github.dop89.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Script {

    @JsonProperty("invocation")
    private String invocation;

    @JsonProperty("verification")
    private String verification;

}
