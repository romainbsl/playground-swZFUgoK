import org.junit.Test

class FractionTest {

  private val fraction1 = Fraction(1, 2)
  private val fraction2 = Fraction(2, 3)
  private val fraction3 = Fraction(3, 4)

  private val running: (String) -> String = { "💡 Running $it..." }
  private val badImpl: (String) -> String = { "🐞 Bad implementation of the $it operator" }
  private val error: (String, String) -> String = { first, second -> "🐞 <$first> was expected, but was <$second>" }

  @Test
  fun plus() {
    val fractPlus1 = fraction1 + fraction2
    msgPlus(running("Fraction(1, 2) + Fraction(2, 3)"))
    val resultPlus1 = fractPlus1 == Fraction(7, 6)
    if (!resultPlus1) {
      msgPlus(badImpl("plus()"))
      msgPlus(error("Fraction(7, 6)", "$fractPlus1"))
    } else msgPlus("🌟 $fractPlus1")

    msgPlus(null)

    val fractPlus2 = fraction1 + fraction3
    msgPlus(running("Fraction(1, 2) + Fraction(3, 4)"))
    val resultPlus2 = fractPlus2 == Fraction(10, 8)
    if (!resultPlus2) {
      msgPlus(badImpl("plus()"))
      msgPlus(error("Fraction(10, 8)", "$fractPlus2"))
    } else msgPlus("🌟 $fractPlus2")

    msgPlus(null)

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
    msgPlus(running("Fraction(1, 2) * 2"))
    val resultTimes1 = fractTimes1 == Fraction(2, 2)
    if (!resultTimes1) {
      msgPlus(badImpl("times()"))
      msgPlus(error("Fraction(2, 2)", "$fractTimes1"))
    } else msgPlus("🌟 $fractTimes1")

    msgPlus(null)

    val fractTimes2 = fraction2 * 3
    msgPlus(running("Fraction(2, 3) * 3"))
    val resultTimes2 = fractTimes2 == Fraction(6, 3)
    if (!resultTimes2) {
      msgPlus(badImpl("times()"))
      msgPlus(error("Fraction(6, 3)", "$fractTimes2"))
    } else msgPlus("🌟 $fractTimes2")

    msgPlus(null)

    val fractTimes3 = fraction3 * 4
    msgPlus(running("Fraction(3, 4) * 4"))
    val resultTimes3 = fractTimes3 == Fraction(12, 4)
    if (!resultTimes3) {
      msgPlus(badImpl("times()"))
      msgPlus(error("Fraction(12, 4)", "$fractTimes3"))
    } else msgPlus("🌟 $fractTimes3")

    success(resultTimes1 && resultTimes2 && resultTimes3)
  }


  fun msgPlus(msg: String?) = msg("plus()", msg)
  fun msgTimes(msg: String?) = msg("times()", msg)
  fun msg(channel: String, msg: String?) {
    println("""TECHIO> message --channel "$channel" "$msg"""")
  }

  fun success(success: Boolean) {
    println("TECHIO> success $success")
  }
}
