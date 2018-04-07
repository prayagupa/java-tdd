package com.pseudo.tdd

import org.scalatest.{FunSuite, Matchers}

import scala.util.{Failure, Success, Try}

class ExceptionInsideTrySuccess extends FunSuite with Matchers {

  def goodFunc = true

  def doSomethingOO(throwError: Boolean) = {

    try {
      Try(goodFunc) match {
        case Success(_) =>
          if (throwError)
            throw new Exception("My personal oo failure")
          else
            "success"

        case Failure(_) => throw new Exception("bad function")
      }
    } catch {
      case e: Exception => e.getMessage + "+1"
    }
  }

  def doSomethingFunctional(throwError: Boolean) = {
    Try(Try(goodFunc) match {
      case Success(_) =>
        if (throwError) throw new Exception("My personal func exception")
        else "success"

      case Failure(_) => throw new Exception("bad function")
    }) match {
      case Success(x) => x
      case Failure(e) => e.getMessage + "+1"
    }
  }

  def doSomethingFunctional2(throwError: Boolean) = {
    Try(Try(goodFunc).map(x => {
      if (throwError) throw new Exception("My personal func exception")
      else "success"
    })).recover {
      case x: Exception => x.getMessage + "+3"
    }
  }

  test("exception inside try success") {
    doSomethingOO(true) shouldBe "My personal oo failure+1"
    doSomethingFunctional(true) shouldBe "My personal func exception+1"
    doSomethingFunctional2(true) shouldBe "My personal func exception+3"
  }
}
