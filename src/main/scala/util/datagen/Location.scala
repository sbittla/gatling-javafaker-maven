package util.datagen

import com.github.javafaker.Faker

trait Location {
  private val locationFaker = new Faker()
  val locationFeeder:Iterator[Map[String, Any]] = {Iterator.continually(
    Map (
        "lat_Feeder" -> locationFaker.address().latitude(),
        "lng_Feeder}" -> locationFaker.address().longitude()
    )
  )}
}
