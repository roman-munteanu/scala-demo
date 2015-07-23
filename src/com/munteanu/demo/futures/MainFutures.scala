package com.munteanu.demo.futures

import scala.concurrent.Future
import scala.util.Random
import scala.util.{Success, Failure}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

/**
 * Created by romunteanu on 7/23/2015.
 */
object MainFutures {
  def main(args: Array[String]): Unit = {

    type CoffeeBeans = String
    type GroundCoffee = String
    type Milk = String
    type FrothedMilk = String
    type Espresso = String
    type Cappuccino = String

    case class Water(temperature: Int)

    def grind(beans: CoffeeBeans): Future[GroundCoffee] = Future {
      println("started grinding...")
      Thread.sleep(Random.nextInt(2000))
      println("finished grinding...")
      s"ground coffee of $beans"
    }

    // heatWater
    def heatWater(tempValue: Int): Future[Water] = Future {
      println("started heating water...")
      Thread.sleep(Random.nextInt(2000))
      println(s"finished heating water to the temperature $tempValue...")
      Water(temperature = tempValue).copy()
    }

    // frothMilk
    def frothMilk(milk: Milk): Future[FrothedMilk] = Future {
      println("started frothing milk...")
      Thread.sleep(Random.nextInt(2000))
      println("finished frothing milk...")
      s"frothed milk: $milk"
    }

    // brew
    def brew(groundCoffee: GroundCoffee, heatedWater: Water): Future[Espresso] = Future {
      println("started preparing Espresso...")
      Thread.sleep(Random.nextInt(2000))
      println("finished preparing Espresso...")
      s"Espresso"
    }

    def combine(espresso: Espresso, frothedMilk: FrothedMilk): Future[Cappuccino] = Future {
      println("started preparing Cappuccino...")
      Thread.sleep(Random.nextInt(2000))
      println("finished preparing Cappuccino...")
      s"Cappuccino"
    }

    // TODO Future[Future[Cappuccino]]
//    def prepareCappuccino(): Future[Cappuccino] = Future {
//      for {
//        groundCoffee <- grind("Arabic beans")
//        heatedWater <- heatWater(85)
//        frothedMilk <- frothMilk("some milk")
//        espresso <- brew(groundCoffee, heatedWater)
//      } yield combine(espresso, frothedMilk)
//    }
//    prepareCappuccino().onSuccess { case cappuccino => println(s"$cappuccino has been prepared.") }

    grind("Turkish beans").onSuccess { case ground => println(s"OK, ground coffee with $ground") }

    grind("Arabic beans").onComplete {
      case Success(ground) => println(s"got my $ground")
      case Failure(ex) => println("Need some reparation here")
    }
  }
}
