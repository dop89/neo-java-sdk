package com.github.dop89;

import com.github.dop89.client.NeoClient;
import com.github.dop89.model.GetBlock;
import com.github.dop89.model.jsonrpc.JsonRPCResponse;
import com.github.dop89.model.GetBalance;

public class Runner {

    public static void main (String[] args) {

        NeoClient client = new NeoClient();

        JsonRPCResponse<GetBalance> balance = client.getBalance("c56f33fc6ecfcd0c225c4ab356fee59390af8560be0e930faebe74a6daff7c9b");
        JsonRPCResponse<String> bestBlockHash = client.getBestBlockHash();
        JsonRPCResponse<String> block = client.getBlock(10000L);
        JsonRPCResponse<GetBlock> blockVerbose = client.getBlockVerbose(10000L);

        System.out.println("done");
    }
}
