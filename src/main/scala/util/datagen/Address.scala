package util.datagen

import com.github.javafaker.Faker

trait Address {

  private val addressFaker = new Faker()

  val addressFeeder:Iterator[Map[String, Any]] = {Iterator.continually(
    Map (
       "address_Feeder" -> addressFaker.address().streetAddress(),
        "city_Feeder" -> addressFaker.address().city(),
        "state_Feeder" -> addressFaker.address().state(),
        "stateCode_Feeder" -> addressFaker.address().stateAbbr(),
        "postalCode_Feeder" -> addressFaker.address().zipCode(),
        "country_Feeder" -> addressFaker.address().country(),
        "lat_Feeder" -> addressFaker.address().latitude(),
        "lng_Feeder" -> addressFaker.address().longitude()
    )
  )}
}
