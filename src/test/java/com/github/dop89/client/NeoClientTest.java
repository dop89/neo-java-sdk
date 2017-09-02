package com.github.dop89.client;

import com.github.dop89.model.GetBlock;
import com.github.dop89.model.Transaction;
import com.github.dop89.model.TxOut;
import com.github.dop89.model.jsonrpc.JsonRPCResponse;
import org.junit.Test;

import static org.junit.Assert.*;

public class NeoClientTest {

    private static final String NEO_URL = "http://test1.cityofzion.io:8880";
    private static final String VALID_TRANSACTION_ID = "2293aee1ba10bf1efeff20b41cb9e6c4cdc75201804d65853d119d34464f8602";
    private static final String VALID_TRANSACTION_ID_2 = "8aaf766179c07941f24a08157d7e6796e6d4aa999d3eaf83e74024c28d081af0";
    private static final String INVALID_TRANSACTION_ID = "anInvalidTransactionId";
    private static final Long VALID_BLOCK_ID = 10000L;
    private static final Long INVALID_BLOCK_ID = -10000L;
    private static final Long VALID_N = 0L;
    private static final Long INVALID_N = -42L;

    private final NeoClient neoClient = new NeoClient(NEO_URL);

    @Test(expected = NullPointerException.class)
    public void constructNeoClient_urlIsNull() {
        new NeoClient(null);
    }

    @Test
    public void getBestBlockHash_success() {
        JsonRPCResponse<String> response = neoClient.getBestBlockHash();

        assertNotNull(response);
        assertNotNull(response.getResult());
    }

    @Test
    public void getBlock_success() {
        JsonRPCResponse<String> block = neoClient.getBlockByIndex(VALID_BLOCK_ID);

        assertNotNull(block);
        assertNotNull(block.getResult());
    }

    @Test
    public void getBlock_invalidBlockId() {
        JsonRPCResponse<String> block = neoClient.getBlockByIndex(INVALID_BLOCK_ID);
        assertNull(block);
    }

    @Test(expected = NullPointerException.class)
    public void getBlock_blockIdIsNull() throws Exception {
        neoClient.getBlockByIndex(null);
    }

    @Test
    public void getBlockVerbose_success() throws Exception {
        JsonRPCResponse<GetBlock> block = neoClient.getBlockByIndexVerbose(VALID_BLOCK_ID);

        GetBlock theBlock = block.getResult();

        assertNotNull(block);
        assertNotNull(theBlock);
        assertEquals(VALID_BLOCK_ID, theBlock.getIndex());
    }

    @Test
    public void getBlockVerbose_invalidBlockId() throws Exception {
        JsonRPCResponse<GetBlock> block = neoClient.getBlockByIndexVerbose(INVALID_BLOCK_ID);

        assertNull(block);
    }

    @Test(expected = NullPointerException.class)
    public void getBlockVerbose_blockIdIsNull() throws Exception {
        neoClient.getBlockByIndexVerbose(null);
    }


    @Test
    public void getBlockCount_success() {
        JsonRPCResponse<Long> blockCount = neoClient.getBlockCount();

        assertNotNull(blockCount);
        assertNotNull(blockCount.getResult());
    }

    @Test
    public void getBlockHash_success() {
        JsonRPCResponse<String> blockHash = neoClient.getBlockHash(VALID_BLOCK_ID);

        assertNotNull(blockHash);
        assertNotNull(blockHash.getResult());
    }

    @Test
    public void getBlockHash_invalidBlockId() {
        JsonRPCResponse<String> blockHash = neoClient.getBlockHash(INVALID_BLOCK_ID);

        assertNull(blockHash);
    }

    @Test(expected = NullPointerException.class)
    public void getBlockHash_blockIdIsNull() throws Exception {
        neoClient.getBlockHash(null);
    }

    @Test
    public void getConnectionCount_success() {
        JsonRPCResponse<Long> connectionCount = neoClient.getConnectionCount();

        assertNotNull(connectionCount);
        assertNotNull(connectionCount.getResult());
    }

    @Test
    public void getRawMemPool_success() {
        JsonRPCResponse<String[]> rawMemPool = neoClient.getRawMemPool();

        // Which assertions here?
        assertNotNull(rawMemPool);
    }

    @Test
    public void getRawTransaction_success() {
        JsonRPCResponse<String> rawTransaction = neoClient.getRawTransaction(VALID_TRANSACTION_ID);

        assertNotNull(rawTransaction);
        assertNotNull(rawTransaction.getResult());
    }

    @Test
    public void getRawTransaction_invalidTransactionId () {
        JsonRPCResponse<String> rawTransaction = neoClient.getRawTransaction(INVALID_TRANSACTION_ID);

        assertNull(rawTransaction);
    }

    @Test(expected = NullPointerException.class)
    public void getRawTransaction_transactionIdIsNull() throws Exception {
        neoClient.getRawTransaction(null);
    }

    @Test
    public void getRawTransactionVerbose_success() {
        JsonRPCResponse<Transaction> rawTransactionVerbose = neoClient.getRawTransactionVerbose(VALID_TRANSACTION_ID);

        Transaction transaction = rawTransactionVerbose.getResult();

        assertNotNull(rawTransactionVerbose);
        assertNotNull(transaction);
        assertEquals(VALID_TRANSACTION_ID, transaction.getTxId());
    }

    @Test
    public void getRawTransactionVerbose_invalidTransactionId() {
        JsonRPCResponse<Transaction> rawTransactionVerbose = neoClient.getRawTransactionVerbose(INVALID_TRANSACTION_ID);

        assertNull(rawTransactionVerbose);
    }

    @Test(expected = NullPointerException.class)
    public void getRawTransactionVerbose_transactionIdIsNull() throws Exception {
        neoClient.getRawTransactionVerbose(null);
    }


    @Test
    public void getTxOut_success() {
        JsonRPCResponse<TxOut> txOut = neoClient.getTxOut(VALID_TRANSACTION_ID_2, VALID_N);

        TxOut tx = txOut.getResult();

        assertNotNull(txOut);
        assertNotNull(tx);
        assertEquals(VALID_N, tx.getN());
    }

    @Test
    public void getTxOut_invalidTransactionId() {
        JsonRPCResponse<TxOut> txOut = neoClient.getTxOut(INVALID_TRANSACTION_ID, VALID_N);

        assertNull(txOut);
    }

    @Test
    public void getTxOut_invalidN() {
        JsonRPCResponse<TxOut> txOut = neoClient.getTxOut(VALID_TRANSACTION_ID, INVALID_N);

        assertNull(txOut.getResult());
    }

    @Test(expected = NullPointerException.class)
    public void getTxOut_transactionIdIsNull() throws Exception {
        neoClient.getTxOut(null, 0L);
    }

    @Test(expected = NullPointerException.class)
    public void getTxOut_nIsNull() throws Exception {
        neoClient.getTxOut(VALID_TRANSACTION_ID, null);
    }

}