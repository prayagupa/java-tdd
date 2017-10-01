package com.pseudo.tdd.strategy

import com.pseudo.tdd.strategy
import com.pseudo.tdd.strategy.Intent.BandTourIntent


trait Intent { def `type`: String }

object Intent {

  case class BandTourIntent(`type`: String = "BandTourStatus") extends Intent

  case class BandAlbumsIntent(`type`: String = "BandsAlbums") extends Intent

  def apply(`type`: String): Intent = `type` match {
    case "BandTourStatus" => BandTourIntent()
    case "BandsAlbums" => BandAlbumsIntent()
  }
}

trait IntentAction

object IntentAction {

  case class BandTourAction(desc: String, country: String) extends IntentAction

  case class BandAlbumAction(desc: String) extends IntentAction

}

//typeclass
//A typeclass is a sort of interface that defines some behavior. If a type is a part of a typeclass,
// that means that it supports and implements the behavior the typeclass describes.
trait IntentActionHandler[T] { def handle(t: T): IntentAction }

class TourIntentActionHandler extends IntentActionHandler[Intent.BandTourIntent] {
  def handle(intent: Intent.BandTourIntent) = IntentAction.BandTourAction("Touring", "USA")
}

class AlbumIntentActionHandler extends IntentActionHandler[Intent.BandAlbumsIntent] {
  def handle(intent: Intent.BandAlbumsIntent) = IntentAction.BandAlbumAction("4 albums")
}

object IntentActionHandler {

  implicit object TourIntentActionHandler extends TourIntentActionHandler

  implicit object AlbumIntentActionHandler extends AlbumIntentActionHandler

}

object ApplicationRouter {

  import IntentActionHandler._

  def processIntentAction[I](intent: I)(implicit ev: IntentActionHandler[_ >: I]): IntentAction = ev.handle(intent)

}
