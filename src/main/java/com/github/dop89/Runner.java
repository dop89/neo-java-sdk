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
        JsonRPCResponse<Long> blockCount = client.getBlockCount();
        JsonRPCResponse<String> blockHash = client.getBlockHash(10000L);
        JsonRPCResponse<Long> connectionCount = client.getConnectionCount();
        JsonRPCResponse<String[]> rawMemPool = client.getRawMemPool();
        JsonRPCResponse<String> rawTransaction = client.getRawTransaction("f4250dab094c38d8265acc15c366dc508d2e14bf5699e12d9df26577ed74d657");

        System.out.println("done");
    }
}
