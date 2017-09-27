package com.pseudo.tdd.strategy

object ImplicitlySucks {

  trait Vehicle {
    def moves: String
  }

  case class Car(moves: String = "carrrrrrr") extends Vehicle

  case class Motor(moves: String = "motorrrrr") extends Vehicle

  def doesNotWork = {

    implicit object Car
    implicit val cars: List[Car.type] = List(Car, Car)

    //println(implicitly[List[Car]].map(_.moves).mkString(","))

  }

  def works = {
    sealed trait Json
    object Json {

      case class Str(s: String) extends Json

      case class Num(value: Double) extends Json

      // ... many more definitions
    }

    trait Jsonable[T] {
      def serialize(t: T): Json
    }
    object Jsonable {

      implicit object StringJsonable extends Jsonable[String] {
        def serialize(t: String) = Json.Str(t)
      }

      implicit object DoubleJsonable extends Jsonable[Double] {
        def serialize(t: Double) = Json.Num(t)
      }

      implicit object IntJsonable extends Jsonable[Int] {
        def serialize(t: Int) = Json.Num(t.toDouble)
      }

    }

    def convertToJson[T](x: T)(implicit converter: Jsonable[T]): Json = {
      converter.serialize(x)
    }

    val x = convertToJson("hello")

    println(x)
  }

  def intent = {
    sealed trait IntentAction
    object IntentAction {

      case class Action1(s: String) extends IntentAction

      case class Action2(value: Double) extends IntentAction

    }

    trait IntentActionHandler[T] {
      def handle(t: T): IntentAction
    }

    object IntentActionHandler {

      implicit object Action1IntentActionHandler extends IntentActionHandler[String] {
        def handle(t: String) = IntentAction.Action1(t)
      }

      implicit object Action2IntentActionHandler extends IntentActionHandler[Double] {
        def handle(t: Double) = IntentAction.Action2(t)
      }

      implicit object Action3IntentActionHandler extends IntentActionHandler[Int] {
        def handle(t: Int) = IntentAction.Action2(t.toDouble)
      }

    }

    def processIntentAction[T](intent: T)(implicit handler: IntentActionHandler[T]): IntentAction = {
      handler.handle(intent)
    }

    val x = processIntentAction("action1")

    println(x)
  }

  def main(args: Array[String]): Unit = {
    intent
  }
}
