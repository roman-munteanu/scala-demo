package com.munteanu.demo.objects

/**
 * Created by romunteanu on 7/3/2015.
 */
object TrafficLightColor extends Enumeration {
  type TrafficLightColor = Value
//  val Red, Yellow, Green = Value

  val Red = Value(0, "Stop")
  val Yellow = Value(10) // default name is "Yellow"
  val Green = Value("Go") // ID is 11
}
