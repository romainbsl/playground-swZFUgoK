import org.junit.Test

class RangeFractionTest {

  private val fraction1 = RangeFraction(1, 2)
  private val fraction2 = RangeFraction(3, 4)

  @Test
  fun iterator() {
    val fractIterator = fraction1..fraction2

    msgIterator(running("$fraction1..$fraction2.contains(RangeFraction(1, 2))"))
    val result1 = fractIterator.contains(RangeFraction(1, 2))
    if (!result1) {
      msgIterator(badImpl("iterator()"))
      msgIterator(error("true", "$result1"))
    } else msgIterator("$result1")

    msgIterator("")

    msgIterator(running("$fraction1..$fraction2.contains(RangeFraction(2, 3))"))
    val result2 = fractIterator.contains(RangeFraction(2, 3))
    if (!result2) {
      msgIterator(badImpl("iterator()"))
      msgIterator(error("true", "$result2"))
    } else msgIterator("$result2")

    msgIterator("")

    msgIterator(running("$fraction1..$fraction2.contains(RangeFraction(3, 4))"))
    val result3 = fractIterator.contains(RangeFraction(3, 4))
    if (!result3) {
      msgIterator(badImpl("iterator()"))
      msgIterator(error("true", "$result3"))
    } else msgIterator("$result3")

    msgIterator("")

    msgIterator(running("$fraction1..$fraction2.contains(RangeFraction(6, 8))"))
    val result4 = fractIterator.contains(RangeFraction(6, 8))
    if (!result4) {
      msgIterator(badImpl("iterator()"))
      msgIterator(error("true", "$result4"))
    } else msgIterator("$result4")

    msgIterator("")

    msgIterator(running("$fraction1..$fraction2.contains(RangeFraction(10, 12))"))
    val result5 = fractIterator.contains(RangeFraction(10, 12))
    if (result5) {
      msgIterator(badImpl("iterator()"))
      msgIterator(error("false", "$result5"))
    } else msgIterator("$result5")

    msgIterator("")

    for (fraction in fractIterator) {
      msgIterator(fraction.toString())
    }


  }

  private fun msgIterator(msg: String) = msg("Iteration", msg)
}