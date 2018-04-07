package com.pseudo.tdd.scalamock

import com.pseudo.tdd.{ServiceA, ServiceB}
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FunSuite, Matchers}

class ScalaMockJavaClass extends FunSuite with Matchers with MockFactory {

  val deps = stub[ServiceB]

  test("test") {

    val subject = new ServiceA
    subject.serviceB = deps

    (deps.deliverOrder _).when("some-order-number").returns("your order is delivered")

    subject.deliverOrder("some-order-number") shouldBe "your order is delivered"

  }

}
