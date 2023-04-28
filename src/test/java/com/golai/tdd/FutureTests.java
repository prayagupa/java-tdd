package com.golai.tdd;

import akka.dispatch.Futures;
import org.junit.Test;
import scala.compat.java8.FutureConverters;
import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.util.concurrent.CompletableFuture;

public class FutureTests {

    @Test
    public void test() throws InterruptedException {

        Promise promise = Futures.promise();
        Future scalaFuture = promise.future();
        CompletableFuture cf = FutureConverters.toJava(scalaFuture).toCompletableFuture();
        cf.whenComplete((result, t) -> {
            System.out.println(result);
        });
        promise.success("works");
        Thread.sleep(1000);
    }

}
