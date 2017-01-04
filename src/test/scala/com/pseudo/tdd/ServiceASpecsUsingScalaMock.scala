package com.pseudo.tdd

import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, FunSuite}

/**
  * Created by prayagupd
  * on 1/3/17.
  */

class ServiceASpecsUsingScalaMock extends FlatSpec with MockFactory {

  val service = new ServiceA
  service.serviceB = mock[ServiceB]

  "service A" should "delegate to ServiceB with kvp" in {

    (service.serviceB.doSomething1 _) expects("serpico-once", "serpico-again")
    (service.serviceB.doSomething2 _) expects("serpico")

    val hash = new java.util.HashMap[String, String] {
      put("key", "serpico")
    }

    (service.serviceB.doSomething3 _) expects(hash)
    (service.serviceB.doSomething4 _) expects("serpico", hash)

    //when
    service.echoAlPachino("serpico")

  }
}
