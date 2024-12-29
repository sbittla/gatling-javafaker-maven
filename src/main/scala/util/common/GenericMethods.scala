package util.common

import com.github.javafaker.Faker

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.{Calendar, Date}

trait GenericMethods {

  def getFutureDateInMMYYFormat(): String = {
    // Get the current date
    val calendar: Calendar = Calendar.getInstance

    val faker = new Faker()
/*    // Add a random number of months between 1 and 60 (up to 5 years)
    val additionalMonths: Int = faker.number.numberBetween(1, 60)
    calendar.add(Calendar.MONTH, additionalMonths)

    // Format the date as MM/yy
    val futureDate: Date = calendar.getTime
    val dateFormat: Date = new Date("MM/yy")
    val expiryDate: String = dateFormat.formatted(futureDate.toString)*/

    // Generate a random number of months (e.g., 1 to 60 months from now)
    val futureMonths = faker.number().numberBetween(1, 60)

    // Calculate future date
    val futureDate = LocalDate.now().plusMonths(futureMonths)

    // Format the date as yy/MM
    val formatter = DateTimeFormatter.ofPattern("yy/MM")
    val formattedDate = futureDate.format(formatter)

    return formattedDate
  }
}
