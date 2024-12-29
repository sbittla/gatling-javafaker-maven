
import com.typesafe.config.{Config, ConfigFactory}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import util.DataGenerator
import services.UserService

class SimpleUserSimulation extends Simulation {

  val envConf = ConfigFactory.load("resources/config/UserConfig.conf")
  val baseURL = envConf.getString("baseURL")

  val httpProtocol = http.baseUrl(baseURL)

  val scn = scenario("User Scenario")
    .exec(UserService.createUser(DataGenerator.generateFirstName(), DataGenerator.generateLastName(), DataGenerator.generateEmail()))
    .exec(UserService.getUserbyId(1))

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpProtocol)
}