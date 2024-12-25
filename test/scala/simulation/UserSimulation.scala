package simulation

import config.Config
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import service.UserService
import util.DataGenerator

class UserSimulation extends Simulation {

  val httpProtocol = http.baseUrl(Config.baseUrl)

  val scn = scenario("User Scenario")
    .exec(UserService.createUser(DataGenerator.generateName(), DataGenerator.generateEmail()))
    .exec(UserService.getUserById(1))

  setUp(
    scn.inject(atOnceUsers(10))
  ).protocols(httpProtocol)
}