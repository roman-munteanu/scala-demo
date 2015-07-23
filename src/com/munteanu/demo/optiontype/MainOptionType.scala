package com.munteanu.demo.optiontype

/**
 * Created by romunteanu on 7/17/2015.
 */
object MainOptionType {
  def main(args: Array[String]): Unit = {

    /*
    class UserRepository {
      private val users = Map(1 -> User(1, "Alice", "Parker", 31, Some("female")),
                      2 -> User(2, "Tom", "Green", 35, None)
                    )
      def findById(id: Int): Option[User] = users.get(id)
      def findAll = users.values
    }
    */

    // access
    val userRepository = new UserRepository
    val user1 = userRepository.findById(1)
    if (user1.isDefined)
        println(user1.get.firstName + " " + user1.get.lastName)

    // default value
    val users: Iterable[User] = userRepository.findAll
    users.foreach(user => println(user.gender.getOrElse("not specified")))

    println("users with common age:")
    val usersList = users.map(user => user.copy(age = 27))
    usersList.foreach(user => println(user))

//    println("usersData:")
//    var usersData: Iterable[User] = userRepository.findAll
//    usersData.map(user => user.copy(age = 26))
//    usersData.foreach(user => println(user))

    // matching
    val user2 = User(3, "Johanna", "Lunnen", 30, None)
    user2.gender match {
      case Some(gender) => println("gender: " + gender)
      case None => println("match gender: not specified")
    }

    // foreach
    userRepository.findById(2).foreach(user => println(user.gender))

    // map and flatMap
    val gender1 = userRepository.findById(1).map(_.gender)
    println("gender1: " + gender1)
    val gender2 = userRepository.findById(1).flatMap(_.gender)
    println("gender1: " + gender2)

    // a list of options
    val names: List[Option[String]] = List(Some("Alice"), None, Some("Mike"))
    val mappedNames = names.map(_.map(_.toUpperCase))
    println("mappedNames: " + mappedNames)

    val flatMappedNames = names.flatMap(_.map(name => name.toUpperCase))
    println("flatMappedNames: " + flatMappedNames)
  }
}
