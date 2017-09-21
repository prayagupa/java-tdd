package com.pseudo.tdd

import org.scalatest.FunSuite

import scala.collection.parallel.ParSeq
import scala.concurrent.Future
import scala.util.{Failure, Success}

class FutureSpecs extends FunSuite {

  import scala.concurrent.ExecutionContext.Implicits.global

  def itemshipment = Future {
    List("item1", "item2", "item3")
  }

  def ship(item: String) = Future { "shipped" }

  def ship(items: List[String]) : ParSeq[Future[String]] = {
    items.par.map(item => ship(item))
  }

  test("ships parallely") {

    ship(List("item1", "item2", "item3")).map(shipment => {
      shipment.map(x => println(x))
    })

  }

  test("test future onComplete") {
    Future {
      Seq.apply(1, 2, 3).map(_ * 2).map(_ + 1)
    }.onComplete({
      case Success(a: List[Int]) => println(a)
      case Failure(e) => println(e)
    })
  }
}
