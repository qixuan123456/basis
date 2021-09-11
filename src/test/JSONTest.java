package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JSONTest {
    public static void main(String[] args) {
        Map<String,Object> map = new ConcurrentHashMap<>();

        List paramsList = new ArrayList();
        map.put("json-rpc", "2.0");
        map.put("method", "web3_clientVersion");
        map.put("params", paramsList);
        map.put("id", "67");

        System.out.println(map.toString());

    }
}
