import org.junit.Test

class EqFractionTest {

  private val fraction1 = EqFraction(1, 2)
  private val fraction2 = EqFraction(2, 3)
  private val fraction3 = EqFraction(3, 4)
  private val fraction4 = EqFraction(6, 8)

  @Test
  fun equals() {
    val equals1 = fraction1 == fraction2
    msgEquals(running("$fraction1 == $fraction2"))
    if (equals1) {
      msgEquals(badImpl("equals()"))
      msgEquals(error("false", "$equals1"))
    } else msgEquals("🌟 $equals1")

    msgEquals("")

    val equals2 = fraction2 == fraction3
    msgEquals(running("$fraction2 == $fraction3"))
    if (equals2) {
      msgEquals(badImpl("equals()"))
      msgEquals(error("false", "$equals2"))
    } else msgEquals("🌟 $equals2")

    msgEquals("")

    val equals3 = fraction3 == fraction4
    msgEquals(running("$fraction3 == $fraction4"))
    if (!equals3) {
      msgEquals(badImpl("equals()"))
      msgEquals(error("true", "$equals3"))
    } else msgEquals("🌟 $equals3")

    success(!equals1 && !equals2 && equals3)
  }

  private fun msgEquals(str: String) = msg("Equality Test", str)
}