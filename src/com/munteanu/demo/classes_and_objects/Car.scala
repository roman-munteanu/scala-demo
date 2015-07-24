package com.munteanu.demo.classes_and_objects

/**
 * Created by romunteanu on 7/24/2015.
 */
class Car {
  private var privateManufacturer: String = ""
  private var privateModel: String = ""
  private var privateYear: Int = -1
  var licensePlate: String = ""

  def manufacturer = privateManufacturer
  def model = privateModel
  def year = privateYear
//  def year_= (newYear: Int): Unit = {
//    privateYear = newYear
//  }

  def this(manufacturer: String, model: String) {
    this()
    this.privateManufacturer = manufacturer
    this.privateModel = model
  }

  def this(manufacturer: String, model: String, year: Int = -1) {
    this(manufacturer, model)
    this.privateYear = year
  }

  def this(manufacturer: String, model: String, year: Int, licensePlate: String) {
    this(manufacturer, model, year)
    this.licensePlate = licensePlate
  }

  override def toString = s"Car(licensePlate: $licensePlate, manufacturer=$manufacturer, model=$model, year=$year)"
}
