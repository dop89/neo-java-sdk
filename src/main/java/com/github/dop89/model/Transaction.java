package com.github.dop89.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Transaction {

    @JsonProperty("txid")
    private String txId;

    @JsonProperty("size")
    private Long size;

    @JsonProperty("type")
    private String type;

    @JsonProperty("version")
    private Long version;

    @JsonProperty("attributes")
    private List<Object> attributes = new ArrayList<>();

    @JsonProperty("vin")
    private List<Object> vin = new ArrayList<>();

    @JsonProperty("vout")
    private List<Object> vout = new ArrayList<>();

    @JsonProperty("sys_fee")
    private String sysFee;

    @JsonProperty("net_fee")
    private String netFee;

    @JsonProperty("scripts")
    private List<Object> scripts = new ArrayList<>();

    @JsonProperty("nonce")
    private Long nonce;

    @JsonProperty("blockhash")
    private String blockHash;

    @JsonProperty("confirmations")
    private Long confirmations;

    @JsonProperty("blocktime")
    private Long blockTime;
}