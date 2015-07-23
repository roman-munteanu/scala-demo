package com.munteanu.demo.dynamic_types

/**
 * Created by romunteanu on 7/23/2015.
 */
object MainDynamic extends App {

  /*
  magic methods:
  applyDynamic
  applyDynamicNamed
  selectDynamic
  updateDynamic
  */

  val myDynamicObj = new MyDynamicClass
  println(myDynamicObj.randomMethodName("arg1"))

  myDynamicObj.foobar(foo = "bar", buzz = true, arg3 = 1)

  var myDynamicHM = new MyDynamicHashMap
  println(myDynamicHM.supposedToBeAKey)
  myDynamicHM.supposedToBeAKey = "aCustomValue"
  println(myDynamicHM.supposedToBeAKey)
}
