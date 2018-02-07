package com.pseudo.tdd

import java.util.concurrent.{CompletableFuture, TimeUnit}

import org.mockito.{Mock, Mockito}
import org.scalatest.{FunSuite, Matchers}

import scala.collection.parallel.ParSeq
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success, Try}
import scala.compat.java8.FutureConverters._

class FutureSpecs extends FunSuite with Matchers {

  import scala.concurrent.ExecutionContext.Implicits.global

  def itemshipment = Future {
    List("item1", "item2", "item3")
  }

  def ship(item: String) = Future {
    "shipped"
  }

  def ship(items: List[String]): ParSeq[Future[String]] = {
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

  class FutureSubject {
    def doFuture = Future[Int] {
      100
    }
  }

  test("future throws error") {

    val f = Mockito.mock(classOf[FutureSubject])
    Mockito.when(f.doFuture).thenReturn(Future.failed(new Throwable()))

    val result = f.doFuture

    result.map(x => x + 100).recover({ case e => println(e) })

    result.map(x => {
      println(x)
    }) recover {
      case e: Throwable => println(e)
    }
  }

  def futureProcessor1IfxEquals100(x: Int): Future[Int] = Future {
    if (x == 100) 200
    else throw new Exception("Exception 1 happended")
  }

  def futureProcessor2(x: Int): Future[Int] = Future {
    if (x == 100) 200
    else throw new Exception("Exception 2 happended")
  }

  test("Try inside Try") {
    val f = futureProcessor1IfxEquals100(200).map(_ * 100).recover({ case e => e.getMessage }).map(x => x)

    Await.result(f, Duration(100, TimeUnit.MILLISECONDS))
    println(f)


    val f1 = futureProcessor1IfxEquals100(10000).map(x => x * 2).recover({ case e => throw e }).map(x => x * 3)

    val result = Await.result(f1, Duration(100, TimeUnit.MILLISECONDS))

    result shouldBe 20000
  }

  test("futureee") {
    val f1 = futureProcessor1IfxEquals100(10000).map(x => x * 2).map(x => x * 3)

    f1.recover {
      case e: Throwable => println(e)
    }
    val result = Await.result(f1, Duration(100, TimeUnit.MILLISECONDS))

    result shouldBe 20000
  }

  test("kxhjbvjkdsk") {
    val f1 = Try(futureProcessor1IfxEquals100(10000)).map(x => x.map(x => x * 2))

    f1 match {
      case Failure(t) => println(t)
      case Success(s) => println(s)
    }

  }

  test("too many things you can do") {

    def trySomething = 100

    val x = Try(trySomething).map(x => {
      println("loading orders")
      val os = orders(x)
      Thread.sleep(100)
      println(os)
      os
    }).recover({ case e => throw new Exception("error processing orders") })
  }

  private def orders(batch: Int): Future[Int] = {
    futureProcessor1IfxEquals100(2000).transform {
      case Success(x) => Success(11)
      case Failure(x) => Failure(x)
    }
  }

  def doSomethingElse(x: Int): Int = if (x % 2 == 0) x else throw new Exception("error ")

  test("slksd") {

    Try(101).map(x => if (x % 2 == 0) x else throw new Exception("my error")).recover({
      case e => e.printStackTrace()
    })

  }

  test("slksd 1") {

    def futureProcess(x: Int): Future[Int] = Future {
      if (x % 2 == 0) x
      else throw new Exception("my error")
    }

    def processMe(x: Int) = x * 2

    def fuckOffFuture(x: Int): Future[Int] = Future {
      if (x % 2 == 0) x
      else throw new Exception("my error")
    }

    Try(101)
      .map(x => Try(futureProcess(x).flatMap { z => Future(processMe(z)) })).recover({
      case e => e.printStackTrace()
    })

    Future(101)
      .map(x => processMe(x))
      .flatMap(x => Future {
        x * 2
      })

    Thread.sleep(200)
  }

  test("Try map on map sucks") {

    case class Order(id: Int, quantity: Int, itemName: String, status: String)

    def downloadOrder(channel: String) = channel match {
      case "web-channel" => Order(1, 100, "Black Converse shoes", "RECEIVED")
      case _ => throw new Exception("Channels not supported")
    }

    def prepareOrder(order: Order): Future[Order] = Future {
      if (order.quantity < 5) order
      else throw new Exception("Item does not have enough quantity")
    }

    def shipOrder(x: Int) = x * 2

    Future.fromTry(Try(downloadOrder("mobile-channel-should-throw-ex")))
      .flatMap(order => prepareOrder(order))
      .flatMap(order => Future {
        s"${order.itemName} prepared"
      })
      .recover { case e => e.printStackTrace() }

    Future.fromTry(Try(downloadOrder("web-channel")))
      .flatMap(order => prepareOrder(order))
      .flatMap(order => Future {
        s"${order.itemName} prepared"
      })
      .recover { case e => e.printStackTrace() }

  }

  test("Try map on map sucks 2") {

    case class Order(id: Int, quantity: Int, itemName: String, status: String)

    def downloadOrder(channel: String) = channel match {
      case "web-channel" => Order(1, 100, "Black Converse shoes", "RECEIVED")
      case _ => throw new Exception("Channels not supported")
    }

    def prepareOrderFuture(order: Order): Order= order

    def shipOrder(order: Order) = Future { order.copy(status = "SHIPPING") }

    def delivered(order: Order) = {
      Future {s"${order.itemName} delivered"}
    }

    def tellToProcess(): Future[String] = {

      Future.fromTry(Try(downloadOrder("mobile-channel")))
        .flatMap(order => Future(prepareOrderFuture(order)))
        .flatMap(shipOrder)
        .flatMap(order => delivered(order))
        .recover { case e =>
          e.printStackTrace()
          throw new Exception("Error processing order", e)
        }
    }

    val response = tellToProcess().toJava.toCompletableFuture

    println(response)

    Thread.sleep(100)
  }
}
