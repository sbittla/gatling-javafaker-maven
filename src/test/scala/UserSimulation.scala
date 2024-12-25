
import com.typesafe.config.{Config, ConfigFactory}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import util.DataGenerator
import services.UserService

class UserSimulation extends Simulation {

  val envConf = ConfigFactory.load(“src/resources/config/UserSimulation.conf”)
  val baseURL = envConf.getString("baseURL")
  get
  //val baseURL = envConf.getString("")

  val httpProtocol = http.baseUrl(baseURL)

  val scn = scenario("User Scenario")
    .exec(UserService.createUser(DataGenerator.generateName(), DataGenerator.generateEmail()))
    .exec(UserService.getUserById(1))

  setUp(
    scn.inject(atOnceUsers(10))
  ).protocols(httpProtocol)
}