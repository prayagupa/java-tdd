package com.pseudo.tdd.scalamock

import org.scalamock.scalatest.MockFactory
import org.scalatest.{FunSuite, Matchers}

class Dependency {
  def doSomething(x: Int, y: Int): Int = x + y
}

class Subject(val dependency: Dependency) {

  def doSomething(x: Int, y: Int): Int = dependency.doSomething(x, y)

}

class MultipleParamsStub extends FunSuite with Matchers with MockFactory {

  test("test") {
    val deps = stub[Dependency]
    //val deps = mock[Dependency]
    val subject = new Subject(deps)

    // stub on muliple params must have value populated or else *
    (deps.doSomething _).when(*, *).returns(10000)

    //(deps.doSomething _) expects(*, *) returning 10000
    subject.doSomething(1, 2) shouldBe 10000
    subject.doSomething(1000, 9999) shouldBe 10000
  }
}
