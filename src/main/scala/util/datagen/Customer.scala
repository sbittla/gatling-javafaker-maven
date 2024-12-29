package util.datagen

import com.github.javafaker.Faker

trait Customer {
  private val customerFaker = new Faker()
  val customerFeeder:Iterator[Map[String, Any]] = {Iterator.continually(
    Map (
        "id_Feeder" ->
        "firstName_Feeder" ->
        "lastName_Feeder" ->
        "maidenName_Feeder" ->
        "age_Feeder" ->
        "gender_Feeder" ->
        "email_Feeder" ->
        "phone_Feeder" ->
        "username_Feeder" ->
        "password_Feeder" ->
        "birthDate_Feeder" ->
        "image_Feeder" ->
        "bloodGroup_Feeder" ->
        "height_Feeder" ->
        "weight_Feeder" ->
        "eyeColor_Feeder" ->
        "ip_Feeder" ->
        "macAddress_Feeder" ->
        "university_Feeder" ->
        "ein_Feeder" ->
        "ssn_Feeder" ->
        "userAgent_Feeder" ->
        "role_Feeder" ->
    )
  )}

}
