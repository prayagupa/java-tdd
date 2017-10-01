package com.pseudo.tdd

import java.text.SimpleDateFormat

import org.mockito
import org.mockito.Mockito
import org.mockito.stubbing.OngoingStubbing
import org.scalatest.FunSuite

import scala.util.{Failure, Success, Try}

/**
  * Created by prayagupd
  * on 1/9/17.
  */

class Subject {

  def doSomething(): String = {
    "500"
  }

}

class TestSpecs extends FunSuite {
  val s = Mockito.mock(classOf[Subject])

  test("whatever") {
    when(s.doSomething) thenReturn "apple"

    assert(s.doSomething() == "apple")
  }

  def when[T](methodCall: T): OngoingStubbing[T] = Mockito.when(methodCall)

  test("dfs") {
    def isAllDigits(x: String) = x forall Character.isDigit

    var createTimeStamp = "1487905455000"

    val x = {
      createTimeStamp match {
        case "unknown" => -1L
        case x => if (isAllDigits(x)) x.toLong
        else {
          val format = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy")
          Try(format.parse(x).getTime) match {
            case Success(t) => t
            case Failure(_) => -1L
          }
        }
      }
    }

    println(x)
  }

  test("f") {
    val nonEmpty = Seq("somevalue")
    val empty = Seq[String]()

    val seqOpt = List(Option(empty), Option(Seq("somevalue"))) map {
      case seq if seq.get.isEmpty => None
      case x => x
    }

    assert(seqOpt.head == None)
    assert(seqOpt(1) == Option(nonEmpty))
  }
}
