package com.pseudo.tdd

import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

/**
  * Created by prayagupd
  * on 1/3/17.
  */

class ServiceASpecsUsingScalaMock extends FlatSpec with MockFactory {

  val serviceA = new ServiceA

  "service A" should "delegate to ServiceB with kvp" in {

    println("classpath - " + System.getProperty("java.classpath"))

    serviceA.serviceB = mock[ServiceB]

    //assertions
    (serviceA.serviceB.doSomething1(_:String, _: String)) expects("serpico-once", "serpico-again")
    (serviceA.serviceB.doSomething2 (_: String)) expects("serpico")

    val hash = new java.util.HashMap[String, String] { put("key", "serpico") }

    (serviceA.serviceB.doSomething3 (_: java.util.Map[String, String])) expects(hash)
    (serviceA.serviceB.doSomething4 (_: String, _:java.util.Map[String, String])) expects("serpico", hash)

    //when
    serviceA.executeSomething("serpico")

  }
}
