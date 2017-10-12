import org.junit.Test

class MyDateTest {

  private val startOfYear = MyDate(2017, 1, 1)
  private val endOfYear = MyDate(2017, 12, 31)
  private val solstice = MyDate(2017, 6, 21)
  private val solsticeCopy = solstice.copy()

  @Test
  fun compareTo() {
    val comparison1 = startOfYear < endOfYear
    msgCompare(running("$startOfYear < $endOfYear"))
    if (!comparison1) {
      msgCompare(badImpl("compareTo()"))
      msgCompare(error("true", "$comparison1"))
    } else msgCompare("🌟 $comparison1")

    val comparison2 = startOfYear > endOfYear
    msgCompare(running("$startOfYear > $endOfYear"))
    if (comparison2) {
      msgCompare(badImpl("compareTo()"))
      msgCompare(error("false", "$comparison2"))
    } else msgCompare("🌟 $comparison2")

    val comparison3 = solstice < startOfYear
    msgCompare(running("$solstice < $startOfYear"))
    if (comparison3) {
      msgCompare(badImpl("compareTo()"))
      msgCompare(error("false", "$comparison3"))
    } else msgCompare("🌟 $comparison3")

    val comparison4 = solstice < startOfYear
    msgCompare(running("$solstice < $startOfYear"))
    if (comparison4) {
      msgCompare(badImpl("compareTo()"))
      msgCompare(error("false", "$comparison4"))
    } else msgCompare("🌟 $comparison4")

    val comparison5 = solstice <= solsticeCopy
    msgCompare(running("$solstice <= $solsticeCopy"))
    if (!comparison5) {
      msgCompare(badImpl("compareTo()"))
      msgCompare(error("true", "$comparison5"))
    } else msgCompare("🌟 $comparison5")

    success(comparison1 && comparison2 && comparison3 && comparison4)
  }

  private fun msgCompare(string: String) = msg("Compare", string)
}