package com.pseudo.tdd.scalamock

import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, FunSpec, FunSuite}

object api {

  trait Service1 {
    val service2 = new Service2

    def functionality1 = service2.functionalityY
  }

  class Service2 {

    def functionalityY = 1000
  }
}

class NoParamStub extends FunSuite with MockFactory {

  import api._

  val service1 = new Service1 {
    override val service2: api.Service2 = stub[Service2]
  }

  test("stuff") {
    (service1.service2.functionalityY _).when().returns(10)
    assert(service1.functionality1 == 10)
  }
}
