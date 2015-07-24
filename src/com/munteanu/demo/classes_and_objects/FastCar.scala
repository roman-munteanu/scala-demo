package com.munteanu.demo.classes_and_objects

/**
 * Created by romunteanu on 7/24/2015.
 */
class FastCar(
  val manufacturer: String,
  val model: String,
  val year: Int = -1,
  var licensePlate: String = "") {

  override def toString = s"FastCar(licensePlate: $licensePlate, manufacturer=$manufacturer, model=$model, year=$year)"
}
