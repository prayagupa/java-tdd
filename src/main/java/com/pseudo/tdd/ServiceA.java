package com.pseudo.tdd;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prayagupd
 * on 10/3/16.
 */

public class ServiceA {

    public ServiceB serviceB = new ServiceB();

    public void echoAlPachino(final String something) {

        serviceB.doSomething1(something+"-once", something+"-again");
        serviceB.doSomething2(something);

        Map<String, String> map = new HashMap<String, String>(){{
            put("key", something);
        }};
        serviceB.doSomething3(map);
        serviceB.doSomething4(something, map);
    }
}
