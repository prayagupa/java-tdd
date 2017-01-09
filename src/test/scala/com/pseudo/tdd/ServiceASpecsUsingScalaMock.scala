package com.pseudo.tdd

import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, FunSuite}

/**
  * Created by prayagupd
  * on 1/3/17.
  */

class ServiceASpecsUsingScalaMock extends FlatSpec with MockFactory {

  val serviceA = new ServiceA
  serviceA.serviceB = mock[ServiceB]

  "service A" should "delegate to ServiceB with kvp" in {

    //assertions
    (serviceA.serviceB.doSomething1(_:String, _: String)) expects("serpico-once", "serpico-again")
    (serviceA.serviceB.doSomething2 (_: String)) expects("serpico")

    val hash = new java.util.HashMap[String, String] { put("key", "serpico") }

    (serviceA.serviceB.doSomething3 (_: java.util.Map[String, String])) expects(hash)
    (serviceA.serviceB.doSomething4 (_: String, _:java.util.Map[String, String])) expects("serpico", hash)

    //when
    serviceA.echoAlPachino("serpico")

  }
}
