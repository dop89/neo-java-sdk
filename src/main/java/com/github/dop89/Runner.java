package com.github.dop89;

import com.github.dop89.client.NeoClient;
import com.github.dop89.exception.NeoApiException;
import com.github.dop89.model.GetBlock;
import com.github.dop89.model.Transaction;
import com.github.dop89.model.TxOut;
import com.github.dop89.model.jsonrpc.JsonRPCResponse;
import com.github.dop89.model.GetBalance;

public class Runner {

    public static void main (String[] args) {

        NeoClient client = new NeoClient();

        try {
            //JsonRPCResponse<GetBalance> balance = client.getBalance("c56f33fc6ecfcd0c225c4ab356fee59390af8560be0e930faebe74a6daff7c9b");
            JsonRPCResponse<String> bestBlockHash = client.getBestBlockHash();
            JsonRPCResponse<String> block = client.getBlock(10000L);
            JsonRPCResponse<GetBlock> blockVerbose = client.getBlockVerbose(10000L);
            JsonRPCResponse<Long> blockCount = client.getBlockCount();
            JsonRPCResponse<String> blockHash = client.getBlockHash(10000L);
            JsonRPCResponse<Long> connectionCount = client.getConnectionCount();
            JsonRPCResponse<String[]> rawMemPool = client.getRawMemPool();
            JsonRPCResponse<String> rawTransaction = client.getRawTransaction("966378afeecd245514b8cdfd9b8982fe3fffe8a0c1e0db62d85064c1c57101d0");
            JsonRPCResponse<Transaction> rawTransactionVerbose = client.getRawTransactionVerbose("966378afeecd245514b8cdfd9b8982fe3fffe8a0c1e0db62d85064c1c57101d0");
            JsonRPCResponse<TxOut> getTxOut = client.getTxOut("966378afeecd245514b8cdfd9b8982fe3fffe8a0c1e0db62d85064c1c57101d0", 0L);

            System.out.println("done");


        } catch (NeoApiException ex) {
            System.out.println(ex);
        }

    }
}
