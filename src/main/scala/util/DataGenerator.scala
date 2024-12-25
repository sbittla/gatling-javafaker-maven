package util

import com.github.javafaker.Faker

object DataGenerator {
  private val faker = new Faker()

  def generateName(): String = faker.name().fullName()

  def generateEmail(): String = faker.internet().emailAddress()
}