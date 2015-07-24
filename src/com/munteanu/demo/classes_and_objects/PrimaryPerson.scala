package com.munteanu.demo.classes_and_objects

/**
 * Created by romunteanu on 7/24/2015.
 * with primary constructor
 */
class PrimaryPerson(fullName: String) {
//  val firstName: String = fullName.split(' ').head
//  val lastName: String = fullName.split(' ').tail.head
  
  val (firstName, lastName) = {
    val arr = fullName.split(' ')
    (arr(0), arr(1))
  }

  override def toString = s"PrimaryPerson(firstName=$firstName, lastName=$lastName)"
}
