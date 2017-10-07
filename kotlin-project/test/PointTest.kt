//open class PointTest {
//
//  val plusChannel = "Plus Operand"
//  val miusChannel = "Minus Operand"
//  val decChannel = "Dec Operand"
//  val incChannel = "Inc Operand"
//
//  val running: (String) -> String = { "💡 Running $it..." }
//  val badImpl: (String) -> String = { "🐞 Bad implementation of the $it operator" }
//  val error: (String, String) -> String = { first, second -> "🐞 <$first> was expected, but was <$second>" }
//
//
//  @Test
//  fun operator() {
//    // Plus
//    val plusPoint1 = Point(2.0, 3.0) + Point(3.0, 2.0)
//    msg(plusChannel, running("Point(2.0, 3.0) + Point(3.0, 2.0)"))
//    val resultPlus1 = plusPoint1 == Point(5.0, 5.0)
//    if (!resultPlus1) {
//      msg(plusChannel, badImpl("plus()"))
//      msg(plusChannel, error("Point(5.0, 5.0)", "$plusPoint1"))
//    } else msg(plusChannel, "🌟 $plusPoint1")
//
//
//    val plusPoint2 = Point(20.0, -1.0) + Point(5.0, 15.0)
//    msg(plusChannel, running("Point(20.0, -1.0) + Point(5.0, 15.0)"))
//    val resultPlus2 = plusPoint2 == Point(25.0, 14.0)
//    if (!resultPlus2) {
//      msg(plusChannel, badImpl("plus()"))
//      msg(plusChannel, error("Point(25.0, 14.0)", "$plusPoint2"))
//    } else msg(plusChannel, "🌟 $plusPoint2")
//
//
//    // Minus
//    val minusPoint1 = Point(5.0, 5.0) - Point(2.0, 2.0)
//    msg(miusChannel, running("Point(5.0, 5.0) - Point(2.0, 2.0)"))
//    val resultMinus1 = minusPoint1 == Point(3.0, 3.0)
//    if (!resultMinus1) {
//      msg(miusChannel, badImpl("minus()"))
//      msg(miusChannel, error("Point(3.0, 3.0)", "$minusPoint1"))
//    } else msg(miusChannel, "🌟 $minusPoint1")
//
//
//    val minusPoint2 = Point(0.0, 0.0) - Point(10.0, 15.0)
//    msg(miusChannel, running("Point(0.0, 0.0) - Point(10.0, 15.0)"))
//    val resultMinus2 = minusPoint2 == Point(-10.0, -15.0)
//    if (!resultMinus2) {
//      msg(miusChannel, badImpl("minus()"))
//      msg(miusChannel, error("Point(-10.0, -15.0)", "$minusPoint2"))
//    } else msg(miusChannel, "🌟 $minusPoint2")
//
//
//    // Dec
//    var decPoint1 = Point(5.0, 5.0)
//    msg(decChannel, running("--Point(5.0, 5.0)"))
//    val resultDec1 = --decPoint1 == Point(4.0, 4.0)
//    if (!resultDec1) {
//      msg(decChannel, badImpl("dec()"))
//      msg(decChannel, error("Point(4.0, 4.0)", "$decPoint1"))
//    } else msg(decChannel, "🌟 $decPoint1")
//
//    var decPoint2 = Point(-10.0, -5.0)
//    msg(decChannel, running("--Point(-10.0, -5.0)"))
//    val resultDec2 = --decPoint2 == Point(-11.0, -6.0)
//    if (!resultDec2) {
//      msg(decChannel, badImpl("dec()"))
//      msg(decChannel, error("Point(-11.0, -6.0)", "$decPoint2"))
//    } else msg(decChannel, "🌟 $decPoint2")
//
//    // Inc
//    var incPoint1 = Point(5.0, 5.0)
//    msg(incChannel, running("++Point(5.0, 5.0)"))
//    val resultInc1 = ++incPoint1 == Point(6.0, 6.0)
//    if (!resultInc1) {
//      msg(incChannel, badImpl("inc()"))
//      msg(incChannel, error("Point(6.0, 6.0)", "$incPoint1"))
//    } else msg(incChannel, "🌟 $incPoint1")
//
//    var incPoint2 = Point(-10.0, -5.0)
//    msg(incChannel, running("++Point(-10.0, -5.0)"))
//    val resultInc2 = ++incPoint2 == Point(-9.0, -4.0)
//    if (!resultInc2) {
//      msg(incChannel, badImpl("inc()"))
//      msg(incChannel, error("Point(-9.0, -4.0)", "$incPoint2"))
//    } else msg(incChannel, "🌟 $incPoint2")
//
//    success(resultPlus1 && resultPlus2
//        && resultMinus1 && resultMinus2
//        && resultDec1 && resultDec2
//        && resultInc1 && resultInc2)
//  }
//
//  fun msg(channel: String, msg: String?) {
//    println("""TECHIO> message --channel "$channel" "$msg"""")
//  }
//
//  fun success(success: Boolean) {
//    println("TECHIO> success $success")
//  }
//}
