package com.pseudo.tdd

import org.junit.runner.RunWith
import org.mockito.{ArgumentCaptor, Matchers, Mockito}
import org.scalatest.junit.JUnitRunner
import org.scalatest.{BeforeAndAfterEach, FunSuite}

import scala.collection.JavaConversions._

/**
  * Created by prayagupd
  * on 10/3/16.
  */

@RunWith(classOf[JUnitRunner])
class ServiceASpec extends FunSuite with BeforeAndAfterEach {

  var serviceA : ServiceA = _

  override def beforeEach(){
    serviceA = new ServiceA()
    serviceA.serviceB = Mockito.mock(classOf[ServiceB])
  }

  test("Service A delegates to ServiceB with kvp") {
    serviceA.method1("dreams")

    val captor = ArgumentCaptor.forClass(classOf[String])

    Mockito.verify(serviceA.serviceB).method2("dreams-once", "dreams-again")

    Mockito.verify(serviceA.serviceB).method3(captor.capture())

    assert(captor.getValue == "dreams")
  }

  test("Service A delegates to ServiceB with kvp which is captured in this test") {

    serviceA.method1("dreams")

    val captor2 = ArgumentCaptor.forClass(classOf[java.util.Map[String, String]])

    Mockito.verify(serviceA.serviceB).method4(captor2.capture())

    val map: java.util.Map[String, String] = captor2.getValue

    assert(map("key") == "dreams")
  }

  test("Service A delegates to ServiceB with kvp which is captured in this test again") {

    serviceA.method1("dreams")

    val captor3 = ArgumentCaptor.forClass(classOf[java.util.Map[String, String]])

    Mockito.verify(serviceA.serviceB).method5(Matchers.eq("dreams"), captor3.capture())

    assert(captor3.getValue()("key") == "dreams")
  }

}
