package com.github.dop89.model.jsonrpc;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.IOException;
import java.io.InputStream;

import static com.github.dop89.model.Methods.GET_BEST_BLOCK_HASH;
import static org.junit.Assert.fail;

public class JsonRPCRequestTest {


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

    private String loadFile(String path) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(path);

         return IOUtils.toString(inputStream, "UTF-8");
    }

}