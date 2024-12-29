package util.common

import java.util.{Calendar, Date}

trait GenericMethods {

  def getFutureDateInMMYYFormat(): String = {
    // Get the current date
    val calendar: Calendar = Calendar.getInstance

    // Add a random number of months between 1 and 60 (up to 5 years)
    val additionalMonths: Int = bankFaker.number.numberBetween(1, 60)
    calendar.add(Calendar.MONTH, additionalMonths)

    // Format the date as MM/yy
    val futureDate: Date = calendar.getTime
    val dateFormat: Date = new Nothing("MM/yy")
    val expiryDate: String = dateFormat.formatted(futureDate.toString)

    return expiryDate
  }
}
