package com.pseudo.tdd

import org.scalatest.{FunSuite, Matchers}

class MaybeMonadSpecs extends FunSuite with Matchers {

  test("map on Maybe Just") {
    val data = Some("initial-data")

    val morphism = data.map(x => List.fill(2)(x)).orElse(Some(List(100, 200)))

    morphism shouldBe Some(List("initial-data", "initial-data"))
  }

  test("map on Maybe None") {
    val data = Option.empty[String]

    val morphism1 = data.map(x => List.fill(2)(x)).orElse(Some(List(100, 200)))

    morphism1 shouldBe Some(List(100, 200))

    val morphism2 : Option[List[String]] = data.map(x => List.fill(2)(x)).orElse(Some(List("100", "200")))

    morphism2 shouldBe Some(List("100", "200"))
  }

  test("fold on Maybe Just") {
    val data = Some("initial-data")

    val morphism = data.fold(List("100", "200"))(x => List.fill(2)(x))

    morphism shouldBe List("initial-data", "initial-data")
  }

  test("fold on Maybe None") {
    val morphism = Option.empty[String].fold(List("100", "200"))(x => List.fill(2)(x))

    morphism shouldBe List("100", "200")
  }
}
