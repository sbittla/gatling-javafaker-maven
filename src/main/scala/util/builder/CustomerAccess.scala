package util.builder

import io.gatling.core.Predef.{ElFileBody, StringBody, exec}
import io.gatling.core.structure.ChainBuilder
import io.gatling.core.Predef._
import io.gatling.http.Predef._
trait CustomerAccess  {

  val userFacade = "/users"

  val headers  = Map(
    HttpHeaderNames.Accept -> HttpHeaderValues.ApplicationJson,
    HttpHeaderNames.ContentType -> HttpHeaderValues.ApplicationJson,
    HttpHeaderNames.UserAgent -> "Gatling User"
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
