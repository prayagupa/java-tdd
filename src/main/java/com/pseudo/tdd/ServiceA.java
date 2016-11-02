package com.pseudo.tdd.tdd;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prayagupd
 * on 10/3/16.
 */

public class ServiceA {

    public ServiceB serviceB = new ServiceB();

    public void method1(final String something) {

        serviceB.method2(something+"-once", something+"-again");
        serviceB.method3(something);

        Map<String, String> map = new HashMap<String, String>(){{
            put("key", something);
        }};
        serviceB.method4(map);
        serviceB.method5(something, map);
    }
}
