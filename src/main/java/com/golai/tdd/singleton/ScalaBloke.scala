package com.golai.tdd.singleton

/**
  * Created by prayagupd
  * on 11/22/16.
  */

object Apple {
  try {
    println("static - first cleanup apples")
  } catch {
    case e: Exception => {
      e.printStackTrace()
    }
  }
}

class Apple {

  Apple

  def eat() {
    println("non-static - eat apple")
  }
}

object ScalaBloke {
  def main(args: Array[String]) {

    val redApple = new Apple
    redApple.eat()

    val yellowApple = new Apple
    yellowApple.eat()
  }
}