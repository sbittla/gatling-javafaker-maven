package util

import com.github.javafaker.Faker

object DataGenerator {
  private val faker = new Faker()

  def generateFirstName(): String = faker.name().firstName()
  def generateLastName(): String = faker.name().lastName()
  def generateEmail(): String = faker.internet().emailAddress()
}