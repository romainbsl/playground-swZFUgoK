import org.junit.Assert
import org.junit.Test

class ExpreTest {

  @Test
  fun operator() {
    // plus
    msg("Plus Operand", "Running Expr(199.0) + Expr(49.0)")
    msg("Plus Operand", "${Expr(199.0) + Expr(49.0)}")
    Assert.assertEquals(Expr(248.0), Expr(199.0) + Expr(49.0))
    msg("Plus Operand", "Running Expr(9.5) + Expr(29.0)")
    msg("Plus Operand", "${Expr(9.5) + Expr(29.0)}")
    Assert.assertEquals(Expr(38.5), Expr(9.5) + Expr(29.0))
    // minus
    msg("Minus Operand", "Running Expr(199.0) - Expr(49.0)...")
    msg("Minus Operand", "${Expr(199.0) - Expr(49.0)}")
    Assert.assertEquals(Expr(150.0), Expr(199.0) - Expr(49.0))
    msg("Minus Operand", "Running Expr(9.5) - Expr(29.0)...")
    msg("Minus Operand", "${Expr(9.5) - Expr(29.0)}")
    Assert.assertEquals(Expr(-19.5), Expr(9.5) - Expr(29.0))
    // times
    msg("Times Operand", "Running Expr(10.0) * Expr(49.0)...")
    msg("Times Operand", "${Expr(10.0) * Expr(49.0)}")
    Assert.assertEquals(Expr(490.0), Expr(10.0) * Expr(49.0))
    msg("Times Operand", "Running Expr(9.5) * Expr(29.0)...")
    msg("Times Operand", "${Expr(9.5) * Expr(29.0)}")
    Assert.assertEquals(Expr(275.5), Expr(9.5) * Expr(29.0))
    // div
    msg("Div Operand", "Running Expr(90.0) / Expr(9.0)...")
    msg("Div Operand", "${Expr(90.0) / Expr(9.0)}")
    Assert.assertEquals(Expr(10.0), Expr(90.0) / Expr(9.0))
    msg("Div Operand", "Running Expr(9.0) / Expr(3.0)...")
    msg("Div Operand", "${Expr(9.0) / Expr(3.0)}")
    Assert.assertEquals(Expr(3.0), Expr(9.0) / Expr(3.0))
    // rem
    msg("Rem (mod) Operand", "Running Expr(12.0) % Expr(5.0)...")
    msg("Rem (mod) Operand", "${Expr(12.0) % Expr(5.0)}")
    Assert.assertEquals(Expr(2.0), Expr(12.0) % Expr(5.0))
    msg("Rem (mod) Operand", "Running Expr(9.5) % Expr(3.0)...")
    msg("Rem (mod) Operand", "${Expr(9.5) % Expr(3.0)}")
    Assert.assertEquals(Expr(0.5), Expr(9.5) % Expr(3.0))
  }

  fun msg(channel: String, msg: String?) {
    System.out.println(String.format("TECHIO> message --channel \"%s\" \"%s\"", channel, msg))
  }

  fun success(success: Boolean) {
    System.out.println(String.format("TECHIO> success %s", success))
  }
}
