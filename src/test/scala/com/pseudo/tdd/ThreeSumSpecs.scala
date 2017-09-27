package com.pseudo.tdd

import org.scalatest.FunSuite

class ThreeSumSpecs extends FunSuite {

  def Threesum(array: Array[Int]): Int = {

    var count = 0

    for (i <- 0 until array.length - 2) {
      for (j <- i + 1 until array.length - 1) {
        for (k <- j + 1 until array.length) {
          if (array(i) + array(j) + array(k) == 0) {
            count = count + 1
          }
        }
      }
    }
    count
  }

  test("3sum") {
    assert(Threesum(Array(1, -2, 1)) == 1)
  }

}
