package com.github.dop89.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface JsonRPCMethod {

    /**
     * Returns the name of the JsonRPC method
     * @return the name of JsonRPC method
     */
    @JsonIgnore
    String getMethod();

}
