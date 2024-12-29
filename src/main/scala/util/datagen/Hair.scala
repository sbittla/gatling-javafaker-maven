package util.datagen
import scala.util.Random

trait Hair {

  // Custom list of hair colors
  val hairColors = List(
    "Black", "Brown", "Blonde", "Red", "Gray", "White", "Blue", "Green", "Pink", "Purple"
  )

  // Custom list of hair types
  val hairTypes = List(
    "Straight", "Wavy", "Curly", "Coily", "Bald"
  )

  private def randomizeHairColor():String = Random.shuffle(hairColors).head
  private def randomizeHairTypes():String = Random.shuffle(hairTypes).head

  val addressFeeder:Iterator[Map[String, Any]] = {
    Iterator.continually(
      Map(
        "color_Feeder" -> randomizeHairColor(),
        "type_Feeder" -> randomizeHairTypes()
      ))
  }
}
