package com.github.dop89;

import com.github.dop89.client.NeoClient;
import com.github.dop89.model.GetBalance;
import com.github.dop89.model.JsonRPCResponse;

public class Runner {

    public static void main (String[] args) {

        NeoClient client = new NeoClient();

        JsonRPCResponse<GetBalance> balance = client.getBalance("025d82f7b00a9ff1cfe709abe3c4741a105d067178e645bc3ebad9bc79af47d4");

        System.out.println(balance.getMethod().getBalance());
        System.out.println(balance.getMethod().getGas());

    }
}
