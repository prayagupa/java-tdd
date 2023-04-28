package com.golai.tdd;

import java.util.HashMap;
import java.util.Map;

public class ServiceA {

    public ServiceB serviceB = new ServiceB();

    public void executeSomething(final String someArgs) {

        serviceB.doSomething1(someArgs + "-once", someArgs + "-again");
        serviceB.doSomething2(someArgs);

        Map<String, String> map = new HashMap<String, String>() {{
            put("key", someArgs);
        }};
        serviceB.doSomething3(map);
        serviceB.doSomething4(someArgs, map);
    }

    public String deliverOrder(String orderID) {
        return orderID + "-" + serviceB.deliverOrder(orderID);
    }
}
