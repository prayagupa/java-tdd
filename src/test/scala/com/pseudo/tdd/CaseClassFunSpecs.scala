package com.pseudo.tdd

import java.text.SimpleDateFormat

import com.google.gson.{JsonObject, JsonParser}
import org.scalatest.FunSpec

import scala.util.{Failure, Success, Try}

/**
  * Created by prayagupd
  * on 2/19/17.
  */

class CaseClassFunSpecs extends FunSpec {

  describe("case class conversion") {

    it("converts json to case class with empty age") {

      case class person(name: String, age: Option[Long])

      val parser = new JsonParser()

      //PERSON 2
      val json = parser.parse("""{"name":"xyz"}""").getAsJsonObject()

      val name = json.get("name").getAsString.toLowerCase

      val personInstance = new person(json.get("name").getAsString.toLowerCase,
        Option(json.get("age")).map(_.getAsLong))

      println(personInstance)

      assert(personInstance.name == "xyz")
      assert(personInstance.age == None)
    }

    it("converts json to case class with non-empty age") {

      case class person(name: String, age: Option[Long])

      val parser = new JsonParser()

      //PERSON 2
      val json = parser.parse("""{"name":"xyz", "age" : 28}""").getAsJsonObject()

      val name = json.get("name").getAsString.toLowerCase

      val personInstance = new person(json.get("name").getAsString.toLowerCase,
        Option(json.get("age")).map(_.getAsLong))

      println(personInstance)

      assert(personInstance.name == "xyz")
      assert(personInstance.age == Some(28))
      assert(personInstance.age.get == 28) //.get gives you the value
    }

    it("converts to case class") {

      case class person(name: String, age: Long)

      val parser = new JsonParser();

      //PERSON 2
      val json = parser.parse("""{"name":"xyz"}""").getAsJsonObject()

      val name = json.get("name").getAsString.toLowerCase

      val personInstance = new person(json.get("name").getAsString.toLowerCase,
        Option(json.get("age")).map(_.getAsLong).getOrElse(0l))

      println(personInstance)

      assert(personInstance.name == "xyz")
      assert(personInstance.age == 0l)
    }

    it("converts gson with name/age to case class") {

      case class person(name: String, age: Long)

      val parser = new JsonParser()

      //case 1
      val jsonObject: JsonObject = parser.parse("""{"name":"xyz"}""").getAsJsonObject

      val name = jsonObject.get("name").getAsString.toLowerCase

      val age = jsonObject.get("age") match {
        case null => None
        case value => Some(value.getAsLong)
      }

      val person1 = new person(name, age.getOrElse(0l))

      println(person1)

      assert(person1.name == "xyz")
      assert(person1.age == 0)

      //case 2
      val jsonObject2: JsonObject = parser.parse("""{"name":"xyz", "age" : 28}""").getAsJsonObject

      val name2 = jsonObject2.get("name").getAsString.toLowerCase
      val age2: Option[Long] = jsonObject2.get("age") match {
        case null => None
        case value => Some(value.getAsLong)
      }

      val person2 = new person(name2, age2.getOrElse(0l))

      println(person2)

      assert(person2.name == "xyz")
      assert(person2.age == 28)
    }

  }

  describe("case class modify") {
    it("modifies abstract case class member") {

      object Item {
        def apply(itemId: String, itemName: String): Item = new Item(itemId.toLowerCase, itemName) {}
      }

      abstract case class Item private(val itemId: String, itemName: String)

      val item1 = Item("SKU-ONE", "Shirts")

      assert(item1.itemId == "sku-one")
      assert(item1.itemName == "Shirts")
    }

    it("modifies case class member which if var") {

      case class Item(var itemId: String, itemName: String) {
        itemId = itemId.toLowerCase()
      }

      val item1 = Item("SKU-ONE", "Shirts")

      assert(item1.itemId == "sku-one")
      assert(item1.itemName == "Shirts")
    }

    it("matching specs") {
      trait Node {
        val label: Int

      }
      case class BranchNode(override val label: Int, left: Option[Node], right: Option[Node]) extends Node
      case class LeafNode(override val label: Int) extends Node

      case class IWillBreakYou(override val label: Int) extends Node

      def printTree(aTree: Option[Node]): Unit = aTree match {
        case None => print(".")
        case Some(LeafNode(label)) => print(label)
        case Some(BranchNode(label, left, right)) => "{" + printTree(left) + label + printTree(right) + "}"
        case _ => println("do nothing")
      }

      val leftNode = Option(LeafNode(2))
      val rightNode = Option(LeafNode(3))
      val root = BranchNode(1, leftNode, rightNode)

      printTree(Option(root))

      //printTree(Option(IWillBreakYou(2)))

      val newRoot = root.copy(right = None)
      assert(newRoot.label == 1)
      assert(newRoot.left == leftNode)
      assert(newRoot.right == None)

      //      List(leftNode, rightNode).map {
      //        case Some(x) => println(x)
      //        case Some(x, y, z) => println(x)
      //      }
    }

  }
}
