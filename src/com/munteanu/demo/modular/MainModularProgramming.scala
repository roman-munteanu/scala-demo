package com.munteanu.demo.modular

/**
 * Created by romunteanu on 9/18/2015.
 */
object MainModularProgramming {
  def main(args: Array[String]): Unit = {

    abstract class Food(val name: String) {
      override def toString = name
    }

    class Recipe(
      val name: String,
      val ingredients: List[Food],
      val instructions: String
    ) {
      override def toString = name
    }

    object Apple extends Food("Apple")
    object Orange extends Food("Orange")
    object Cream extends Food("Cream")
    object Sugar extends Food("Sugar")

    object FruitSalad extends Recipe(
      name = "Fruit Salad",
      ingredients = List(Apple, Orange, Cream, Sugar),
      instructions = "mix it all together"
    )

    /*
    object SimpleDatabase {
      def allFoods = List(Apple, Orange, Cream, Sugar)
      def allRecipes = List(FruitSalad)
      def foodNamed(name: String): Option[Food] =
        allFoods.find(_.name == name)
    }

    object SimpleBrowser {
      def recipesUsingFood(food: Food): List[Recipe] =
        SimpleDatabase.allRecipes.filter(recipe => recipe.ingredients.contains(food))
    }

    println(SimpleDatabase.foodNamed("Orange").get)
    println(SimpleBrowser.recipesUsingFood(Orange))
    */

    trait FoodCategories {
      case class FoodCategory(name: String, foods: List[Food])
      def allCategories: List[FoodCategory]
    }

    abstract class Database extends FoodCategories {
      val allFoods: List[Food]
      val allRecipes: List[Recipe]
      def foodNamed(name: String): Option[Food] =
        allFoods.find(_.name == name)
    }


//    object SimpleDatabase extends Database {
//      def allFoods = List(Apple, Orange, Cream, Sugar)
//      def allRecipes = List(FruitSalad)
//
//      private var categories = List(
//        FoodCategory("fruits", List(Apple, Orange)),
//        FoodCategory("misc", List(Cream, Sugar))
//      )
//      def allCategories = categories
//    }

    abstract class Browser {
      val database: Database
      def recipesUsing(food: Food) =
        database.allRecipes.filter(recipe =>
          recipe.ingredients.contains(food))
      def displayCategory(category: database.FoodCategory) {
        println(category);
      }
    }

    trait SimpleFoods {
      object Pear extends Food("Pear")
      def allFoods = List(Apple, Pear)
      def allCategories = Nil
    }

    trait SimpleRecipes {
      this: SimpleFoods =>

      object FruitSalad extends Recipe(
        "fruit salad",
        List(Apple, Pear),
        "Mix it all together."
      )

      def allRecipes = List(FruitSalad)
    }

  }
}
