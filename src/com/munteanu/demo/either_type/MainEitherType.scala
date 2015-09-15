package com.munteanu.demo.either_type

import scala.util.Failure
import scala.collection.immutable.Range.Inclusive
/**
 * Created by romunteanu on 7/20/2015.
 */
object MainEitherType extends App {

//  println((null :: Nil).isEmpty)
/*
  case class AppInfo(environmentId: String)

  case class SubInfo(productVersionId: String, appInfo: AppInfo)

  val subInfo = SubInfo("pvID", null)

  subInfo.appInfo match {
    case AppInfo(_) =>
    case _ => Failure
  }

  subInfo match {
    case SubInfo(_, app) if app == null => println("failure")
    case _ => println("Success")
  }

  val xs = 58 #:: 43 #:: Stream.empty
  */

//  println("0".toInt)
//  println("1".toInt)
//  println("2".toInt)
//  println(Range(1, 2))

  val numberOfVersions: String = "2"
//  for (i <- Range(1, numberOfVersions.toInt + 1)) println(i)
//  for (i <- 1 until numberOfVersions.toInt) println(i)
//    for (i <- 1 to numberOfVersions.toInt) println(i)

  /*
  case class Plan(name: String)

  val plansList: Option[List[Plan]] = Some(List(Plan("")))

  def validate(plansList: Option[List[Plan]]): Boolean = {
    plansList.nonEmpty && plansList.forall(
      _.forall(p => p.name.nonEmpty)
    )
  }
  println(validate(None))
  println(validate(plansList))
  */

  /*
  case class PVer(name: String)

  def check(PVer: Option[List[PVer]]): Boolean = {
    PVer.forall(
      _.forall(pv => pv.name.trim.nonEmpty)
    )
  }

  println(check(Some(Nil)))
  println(check(None))
  println(check(Some(List(PVer(name = "")))))
  */

  val result = List(None, None, Some(" ")).flatten.mkString(",")
  println(result.isEmpty)


}
