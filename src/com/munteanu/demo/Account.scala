package com.munteanu.demo

import java.util.Date

/**
 * Created by romunteanu on 7/3/2015.
 */
class Account(val username: String, val email: String, var dateOfBirth: Date = new Date) {

  override def toString = s"Account($username, $email, $dateOfBirth)"
}
