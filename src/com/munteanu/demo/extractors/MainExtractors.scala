package com.munteanu.demo.extractors

/**
 * Created by romunteanu on 9/15/2015.
 */
object MainExtractors {
  def main(args: Array[String]) = {

//    case class EMail(user: String, domain: String)

    object EMail {
      def apply(user: String, domain: String) = user + "@" + domain
      def unapply(str: String): Option[(String, String)] = {
        if (Option(str).getOrElse("").isEmpty)
          return None
        val parts = str.trim split "@"
        if (parts.length == 2) Some((parts(0), parts(1))) else None
      }
    }

    def isValidEmail(emailAddress: String): Boolean = emailAddress match {
      case EMail(user, domain) => true
      case _ => false
    }

//    println(isValidEmail("roman.muntyanu@yahoo.com"))
//    println(isValidEmail("  "))
//    println(isValidEmail("  @ "))
//    println(isValidEmail(null))

    object UpperCase {
      def unapply(s: String): Boolean = s.toUpperCase == s
    }

    def isUpperCase(str: String): Boolean = str match {
      case s @ UpperCase() => true
      case _ => false
    }

//    println(isUpperCase("kiriLL"))
//    println(isUpperCase("KIRILL"))

    // variable arguments extractors
    object Domain {
      def apply(parts: String*): String = parts.reverse.mkString(".")
      def unapplySeq(whole: String): Option[Seq[String]] = {
        if (whole.nonEmpty)
          Some(whole.split("\\.").reverse)
        else
          None
      }
    }

    def isEmailOnComDomain(email: String): Boolean = email match {
      case EMail(user, Domain("com", _*)) => true
      case _ => false
    }

    println(isEmailOnComDomain("kirill@java.sun.com"))
    println(isEmailOnComDomain("kirill@java.sun.org"))

  }
}
