

import org.hamcrest.Matchers.equalTo
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ErrorCollector

open class PointTest {

  @Rule
  open var collector = ErrorCollector()

  @Test
  fun operator() {
    // Plus
    val plusPoint1 = Point(2.0, 3.0) + Point(3.0, 2.0)
    msg("Plus Operand", "Running Point(2.0, 3.0) + Point(3.0, 2.0)...")
    msg("Plus Operand", plusPoint1.toString())
    collector.checkThat(plusPoint1, equalTo(Point(5.0,5.0)))

    val plusPoint2 = Point(20.0, -1.0) + Point(5.0, 15.0)
    msg("Plus Operand", "Running Point(20.0, -1.0) + Point(5.0, 15.0)...")
    msg("Plus Operand", plusPoint2.toString())
    collector.checkThat(plusPoint2, equalTo(Point(25.0,14.0)))

    // Minus
    val minusPoint1 = Point(5.0, 5.0) - Point(2.0, 2.0)
    msg("Minus Operand", "Running Point(5.0, 5.0) - Point(2.0, 2.0)...")
    msg("Minus Operand", minusPoint1.toString())
    collector.checkThat(minusPoint1, equalTo(Point(3.0,3.0)))

    val minusPoint2 = Point(0.0, 0.0) - Point(10.0, 15.0)
    msg("Minus Operand", "Running Point(0.0, 0.0) - Point(10.0, 15.0)...")
    msg("Minus Operand", minusPoint2.toString())
    collector.checkThat(minusPoint2, equalTo(Point(-10.0,-15.0)))

    // Dec
    var decPoint1 = Point(5.0, 5.0)
    msg("Dec Operand", "Running ++Point(5.0, 5.0)...")
    msg("Dec Operand", "${--decPoint1}")
    collector.checkThat(decPoint1, equalTo(Point(4.0,4.0)))

    var decPoint2 = Point(-10.0, -5.0)
    msg("Dec Operand", "Running --Point(-10.0, -5.0)...")
    msg("Dec Operand", "${++decPoint2}")
    collector.checkThat(decPoint2, equalTo(Point(-11.0,-6.0)))
  }

  fun msg(channel: String, msg: String?) {
    System.out.println(String.format("TECHIO> message --channel \"%s\" \"%s\"", channel, msg))
  }

  fun success(success: Boolean) {
    System.out.println(String.format("TECHIO> success %s", success))
  }
}
