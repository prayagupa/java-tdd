package com.pseudo.tdd.strategy

import org.scalatest.{FunSuite, Matchers}

class EventDispatcherSpecs extends FunSuite with Matchers {

  test("dispatches events") {
    val actor = new MyMultiEventActor
    actor.onEventA(100) shouldBe 200
  }

  test("dispatches events in functional way") {

  }

  test("dispatches single events in functional way") {

    implicit object MySingleEventActor extends MySingleEventActor

    class MyEventHandler {

      def handle[E1](event: E1)(implicit ev: EventActor1[E1]): E1 = {
        //implicitly[EventActor1[E1]].onEvent(event)
        ev.onEvent(event)
      }

    }

    val actor = new MyEventHandler
    actor.handle(100) shouldBe 200

  }

  implicit object MyMultiEventActor extends MyMultiEventActor

  class MyMultiEventActor extends EventActor2[Int, String] {

    override def onEventA(event: Int): Int = {
      println(s"process A ${event}")
      event * 2
    }

    override def onEventB(event: String): String = {
      println(s"process B ${event}")
      event + "-processed"
    }

  }

  class MySingleEventActor extends EventActor1[Int] {

    override def onEvent(event: Int): Int = {
      println(s"process A ${event}")
      event * 2
    }

  }

}

trait EventActor1[A] {
  def onEvent(event: A): A
}

trait EventActor2[A, B] {

  def onEventA(event: A): A

  def onEventB(event: B): B

}

trait EventActor3[A, B, C] {

  def onEventA(event: A)

  def onEventB(event: B)

  def onEventC(event: C)

}
