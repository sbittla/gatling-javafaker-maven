package util.datagen

import com.github.javafaker.Faker
import io.gatling.core.feeder.FeederStrategy.Random
import util.common.GenericMethods
import scala.util.Random


trait Bank extends GenericMethods {
  private val bankFaker = new Faker()

  // Predefined list of card types
  val cardTypes = List("Visa", "MasterCard", "American Express", "Discover")

  val bankFeeder:Iterator[Map[String, Any]] = {Iterator.continually(
    Map (
      "cardExpire_Feeder" -> getFutureDateInMMYYFormat(),
        "cardNumber_Feeder" -> bankFaker.finance().creditCard(),
        "cardType_Feeder" -> Random.shuffle(cardTypes).head,
        "currency_Feeder" -> bankFaker.currency().code(),
        "iban_Feeder" -> bankFaker.finance().iban()
    ))
  }

}
