package com.pseudo.tdd

import org.scalamock.scalatest.MockFactory
import org.scalatest.FunSuite

/**
  * Created by prayagupd
  * on 1/3/17.
  */

class ServiceASpecsUsingScalaMock extends FunSuite with MockFactory {

  val service = new ServiceA
  service.serviceB = mock[ServiceB]

  test("Service A delegates to ServiceB with kvp") {

    service.echoAlPachino("serpico")

    service.serviceB.doSomething2()
  }
}
