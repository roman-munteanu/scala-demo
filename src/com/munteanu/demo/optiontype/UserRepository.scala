package com.munteanu.demo.optiontype

/**
 * Created by romunteanu on 7/17/2015.
 */
class UserRepository {
  private val users = Map(1 -> User(1, "Alice", "Parker", 31, Some("female")),
                  2 -> User(2, "Tom", "Green", 35, None)
                )
  def findById(id: Int): Option[User] = users.get(id)
  def findAll = users.values
}
