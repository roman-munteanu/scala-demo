package com.munteanu.demo.optiontype

/**
 * Created by romunteanu on 7/17/2015.
 */
case class User(
  id: Int,
  firstName: String,
  lastName: String,
  age: Int,
  gender: Option[String]
)


