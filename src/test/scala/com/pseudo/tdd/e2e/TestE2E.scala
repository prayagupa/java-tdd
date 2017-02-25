package com.pseudo.tdd.e2e

import java.util.Properties

import org.scalatest.{FeatureSpec, GivenWhenThen}
import org.scalatest.prop.TableDrivenPropertyChecks._


/**
  * Created by prayagupd
  * on 2/22/17.
  */

class TestE2E extends FeatureSpec with GivenWhenThen {

  val requestResponse =
    Table(
      ("request", "response"),
      (  "GET",   "GET-something"),
      ( "POST",   "POST-something")
    )

  feature("testMe") {

    forAll (requestResponse) { (givenRequestFromTable: String, expectedResponseFromTable: String) =>

      scenario("for input " + givenRequestFromTable) {

        When("input is " + givenRequestFromTable)
        val output = testMe(input = givenRequestFromTable)

        Then("responseFromTable has something appended to it")
        assert(output == expectedResponseFromTable)
      }
    }
  }

  def testMe(input: String) : String = {
     input + "-something"
  }
}
