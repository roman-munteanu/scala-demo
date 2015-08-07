package com.munteanu.demo.abstract_members

/**
 * Created by romunteanu on 8/7/2015.
 */
object MainAbstractTypes {
  def main(args: Array[String]): Unit = {

    class Food
    abstract class Animal {
      type SuitableFood <: Food
      def eat(food: SuitableFood)
    }

    class Grass extends Food
    class Cow extends Animal {
      type SuitableFood = Grass
      override def eat(food: Grass) {}
    }

    class Fish extends Food
    val betty: Animal = new Cow
//    betty.eat(new Fish) // won't compile

    // refinement type (instead of implementing AnimalsThatEatGrass for every class)
    class Pasture {
      var animals: List[ {type SuitableFood = Grass} ] = Nil
    }

    object MyDirection extends Enumeration {
      type MyDirection = Value
      val North = Value(1, "North")
      val East  = Value(2, "East")
      val South = Value(3, "South")
      val West  = Value (4, "West")
    }

    for (d <- MyDirection.values) {
      println(s"${d.id}: $d")
    }

    import MyDirection._
    def whereToGo(d: MyDirection) = d match {
      case North => println("The only way to go")
      case _ => println("No way")
    }
    whereToGo(South)
    whereToGo(North)
  }
}
