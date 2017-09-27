package com.pseudo.tdd.strategy

import com.pseudo.tdd.strategy.Intent.{BandAlbumsIntent, BandTourIntent}
import com.pseudo.tdd.strategy.IntentAction.{BandAlbumAction, BandTourAction}
import org.scalatest.{FunSuite, Matchers}

class ApplicationRouterSpecs extends FunSuite with Matchers {

  test("returns BandTourAction for BandTourIntent, when directly passed BandTourIntent") {

    ApplicationRouter.processIntentAction(BandTourIntent()).getClass shouldBe classOf[BandTourAction]

    ApplicationRouter.processIntentAction(BandAlbumsIntent()).getClass shouldBe classOf[BandAlbumAction]
  }

  test("also returns BandTourAction for BandTourIntent, using apply") {

    ApplicationRouter.processIntentAction(Intent(`type` = "BandTourStatus")).getClass shouldBe classOf[BandTourAction]
    ApplicationRouter.processIntentAction(Intent(`type` = "BandsAlbums")).getClass shouldBe classOf[BandTourAction]

  }

}
