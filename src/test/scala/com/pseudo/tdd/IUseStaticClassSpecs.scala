package com.pseudo.tdd

import org.powermock.core.classloader.annotations.PrepareForTest
import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.{Matchers, Mockito}
import org.powermock.api.mockito.PowerMockito
import org.powermock.modules.junit4.PowerMockRunner

/**
  * Created by prayagupd
  * on 12/5/16.
  */

@RunWith(classOf[PowerMockRunner])
@PrepareForTest(Array(classOf[StaticClass]))
class IUseStaticClassSpecs {

  val iUseStaticClass = new IUseStaticClass

  @Test
  def calls_Static_Method(): Unit = {
    //given
    PowerMockito.mockStatic(classOf[StaticClass])

    //when
    iUseStaticClass.iUseStaticClass("prayagupd")

    //then
    PowerMockito.verifyStatic(Mockito.times(1))
    StaticClass.staticMethod(Matchers.eq("prayagupd"))
    //StaticClass.staticMethod("something-as-prayagupd")
  }
}
