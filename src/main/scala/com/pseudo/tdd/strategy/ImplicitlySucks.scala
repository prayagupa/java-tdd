package com.pseudo.tdd.strategy

object ImplicitlySucks {

  trait Vehicle {
    def moves: String
  }

  case class Car(moves: String = "carrrrrrr") extends Vehicle

  case class Motor(moves: String = "motorrrrr") extends Vehicle

  def listOfImplicits = {

    implicit val cars: List[Car] = List(Car(), Car())

    println(implicitly[List[Car]].map(_.moves).mkString(","))

  }

  def works = {
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


  def intent = {

    trait Intent {
      def `type`: String
    }

    object Intent {

      case class BandTourIntent(`type`: String = "BandTourStatus") extends Intent

      case class BandAlbumsIntent(`type`: String = "BandsAlbums") extends Intent

    }

    trait IntentAction

    object IntentAction {

      case class BandTourAction(i: Intent.BandTourIntent) extends IntentAction

      case class BandAlbumAction(i: Intent.BandAlbumsIntent) extends IntentAction

    }

    trait IntentActionHandler[T] {
      def handle(t: T): IntentAction
    }

    //object IntentActionHandler {

    implicit object TourIntentActionHandler extends IntentActionHandler[Intent.BandTourIntent] {
      def handle(t: Intent.BandTourIntent) = IntentAction.BandTourAction(t)
    }

    implicit object AlbumIntentActionHandler extends IntentActionHandler[Intent.BandAlbumsIntent] {
      def handle(t: Intent.BandAlbumsIntent) = IntentAction.BandAlbumAction(t)
    }

    //}

    //def processIntentAction[T](intent: T)(implicit handler: IntentActionHandler[T]): IntentAction = handler.handle(intent)

    //val action = processIntentAction(Intent.BandTourIntent())

    //println(action)

    println(implicitly[IntentActionHandler[Intent.BandTourIntent]].handle(Intent.BandTourIntent()))

  }

  def main(args: Array[String]): Unit = {
    intent
  }
}
