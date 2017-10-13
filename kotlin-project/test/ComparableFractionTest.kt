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


  @Test
  fun get() {
    val fractGet1 = fraction1[0]
    msgGet(running("Fraction(1, 2)[0] as Int == 1"))
    val resultFractGet1 = fractGet1 as Int == fraction1.numerator
    if (!resultFractGet1) {
      msgGet(badImpl("get()"))
      msgGet(error("${fraction1.numerator}", "$fractGet1"))
    } else msgGet("$resultFractGet1")

    msgGet("")

    val fractGet2 = fraction1[1]
    msgGet(running("Fraction(1, 2)[1] as Int == 2"))
    val resultFractGet2 = fractGet2 as Int == fraction1.denominator
    if (!resultFractGet2) {
      msgGet(badImpl("get()"))
      msgGet(error("${fraction1.denominator}", "$fractGet1"))
    } else msgGet("$resultFractGet2")

    msgGet("")

    val fractGet3 = fraction1[2]
    msgGet(running("Fraction(1, 2)[2].javaClass == IllegalArgumentException::class.java"))
    val resultFractGet3 = fractGet3.javaClass == IllegalArgumentException::class.java
    if (!resultFractGet3) {
      msgGet(badImpl("get()"))
      msgGet(error("IllegalArgumentException", "$fractGet3"))
      msgGet( "🐞 Fraction have a numerator and a denominator, you should return an IllegalArgumentException if the " +
          "index is wrong ! (hint: see the answer below)")
    } else msgGet("$resultFractGet3")
  }

  private fun msgCompareTo(msg: String = "") = msg("Comparison", msg)
  private fun msgGet(msg: String) = msg("Collection", msg)
}