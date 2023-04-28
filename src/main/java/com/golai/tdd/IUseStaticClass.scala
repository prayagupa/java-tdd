package com.golai.tdd

/**
  * Created by prayagupd
  * on 12/5/16.
  */

class IUseStaticClass {

  def iUseStaticClass(name: String): Unit ={
    StaticClass.staticMethod(name)
    EvenMoreStaticClass.staticMethod()
    System.setProperty("name", name)
  }
}
