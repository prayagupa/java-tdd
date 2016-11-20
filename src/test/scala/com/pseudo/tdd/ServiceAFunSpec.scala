package com.pseudo.tdd

import org.mockito.{Matchers, Mockito}
import org.scalatest.FunSpec

/**
  * Created by prayagupd
  * on 11/20/16.
  */

class ServiceAFunSpec extends FunSpec {

  val service = new ServiceA
  service.serviceB = Mockito.mock(classOf[ServiceB])

  describe("when serviceA is called") {

    service.echoAlPachino("divine")

    it("echoAlPachino delegates to serviceB doSomething1") { Mockito.verify(service.serviceB).doSomething1(Matchers.eq("divine-once"), Matchers.eq("divine-again"))}
    it("echoAlPachino delegates to serviceB doSomething2") { Mockito.verify(service.serviceB).doSomething2(Matchers.eq("divine")) }
  }
}
