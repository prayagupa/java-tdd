package com.pseudo.tdd.scalamock

import com.pseudo.tdd._
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

/**
  * Created by prayagupd
  * on 1/3/17.
  */

class GameScalaMockSpecs extends FlatSpec with MockFactory {

  val winner = Player(id = 1, nickname = "prayagaupd", country = "USA")
  val loser = Player(id = 2, nickname = "Curtis", country = "Germany")

  "doSomething" should "update LeaderBoard after finished match" in {
    //you expect on mock
    val countryLeaderBoardMock = mock[CountryLeaderboard]

    val userDetailsServiceStub = stub[PlayerDatabase]
    // configure stubs
    (userDetailsServiceStub.getPlayerById _).when(1).returns(winner)
    (userDetailsServiceStub.getPlayerById _).when(2).returns(loser)

    // capture expectations
    (countryLeaderBoardMock.add _).expects("USA")

    // run system under test
    val subject = new Game(userDetailsServiceStub, countryLeaderBoardMock)

    subject.play(Search(winner = winner.id, loser = loser.id))
  }
}
