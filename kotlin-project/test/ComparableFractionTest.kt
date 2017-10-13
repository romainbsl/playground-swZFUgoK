import org.junit.Test

class ComparableFractionTest {

  private val fraction1 = ComparableFraction(1, 2)
  private val fraction2 = ComparableFraction(2, 3)
  private val fraction3 = ComparableFraction(3, 4)

  @Test
  fun compareTo() {
    val fractComparison1 = fraction1 < fraction2
    msgCompareTo(running("$fraction1 < $fraction2"))
    if (!fractComparison1) {
      msgCompareTo(badImpl("compareTo()"))
      msgCompareTo(error("${!fractComparison1}", "$fractComparison1"))
    } else msgCompareTo("🌟 $fractComparison1")

    msgCompareTo()

    val fractComparison2 = fraction1 > fraction2
    msgCompareTo(running("$fraction1 > $fraction2"))
    if (fractComparison2) {
      msgCompareTo(badImpl("compareTo()"))
      msgCompareTo(error("$fractComparison2", "${!fractComparison2}"))
    } else msgCompareTo("🌟 $fractComparison2")

    msgCompareTo()

    val fractComparison3 = fraction2 > fraction3
    msgCompareTo(running("$fraction2 > $fraction3"))
    if (fractComparison3) {
      msgCompareTo(badImpl("compareTo()"))
      msgCompareTo(error("$fractComparison3", "${!fractComparison3}"))
    } else msgCompareTo("🌟 $fractComparison3")

    msgCompareTo()

    val fractComparison4 = fraction2 < fraction3
    msgCompareTo(running("$fraction2 > $fraction3"))
    if (!fractComparison4) {
      msgCompareTo(badImpl("compareTo()"))
      msgCompareTo(error("${!fractComparison4}", "$fractComparison4"))
    } else msgCompareTo("🌟 $fractComparison4")

    success(fractComparison1 && !fractComparison2 && !fractComparison3 && fractComparison4)
  }

  private fun msgCompareTo(msg: String = "") = msg("compareTo()", msg)
}