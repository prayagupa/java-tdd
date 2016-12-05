package com.pseudo.tdd.singleton;

/**
 * Created by prayagupd
 * on 11/22/16.
 */

class Orange {

    static {
        System.out.println("cleanup");
    }

    public void eat() {
        System.out.println("eating orange");
    }
}

public class StaticBloke {

    public static void main(String[] args) {
        new Orange().eat();

        new Orange().eat();
    }

}
