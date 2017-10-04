import org.junit.Test

open class KPointTest {

  val plusChannel = "Plus Operand"
  val miusChannel = "Minus Operand"
  val decChannel = "Dec Operand"
  val incChannel = "Inc Operand"

  val running: (String) -> String = { "Running $this..." }
  val badImpl: (String) -> String = { "Bad implementation of the $this operator" }
  val error: (String, String) -> String = { first, second -> "<$first> was expected, but was <$second>" }


  @Test
  fun operator() {
    // Plus
    val plusPoint1 = KPoint(2.0, 3.0) + KPoint(3.0, 2.0)
    msg(plusChannel, running("KPoint(2.0, 3.0) + KPoint(3.0, 2.0)"))
    msg(plusChannel, plusPoint1.toString())
    val resultPlus1 = plusPoint1 == KPoint(5.0, 5.0)
    if (!resultPlus1) {
      msg(plusChannel, badImpl("plus()"))
      msg(plusChannel, error("KPoint(5.0, 5.0)", "$plusPoint1"))
    }

    val plusPoint2 = KPoint(20.0, -1.0) + KPoint(5.0, 15.0)
    msg(plusChannel, running("KPoint(20.0, -1.0) + KPoint(5.0, 15.0)"))
    msg(plusChannel, plusPoint2.toString())
    val resultPlus2 = plusPoint2 == KPoint(25.0, 14.0)
    if (!resultPlus2) {
      msg(plusChannel, badImpl("plus()"))
      msg(plusChannel, error("KPoint(25.0, 14.0)", "$plusPoint2"))
    }

    // Minus
    val minusPoint1 = KPoint(5.0, 5.0) - KPoint(2.0, 2.0)
    msg(miusChannel, running("KPoint(5.0, 5.0) - KPoint(2.0, 2.0)"))
    msg(miusChannel, minusPoint1.toString())
    val resultMinus1 = minusPoint1 == KPoint(3.0, 3.0)
    if (!resultMinus1) {
      msg(miusChannel, badImpl("minus()"))
      msg(miusChannel, error("KPoint(3.0, 3.0)", "$minusPoint1"))
    }

    val minusPoint2 = KPoint(0.0, 0.0) - KPoint(10.0, 15.0)
    msg(miusChannel, running("KPoint(0.0, 0.0) - KPoint(10.0, 15.0)"))
    msg(miusChannel, minusPoint2.toString())
    val resultMinus2 = minusPoint2 == KPoint(-10.0, -15.0)
    if (!resultMinus2) {
      msg(miusChannel, badImpl("minus()"))
      msg(miusChannel, error("KPoint(-10.0, -15.0)", "$minusPoint2"))
    }

    // Dec
    var decPoint1 = KPoint(5.0, 5.0)
    msg(decChannel, running("--KPoint(5.0, 5.0)"))
    val resultDec1 = --decPoint1 == KPoint(4.0, 4.0)
    if (!resultDec1) {
      msg(decChannel, badImpl("dec()"))
      msg(decChannel, error("KPoint(4.0, 4.0)", "$decPoint1"))
    } else msg(decChannel, "${decPoint1}")

    var decPoint2 = KPoint(-10.0, -5.0)
    msg(decChannel, running("--KPoint(-10.0, -5.0)"))
    val resultDec2 = --decPoint2 == KPoint(-11.0, -6.0)
    if (!resultDec2) {
      msg(decChannel, badImpl("dec()"))
      msg(decChannel, error("KPoint(-11.0, -6.0)", "$decPoint2"))
    } else msg(decChannel, "${decPoint2}")

    // Inc
    var incPoint1 = KPoint(5.0, 5.0)
    msg(incChannel, running("++KPoint(5.0, 5.0)"))
    val resultInc1 = ++incPoint1 == KPoint(6.0, 6.0)
    if (!resultInc1) {
      msg(incChannel, badImpl("inc()"))
      msg(incChannel, error("KPoint(6.0, 6.0)", "$incPoint1"))
    } else msg(incChannel, "${incPoint1}")

    var incPoint2 = KPoint(-10.0, -5.0)
    msg(incChannel, running("++KPoint(-10.0, -5.0)"))
    val resultInc2 = ++incPoint2 == KPoint(-9.0, -4.0)
    if (!resultInc2) {
      msg(incChannel, badImpl("inc()"))
      msg(incChannel, error("KPoint(-9.0, -4.0)", "$incPoint2"))
    } else msg(incChannel, "${incPoint2}")

    success(resultPlus1 && resultPlus2
        && resultMinus1 && resultMinus2
        && resultDec1 && resultDec2
        && resultInc1 && resultInc2)
  }

  fun msg(channel: String, msg: String?) {
    println("""TECHIO> message --channel "$channel" "$msg"""")
  }

  fun success(success: Boolean) {
    println("TECHIO> success $success")
  }
}
