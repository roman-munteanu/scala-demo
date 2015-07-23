package com.munteanu.demo

/**
 * Created by romunteanu on 7/2/2015.
 */
class Person {

  private var privateAge: Int = 0
  private var name: String = null
  // in this case name won't be accessable from another person
  // only methods of this class can access this field
//  private[this] var name: String = null

  def age = privateAge
  def age_= (newValue: Int) {
    if (newValue > privateAge) privateAge = newValue
  }

//  def comesBefore(anotherPerson: Person): Boolean = {
//    name < anotherPerson.name
//  }
  def comesBefore(anotherPerson: Person) = name < anotherPerson.name
}
