package com.github.dop89.model;

import lombok.Getter;

@Getter
public enum Methods {

    GET_BALANCE("getbalance"),
    GET_BEST_BLOCK_HASH("getbestblockhash"),
    GET_BLOCK("getblock");


    private String methodName;

    Methods(String methodName) {
        this.methodName = methodName;
    }

}
