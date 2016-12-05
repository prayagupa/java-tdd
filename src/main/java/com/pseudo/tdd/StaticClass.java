package com.pseudo.tdd;

/**
 * Created by prayagupd
 * on 11/1/16.
 */

public class StaticClass {

    public static String staticMethod() throws Exception {
        return "static world";
    }

    public static String staticMethod(String name) throws Exception {
        return "static world - " + name;
    }
}
