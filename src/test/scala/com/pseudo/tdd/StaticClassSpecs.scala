package com.pseudo.tdd

import org.junit.runner.RunWith
import org.junit.{Assert, Test}
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

/**
  * Created by prayagupd
  * on 11/1/16.
  */

@RunWith(classOf[PowerMockRunner])
@PrepareForTest(Array(classOf[StaticClass]))
class StaticClassSpecs {

  @Test
  def tesSomething() {
    PowerMockito.mockStatic(classOf[StaticClass])
    Mockito when StaticClass.staticMethod() thenReturn "nihilist cat"

    Assert.assertEquals(StaticClass.staticMethod(), "nihilist cat")
  }

  @Test(expected=classOf[Exception])
  def testException() {
    PowerMockito.mockStatic(classOf[StaticClass])
    Mockito when StaticClass.staticMethod() thenThrow new Exception("upd")

    StaticClass.staticMethod()
  }
}
