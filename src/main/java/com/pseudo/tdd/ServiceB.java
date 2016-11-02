package com.pseudo.tdd.tdd;

import java.util.Map;

/**
 * Created by mukti
 * on 10/3/16.
 */
public class ServiceB {

    public void method2(String arg1, String arg2){
        System.out.println(arg1);
    }

    public void method3(String something){
        System.out.println(something);
    }

    public void method4(Map<String, String> map){
        System.out.println(map);
    }

    public void method5(String something, Map<String, String> map){
        System.out.println(map);
    }
}
