package com.pseudo.tdd.scalamock

import java.util.UUID

import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

import scala.concurrent.{Await, Future}

class ScalaStubTrait extends FlatSpec with MockFactory {

  it should "response employee namee" in {
    val extStub = stub[Ext]
    (extStub.getPayloadExt _).when(*, *).returns(Future.successful("employee name"))
    val clientImpl = new ClientImpl(extStub)

    import scala.concurrent.ExecutionContext.Implicits.global
    import scala.concurrent.duration._
    val emp = Await.result(clientImpl.getPayload("whatever", UUID.randomUUID()), 1 seconds)
    assert(emp.name == "employee name")
  }

}


import scala.concurrent.{ExecutionContext, Future}

final case class Employeee(name: String)

trait Client {
  def getPayload(userUri: String,
                 uuid: UUID)(implicit executionContext: ExecutionContext): Future[Employeee]
}

class ClientImpl(ext: Ext) extends Client {
  override def getPayload(userUri: String, uuid: UUID)(implicit executionContext: ExecutionContext): Future[Employeee] = {
    val extCall = ext.getPayloadExt(Map.empty, uuid)
    extCall.map(name => Employeee(name))
  }
}

class Ext {
  def getPayloadExt(headers: Map[String, String], uuid: UUID): Future[String] = ???
}

//
//class MyService(client: Client) {
//
//  def getStuff(implicit executionContext: ExecutionContext): Future[String] = {
//    client.getPayload("some uri", UUID.randomUUID()).map(_.name)
//  }
//
//}
//
////it should "response employee name" in {
////
////    val clientStub: Client = stub[Client]
////    (clientStub.getPayload _).when(*, *).returns(Future.successful(Employeee("test")))
////
////    val subejct = new MyService(clientStub)
////    import scala.concurrent.ExecutionContext.Implicits.global
////    import scala.concurrent.duration._
////    val name = Await.result(subejct.getStuff, 1 seconds)
////    assert(name == "test")
////  }