package com.github.dop89.model;

import lombok.Getter;

@Getter
public enum Methods {

    GET_BALANCE("getbalance"),
    GET_BEST_BLOCK_HASH("getbestblockhash"),
    GET_BLOCK("getblock"),
    GET_BLOCK_COUNT("getblockcount"),
    GET_BLOCK_HASH("getblockhash"),
    GET_CONNECTION_COUNT("getconnectioncount"),
    GET_RAW_MEMPOOL("getrawmempool"),
    GET_RAW_TRANSACTION("getrawtransaction"),
    GET_TXOUT("gettxout");


    private String methodName;

    Methods(String methodName) {
        this.methodName = methodName;
    }

}
