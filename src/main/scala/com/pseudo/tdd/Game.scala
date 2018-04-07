package com.pseudo.tdd

/**
  * Created by prayagupd
  * on 1/3/17.
  */


case class CountryLeaderboardEntry(country: String, points: Int)

trait CountryLeaderboard {
  def add(country: String): Unit

  def getTopCountries(): List[CountryLeaderboardEntry]
}

case class Player(id: Int, nickname: String, country: String)

class PlayerDatabase() {
  def getPlayerById(playerId: Int): Player = Player(playerId,
    nickname = "whatever from database",
    country = "whatever country")
}

class RealCountryLeaderboard() {

  def addVictoryForCountry(country: String): Unit = println(country)

  def getTopCountries(): List[CountryLeaderboardEntry] = List.empty
}

case class Search(winner: Int, loser: Int)

class Game(playerDatabase: PlayerDatabase, leaderBoard: CountryLeaderboard) {

  def play(search: Search): Unit = {
    val player = playerDatabase.getPlayerById(search.winner) //stub
    leaderBoard.add(player.country)
  }
}
