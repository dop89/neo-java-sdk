# neo-java-sdk
A Java SDK for interacting with the NEO blockchain


## Installation

* since its an early version, manual installation is required
* download the source files and place it in your classpath


## How to use

```java
    public static void main (String[] args) {

        NeoClient client = new NeoClient("http://seed1.neo.org:20332");
        
        JsonRPCResponse<GetBlock> blockResponse = client.getBlockVerbose(10000L);
        GetBlock blockResponse = blockVerbose.getResult();
    }
```

## Examples
For further examples please see [runner.java](https://github.com/dop89/neo-java-sdk/blob/master/src/main/java/com/github/dop89/Runner.java).

## Donations
Neo donations are welcome :)

AarhQJFSTwA39BxHhMQpKv4Kd6uwjneuy8