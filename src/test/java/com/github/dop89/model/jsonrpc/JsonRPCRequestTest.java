package com.github.dop89.model.jsonrpc;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;

import static com.github.dop89.model.Methods.*;
import static org.junit.Assert.fail;

public class JsonRPCRequestTest {

    private static final String BLOCK_HASH = "aBlockHash";
    private static final String TRANSACTION_ID = "aRandomTransactionId";
    private static final Long BLOCK_ID = 1337L;

    @Test
    public void createJsonRPCRequest_getBestBlockHash_success() {

        JsonRPCRequest getBestBlockHash = new JsonRPCRequest<Long>(GET_BEST_BLOCK_HASH);

        try {
            JSONAssert.assertEquals(loadFile("getbestblockhash_request.json"), getBestBlockHash.toJsonString(), JSONCompareMode.STRICT);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void createJsonRPCRequest_getBlockByHash_success() {

        JsonRPCRequest getBlock = new JsonRPCRequest<Long>(GET_BLOCK);
        getBlock.setParams(Collections.singletonList(BLOCK_HASH));

        try {
            JSONAssert.assertEquals(String.format(loadFile("getblock_byhash_request.json"), BLOCK_HASH), getBlock.toJsonString(), JSONCompareMode.STRICT);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test
    public void createJsonRPCRequest_getBlockByIndex_success() {

        JsonRPCRequest getBlock = new JsonRPCRequest<Long>(GET_BLOCK);
        getBlock.setParams(Collections.singletonList(BLOCK_ID));

        try {
            JSONAssert.assertEquals(String.format(loadFile("getblock_byindex_request.json"), BLOCK_ID), getBlock.toJsonString(), JSONCompareMode.STRICT);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test
    public void createJsonRPCRequest_getBlockCount_success() {

        JsonRPCRequest getBlockCount = new JsonRPCRequest<Long>(GET_BLOCK_COUNT);

        try {
            JSONAssert.assertEquals(loadFile("getblockcount_request.json"), getBlockCount.toJsonString(), JSONCompareMode.STRICT);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
            fail();
        }
    }


    @Test
    public void createJsonRPCRequest_getBlockHash_success() {

        JsonRPCRequest getBlockHash = new JsonRPCRequest<Long>(GET_BLOCK_HASH);
        getBlockHash.setParams(Collections.singletonList(BLOCK_HASH));

        try {
            JSONAssert.assertEquals(String.format(loadFile("getblockhash_request.json"), BLOCK_HASH), getBlockHash.toJsonString(), JSONCompareMode.STRICT);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
            fail();
        }

    }


    @Test
    public void createJsonRPCRequest_getConnectionCount_success() {

        JsonRPCRequest getConnectionCount = new JsonRPCRequest<Long>(GET_CONNECTION_COUNT);

        try {
            JSONAssert.assertEquals(loadFile("getconnectioncount_request.json"), getConnectionCount.toJsonString(), JSONCompareMode.STRICT);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void createJsonRPCRequest_getRawMemPool_success() {

        JsonRPCRequest getRawMemPool = new JsonRPCRequest<Long>(GET_RAW_MEMPOOL);

        try {
            JSONAssert.assertEquals(loadFile("getrawmempool_request.json"), getRawMemPool.toJsonString(), JSONCompareMode.STRICT);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
            fail();
        }
    }


    @Test
    public void createJsonRPCRequest_getRawTransaction_success() {

        JsonRPCRequest getRawTransaction = new JsonRPCRequest<Long>(GET_RAW_TRANSACTION);
        getRawTransaction.setParams(Collections.singletonList(TRANSACTION_ID));

        try {
            JSONAssert.assertEquals(String.format(loadFile("getrawtransaction_request.json"), TRANSACTION_ID), getRawTransaction.toJsonString(), JSONCompareMode.STRICT);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void createJsonRPCRequest_getRawTransaction_verbose_success() {

        JsonRPCRequest getRawTransaction = new JsonRPCRequest<Long>(GET_RAW_TRANSACTION);
        getRawTransaction.setParams(Arrays.asList(TRANSACTION_ID, 1L));

        try {
            JSONAssert.assertEquals(String.format(loadFile("getrawtransaction_verbose_request.json"), TRANSACTION_ID, 1L), getRawTransaction.toJsonString(), JSONCompareMode.STRICT);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void createJsonRPCRequest_getTxOut_success() {

        Long n = 10L;

        JsonRPCRequest getRawTransaction = new JsonRPCRequest<Long>(GET_TXOUT);
        getRawTransaction.setParams(Arrays.asList(TRANSACTION_ID, n));

        try {
            JSONAssert.assertEquals(String.format(loadFile("gettxout_request.json"), TRANSACTION_ID, n), getRawTransaction.toJsonString(), JSONCompareMode.STRICT);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    private String loadFile(String path) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(path);

         return IOUtils.toString(inputStream, "UTF-8");
    }

}