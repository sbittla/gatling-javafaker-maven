package util.datagen

import com.github.javafaker.Faker

import scala.util.Random

trait Company {
  private val companyFaker = new Faker()

  // Predefined list of company departments        // Predefined list of company departments
  val departments = List(
    "Engineering",
    "Human Resources",
    "Finance",
    "Marketing",
    "Sales",
    "Operations",
    "Customer Support",
    "Research and Development",
    "Legal",
    "IT")

  val companyFeeder:Iterator[Map[String, Any]] = {Iterator.continually(
    Map (
      "department_Feeder" -> Random.shuffle(departments).head,
      "company_name_Feeder" -> companyFaker.company().name(),
      "title_Feeder" -> companyFaker.job().title()
    )
  )}
}
