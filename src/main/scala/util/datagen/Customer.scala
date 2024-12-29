package util.datagen

import com.github.javafaker.Faker

import scala.util.Random

trait Customer {
  private val customerFaker = new Faker()

  val customerFeeder:Iterator[Map[String, Any]] = {Iterator.continually(
    Map (
        "id_Feeder" -> Random.between(1,10),
        "firstName_Feeder" -> customerFaker.name().firstName(),
        "lastName_Feeder" -> customerFaker.name().lastName(),
        "maidenName_Feeder" -> customerFaker.name().nameWithMiddle(),
        "age_Feeder" -> String.valueOf(customerFaker.number.numberBetween(18, 90)),
        "gender_Feeder" -> customerFaker.demographic().sex(),
        "email_Feeder" -> customerFaker.internet().emailAddress(),
        "phone_Feeder" -> customerFaker.phoneNumber().phoneNumber(),
        "username_Feeder" -> customerFaker.name().username(),
        "password_Feeder" -> customerFaker.internet().password(),
        "birthDate_Feeder" -> customerFaker.date().birthday(18,90).toString,
        "image_Feeder" -> customerFaker.avatar().image(),
        "bloodGroup_Feeder" -> customerFaker.options().option(
          "A+",
          "A-",
          "B+",
          "B-",
          "O+",
          "O-",
          "AB+",
          "AB-"
        ),
        "height_Feeder" -> customerFaker.number().numberBetween(150, 200).toString.concat("cm"),
        "weight_Feeder" -> customerFaker.number().numberBetween(50, 120).toString.concat("kg"),
        "eyeColor_Feeder" -> customerFaker.options().option(
          "Brown",
          "Blue",
          "Green",
          "Gray",
          "Hazel"
        ),
        "ip_Feeder" -> customerFaker.internet().ipV4Cidr(),
        "macAddress_Feeder" -> customerFaker.internet().macAddress(),
        "university_Feeder" -> customerFaker.university().name(),
        "ein_Feeder" -> customerFaker.idNumber().valid(),
        "ssn_Feeder" -> customerFaker.idNumber().ssnValid(),
        "userAgent_Feeder" -> customerFaker.internet().userAgentAny(),
        "role_Feeder" -> customerFaker.options().option(
          "Admin",
          "User",
          "Editor",
          "Viewer",
          "Moderator"
        )
    )
  )}

}
