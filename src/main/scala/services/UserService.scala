package services

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object UserService {
  def createUser(name: String, email: String) = {
    exec(http("Create User")
      .post("/users")
      .body(StringBody(s"""{ "name": "$name", "email": "$email" }""")).asJson
      .check(status.is(201)))
  }

  def getUserby
}