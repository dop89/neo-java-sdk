package com.github.dop89.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GetBlock {

    @JsonProperty("hash")
    private String hash;

    @JsonProperty("size")
    private Long size;

    @JsonProperty("version")
    private Long version;

    @JsonProperty("previousblockhash")
    private String previousBlockHash;

    @JsonProperty("merkleroot")
    private String merkleRoot;

    @JsonProperty("time")
    private Long time;

    @JsonProperty("index")
    private Long index;

    @JsonProperty("nonce")
    private String nonce;

    @JsonProperty("nextconsensus")
    private String nextConsensus;

    @JsonProperty("script")
    private Script script;

    @JsonProperty("tx")
    private List<Transaction> tx = new ArrayList<>();

    @JsonProperty("confirmations")
    private Long confirmations;

    @JsonProperty("nextblockhash")
    private String nextBlockHash;

}


