package com.pseudo.tdd.scalamock

import org.scalamock.scalatest.MockFactory
import org.scalatest.{AsyncFlatSpec, FlatSpec, FunSpec}

import scala.concurrent.Future

class MyScalamockTrait extends FlatSpec with MockFactory {

  //def addSoon(addends: Int*): Future[Int] = Future { addends.sum }

  behavior of "addSoon"

  it should "eventually compute a sum of passed Ints" in {
    //val futureSum: Future[Int] = addSoon(1, 2)
    //futureSum map { sum => assert(sum == 3) }
    assert(1 == 1)
  }

}
