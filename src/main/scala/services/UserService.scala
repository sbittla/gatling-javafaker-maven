package services

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object UserService {
  def createUser(firstName: String, lastName: String,  email: String) = {
    exec(http("Create User")
      .post("/users/add/")
      .body(StringBody(s"""{ "firstName": "$firstName", "lastName": "$lastName", "email": "$email" }""")).asJson
      .check(status.is(201)))
  }

  def getUserbyId(num: Number) = {
    exec(http("Get User")
      .get(s"/users/$num"))
  }

}