package com.pseudo.tdd.strategy

import org.scalatest.{FunSuite, Matchers}

class ApplicationRouterSpecs extends FunSuite with Matchers {

  test("returns BandTourAction for BandTourIntent, when directly passed BandTourIntent") {

    ApplicationRouter.processIntentAction(BandTourIntent()).getClass shouldBe classOf[BandTourAction]

    ApplicationRouter.processIntentAction(BandAlbumsIntent()).getClass shouldBe classOf[BandAlbumAction]
  }

  test("also returns BandTourAction for BandTourIntent, using apply") {

    //ApplicationRouter.processIntentAction(Intent(`type` = "BandTourStatus")).getClass shouldBe classOf[BandTourAction]
    //ApplicationRouter.processIntentAction(Intent(`type` = "BandsAlbums")).getClass shouldBe classOf[BandTourAction]

  }

  test("x") {
    //      val input = "month(1989),year(2017),month(2017)"
    //      val regex = "([0-9]+) ([0-9]+) ([0-9]+)".r
    //
    //      val regex(startDate, otherDate, notherDate) = input

    val pattern = "([0-9]+) ([A-Za-z]+)".r
    val pattern(count, fruit) = "100 Bananas"
  }

}
