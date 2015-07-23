package com.munteanu.demo.objects

import com.munteanu.demo.objects.TrafficLightColor._

/**
 * Created by romunteanu on 7/3/2015.
 */
object DemoObjects {
  def main(args: Array[String]): Unit = {

    val myAccount = new MyAccount
    myAccount.deposit(1.75)
    println(myAccount)

    val anotherAccount = new MyAccount
    println(anotherAccount)

    val map = Map("open" -> DoNothingAction, "save" -> DoNothingAction)
    for ((actionName, actionObj) <- map) {
      actionObj.redo()
      actionObj.undo()
    }

    def doWhat(color: TrafficLightColor) = {
      if (color == Red) {
        "stop"
      } else if (color == Yellow) {
        "attention"
      } else if (color == Green) {
        "go"
      }
    }
    println("doWhat: " + doWhat(Green))

    for (c <- TrafficLightColor.values) {
      println(c.id + ": " + c)
    }
  }
}
