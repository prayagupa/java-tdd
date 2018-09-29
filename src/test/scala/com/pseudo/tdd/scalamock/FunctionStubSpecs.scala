package com.pseudo.tdd.scalamock

import org.scalamock.scalatest.MockFactory
import org.scalatest.{FunSuite, Matchers}

object Shipping {
  def shipItemsForStore(storeId: String, f: String => Seq[String]): Seq[String] = {
    f.apply(storeId).map(item => s"shipping $item")
  }
}

class FunctionStubSpecs extends FunSuite with MockFactory with Matchers {

  test("ships items") {

    val fn = stubFunction[String, Seq[String]]

    fn.when("store-888").returns(Seq("item1", "item2"))

    val shippedNotifications = Shipping.shipItemsForStore("store-888", fn)

    shippedNotifications shouldBe Seq("shipping item1", "shipping item2")
  }


  import java.util.Base64

  object Api {

    def getActionAsBase64(fileBytesFn: (String, String, String) => Array[Byte],
                          appName: String,
                          taskType: String,
                          taskName: String): String = {

      val encoded = new String(Base64.getEncoder
        .encode(fileBytesFn(appName, taskName, taskName)))
        .replace("\n", "")
        .replace("\r", "")

      encoded
    }
  }

  test("test a function") {

    val mock = (_: String, _: String, _: String) => "prayagupd".getBytes()

    val d = Api.getActionAsBase64(mock, "any app name", "taskName", "taskName")

    assert(d == "cHJheWFndXBk")
  }

  def fn = new Function3[String, String, String, Array[Byte]] {
    override def apply(v1: String, v2: String, v3: String) = Array.emptyByteArray
  }

  test("test a function II") {

    val mock = stubFunction[String, String, String, Array[Byte]]
    mock.when(*, *, *).returns("prayagupd".getBytes())

    val d = Api.getActionAsBase64(mock, "any appName", "any taskType", "any taskName")

    assert(d == "cHJheWFndXBk")
  }

}
