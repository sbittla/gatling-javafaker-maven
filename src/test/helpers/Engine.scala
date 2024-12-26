
import com.typesafe.config.ConfigFactory
import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object Engine extends App {
  //def main(args: Array[String]): Unit = {
    val gatlingConfig = ConfigFactory.load("gatling.conf")

    val gatlingProperties = new GatlingPropertiesBuilder()
      .resourcesDirectory("./src/test/resources")
      .resultsDirectory("./target/gatling/results")
      .binariesDirectory("./target/classes")
      .simulationClass("UserSimulation");
    Gatling.fromMap(gatlingProperties.build)
  //}

}