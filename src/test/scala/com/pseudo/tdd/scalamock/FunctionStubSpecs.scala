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
}
