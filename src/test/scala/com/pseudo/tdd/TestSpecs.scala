package com.pseudo.tdd

import org.mockito
import org.mockito.Mockito
import org.mockito.stubbing.OngoingStubbing
import org.scalatest.FunSuite

/**
  * Created by prayagupd
  * on 1/9/17.
  */

class Subject {

  def doSomething(): String = {
    "500"
  }

}

class TestSpecs extends FunSuite {
  val s = Mockito.mock(classOf[Subject])

  test("whatever") {
    when(s.doSomething) thenReturn "apple"

    assert(s.doSomething() == "apple")
  }

  def when[T](methodCall: T): OngoingStubbing[T] = Mockito.when(methodCall)
}
