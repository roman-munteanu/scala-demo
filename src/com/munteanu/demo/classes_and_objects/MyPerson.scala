package com.munteanu.demo.classes_and_objects

/**
 * Created by romunteanu on 7/24/2015.
 */
class MyPerson {
  private var privateFirstName: String = ""
  private var privateLastName: String = ""

  def firstName = privateFirstName
  def lastName = privateLastName

  // auxiliary constructor
  def this(fullName: String) {
    this()
    val arr = fullName.split(' ')
    privateFirstName = arr(0)
    privateLastName = arr(1)
  }

  override def toString = s"MyPerson(firstName=$firstName, lastName=$lastName)"
}
