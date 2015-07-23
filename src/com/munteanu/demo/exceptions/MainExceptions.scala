package com.munteanu.demo.exceptions

import java.io.FileNotFoundException

import scala.io.Source
import java.net.{MalformedURLException, URL}

import scala.util.{Try, Success, Failure}


/**
 * Created by romunteanu on 7/20/2015.
 */
object MainExceptions extends App {

  val ghUrl = "http://sapphire-gemheap.rhcloud.com"

  def parseURL(url: String): Try[URL] = Try(new URL(url))

  def getUrlContent(url: String): Try[Iterator[String]] = for {
    url <- parseURL(url)
    conn <- Try(url.openConnection())
    is <- Try(conn.getInputStream)
    source = Source.fromInputStream(is)
  } yield source.getLines()

  def showUrlContent(url: String) = {
    getUrlContent(url) match {
      case Success(lines) => lines.foreach(println)
      case Failure(ex) => println(s"Problem rendering URL content: ${ex.getMessage}")
    }
  }

  showUrlContent(ghUrl)

  val content = getUrlContent("garbage") recover {
    case e: FileNotFoundException => Iterator("Requested page does not exist")
    case e: MalformedURLException => Iterator("Please make sure you entered a valid URL")
    case _ => Iterator("An unexpected error has occurred")
  }
  println(content.get.foreach(println))
}
