package util.builder

import io.gatling.core.Predef.{ElFileBody, StringBody, exec}
import io.gatling.core.structure.ChainBuilder
import io.gatling.core.Predef._
import io.gatling.http.Predef._
trait CustomerAccess  {

  val userFacade = "/users"

  val headers: Map[String, String] = Map(
    "Content-Type" -> "application/json"//,
    //"Authorization" -> "Bearer your-token-here",
    //"Accept" -> "application/json",
    //"User-Agent" -> "Scala HTTP Client"
  )

  def createUserWithJSONBody(requestName:String="POST createUser", responseCode:Int, fileName: String) = {
    exec(http(requestName)
      .post(userFacade + "/add/")
      .headers(headers)
      .body(ElFileBody(fileName)).asJson
      .check(status.is(responseCode))
    )
  }

  def getUserbyId(requestName:String="POST getUser", responseCode:Int, userId: Number) = {
    exec(http(requestName)
      .get(userFacade + s"/$userId")
      .headers(headers)
      .check(status.is(responseCode)))
  }

}
