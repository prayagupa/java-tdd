package com.pseudo.tdd.strategy

object ImplicitlySucks {

  trait Vehicle {
    def moves: String
  }

  case class Car(moves: String = "carrrrrrr") extends Vehicle

  case class Motor(moves: String = "motorrrrr") extends Vehicle

  def main(args: Array[String]): Unit = {

    implicit val cars: List[Car] = List(Car(), Car())

    println(implicitly[List[Car]].map(_.moves).mkString(","))

  }
}
