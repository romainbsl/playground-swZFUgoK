import org.junit.Test

class FractionTest {

  private val fraction1 = Fraction(1, 2)
  private val fraction2 = Fraction(2, 3)
  private val fraction3 = Fraction(3, 4)

  @Test
  fun plus() {
    val fractPlus1 = fraction1 + fraction2
    msgPlus(running("Fraction(1, 2) + Fraction(2, 3)"))
    val resultPlus1 = fractPlus1 == Fraction(7, 6)
    if (!resultPlus1) {
      msgPlus(badImpl("plus()"))
      msgPlus(error("Fraction(7, 6)", "$fractPlus1"))
    } else msgPlus("🌟 $fractPlus1")

    msgPlus("")

    val fractPlus2 = fraction1 + fraction3
    msgPlus(running("Fraction(1, 2) + Fraction(3, 4)"))
    val resultPlus2 = fractPlus2 == Fraction(10, 8)
    if (!resultPlus2) {
      msgPlus(badImpl("plus()"))
      msgPlus(error("Fraction(10, 8)", "$fractPlus2"))
    } else msgPlus("🌟 $fractPlus2")

    msgPlus("")

    val fractPlus3 = fraction2 + fraction3
    msgPlus(running("Fraction(1, 2) + Fraction(3, 4)"))
    val resultPlus3 = fractPlus3 == Fraction(17, 12)
    if (!resultPlus3) {
      msgPlus(badImpl("plus()"))
      msgPlus(error("Fraction(17, 12)", "$fractPlus3"))
    } else msgPlus("🌟 $fractPlus3")

    success(resultPlus1 && resultPlus2 && resultPlus3)
  }

  @Test
  fun times() {
    val fractTimes1 = fraction1 * 2
    msgTimes(running("Fraction(1, 2) * 2"))
    val resultTimes1 = fractTimes1 == Fraction(2, 2)
    if (!resultTimes1) {
      msgTimes(badImpl("times()"))
      msgTimes(error("Fraction(2, 2)", "$fractTimes1"))
    } else msgTimes("🌟 $fractTimes1")

    msgTimes("")

    val fractTimes2 = fraction2 * 3
    msgTimes(running("Fraction(2, 3) * 3"))
    val resultTimes2 = fractTimes2 == Fraction(6, 3)
    if (!resultTimes2) {
      msgTimes(badImpl("times()"))
      msgTimes(error("Fraction(6, 3)", "$fractTimes2"))
    } else msgTimes("🌟 $fractTimes2")

    msgTimes("")

    val fractTimes3 = fraction3 * 4
    msgTimes(running("Fraction(3, 4) * 4"))
    val resultTimes3 = fractTimes3 == Fraction(12, 4)
    if (!resultTimes3) {
      msgTimes(badImpl("times()"))
      msgTimes(error("Fraction(12, 4)", "$fractTimes3"))
    } else msgTimes("🌟 $fractTimes3")

    success(resultTimes1 && resultTimes2 && resultTimes3)
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
      msgGet("Fraction have a numerator and a denominator, you should return an IllegalArgumentException if the " +
          "index is wrong ! (hint: see the answer below)")
    } else msgGet("$resultFractGet3")
  }

  private fun msgPlus(msg: String) = msg("plus()", msg)
  private fun msgTimes(msg: String) = msg("times()", msg)
  private fun msgGet(msg: String) = msg("get()", msg)
}
