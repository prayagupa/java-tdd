package com.golai.tdd;

import java.util.Map;

/**
 * Created by prayagupd
 * on 10/3/16.
 */

public class ServiceB {

    public String deliverOrder(String input) {
        return "delivered";
    }

    public void doSomething1(String arg1, String arg2){
        System.out.println(arg1);
    }

    public void doSomething2(String something){
        System.out.println(something);
    }

    public void doSomething3(Map<String, String> map){
        System.out.println(map);
    }

    public void doSomething4(String something, Map<String, String> map){
        System.out.println(map);
    }
}
