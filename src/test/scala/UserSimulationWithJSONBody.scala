
import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import services.UserService
import util.builder.CustomerAccess
import util.datagen.{Address, Bank, Company, Crypto, Customer, Hair, Location}


class UserSimulationWithJSONBody
  extends Simulation
    with CustomerAccess
    with Customer
    with Address
    with Bank
    with Company
    with Crypto
    with Hair
    with Location {

  val envConf = ConfigFactory.load("resources/config/UserConfig.conf")
  val baseURL = envConf.getString("baseURL")
  val userJSONBody: String = envConf.getString("addUserBody")

  val httpProtocol = http.baseUrl(baseURL)

  val userScenario = scenario("User Scenario")
    .feed(addressFeeder)
    .feed(customerFeeder)
    .feed(bankFeeder)
    .feed(companyFeeder)
    .feed(cryptoFeeder)
    .feed(hairFeeder)
    .feed(locationFeeder)
    .exec(createUserWithJSONBody("POST addUser", 201, userJSONBody))
    .exec(getUserbyId("GET /user", 200, 1))

  setUp(
    userScenario.inject(atOnceUsers(1))
  ).protocols(httpProtocol)
}