package com.pseudo.tdd

import org.scalatest.{FunSuite, Matchers}

class ImplicitlySpecs extends FunSuite with Matchers {

  trait Vehicle {
    def moves: String
  }

  case class Car(moves: String = "carrrrrrr") extends Vehicle

  case class Motor(moves: String = "motorrrrr") extends Vehicle

  def main(args: Array[String]): Unit = {

    implicit val cars: List[Car] = List(Car(), Car())

    println(implicitly[List[Car]].map(_.moves).mkString(","))

  }

  test("encrypted") {

    trait CanEncrypt {
      def encrypt(implicit crypto: String, data: String) = "enced " + data
    }


    class Encryptero()(implicit val crypto: String) extends CanEncrypt {
      def doSomething(data: String) = encrypt(implicitly, data = data)
    }

    implicit val a = ""

    new Encryptero().doSomething("my data") shouldBe "enced my data"
  }
}
