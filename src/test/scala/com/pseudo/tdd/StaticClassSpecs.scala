package com.pseudo.tdd

import org.junit.{Assert, Test}
import org.junit.runner.RunWith
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
  def something() {
    PowerMockito.mockStatic(classOf[StaticClass])
    Mockito.when(StaticClass.staticMethod()).thenReturn("nihilist cat")

    Assert.assertEquals(StaticClass.staticMethod(), "nihilist cat")
  }
}
