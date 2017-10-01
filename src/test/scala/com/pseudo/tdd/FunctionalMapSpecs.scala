package com.pseudo.tdd

import org.scalatest.FunSpec

/**
  * Created by prayagupd
  * on 2/19/17.
  */
class FunctionalMapSpecs extends FunSpec {

  it("prints a map in key value format") {
    val awesomeMap = Map("k1" -> "v1",
      "k2" -> 2,
      "k3" -> 10.28,
      "k4" -> List(Map("k4.k1" -> "v3", "k4.k2" -> List(Map("k4.k3" -> "v4")))))

    printInKeyValueFormat(awesomeMap)

    def printInKeyValueFormat(givenAMap: Map[String, Any]): Unit = {
      givenAMap foreach {
        case (k: String, v: String) => println(k + "=" + v)
        case (k: String, v: Int) => println(k + "=" + v)
        case (k: String, v: Long) => println(k + "=" + v)
        case (k: String, v: Double) => println(k + "=" + v)
        case (k: String, v: List[Map[String, Any]]) => v.foreach(x => printInKeyValueFormat(x))
      }
    }

    println(awesomeMap mkString ("="))
  }

  it("flattens me to single tuple") {

    implicit def flattMe(seq: Seq[((Int, Int), Int)]): Seq[(Int, Int, Int)] =
      seq.map { case ((x, y), z) => (x, y, z) }

    val data = flattMe(Seq(((1, 2), 3), ((4, 5), 6), ((7, 8), 9)))

    assert(data.head == (1, 2, 3))
    assert(data(1) == (4, 5, 6))
    assert(data(2) == (7, 8, 9))

  }

  it("flattens me") {

    implicit def flattenMe[A, B, C](tuple: ((A, B), C)): (A, B, C) = {
      (tuple._1._1, tuple._1._2, tuple._2)
    }

    val flattened = ((1, 2), 3)
    println(flattened == (1, 2, 3))
  }

  it("takes list as implicit") {

    implicit def doSomething(num: Int): String = num.toString //FIXME

    val x = List(doSomething(1))

    assert(x.head == "1")
  }
}
