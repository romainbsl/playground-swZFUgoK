import java.io.File;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

class ExpreTest {

  @Test
  fun plus() {
    Assert.assertEquals("Running Expr(199.0) + Expr(49.0)", Expr(248.0), Expr(199.0) + Expr(49.0))
    Assert.assertEquals("Running Expr(9.5) + Expr(29.0)", Expr(38.5), Expr(9.5) + Expr(29.0))

//    try {
//      Assert.assertEquals("Running countAllStars(2, 3)...", 5, countAllStars(2, 3))
//      Assert.assertEquals("Running countAllStars(9, -3)...", 6, countAllStars(9, -3))
//      success(true)
//
//      if (existsInFile("galaxies.sum()", File("./src/universe.kt"))) {
//        msg("My personal Yoda, you are. 🙏", "* ● ¸ .　¸. :° ☾ ° 　¸. ● ¸ .　　¸.　:. • ")
//        msg("My personal Yoda, you are. 🙏", "           　★ °  ☆ ¸. ¸ 　★　 :.　 .   ")
//        msg("My personal Yoda, you are. 🙏", "__.-._     ° . .　　　　.　☾ ° 　. *   ¸ .")
//        msg("My personal Yoda, you are. 🙏", "'-._\\7'      .　　° ☾  ° 　¸.☆  ● .　　　")
//        msg("My personal Yoda, you are. 🙏", " /'.-c    　   * ●  ¸.　　°     ° 　¸.    ")
//        msg("My personal Yoda, you are. 🙏", " |  /T      　　°     ° 　¸.     ¸ .　　  ")
//        msg("My personal Yoda, you are. 🙏", "_)_/LI");
//      } else {
//        msg("Kudos 🌟", "Did you know that in Kotlin you can use the sum() function directly on an Array? Try it!")
//        msg("Kudos 🌟", "")
//        msg("Kudos 🌟", "var galaxies = arrayOf(37, 3, 2)")
//        msg("Kudos 🌟", "var totalStars = galaxies.sum() // 42")
//      }
//    } catch (ae: AssertionError) {
//      success(false)
//      msg("Oops! 🐞", ae.message)
//      msg("Hint 💡", "Did you properly accumulate all stars into 'totalStars'? 🤔")
//    }
  }

  @Test
  fun minus() {
    Assert.assertEquals("Running Expr(199.0) - Expr(49.0)...", Expr(150.0), Expr(199.0) - Expr(49.0))
    Assert.assertEquals("Running Expr(9.5) - Expr(29.0)...", -Expr(19.5), Expr(9.5) - Expr(29.0))
  }

  @Test
  fun times() {
    Assert.assertEquals("Running Expr(10.0) * Expr(49.0)...", Expr(490.0), Expr(10.0) * Expr(49.0))
    Assert.assertEquals("Running Expr(9.5) * Expr(29.0)...", Expr(275.5), Expr(9.5) * Expr(29.0))
  }

  @Test
  fun div() {
    Assert.assertEquals("Running Expr(90.0) / Expr(9.0)...", Expr(10.0), Expr(90.0) / Expr(9.0))
    Assert.assertEquals("Running Expr(9.0) / Expr(3.0)...", Expr(3.0), Expr(9.0) / Expr(3.0))
  }

  @Test
  fun rem() {
    Assert.assertEquals("Running Expr(12.0) % Expr(5.0)...", Expr(2.0), Expr(12.0) % Expr(5.0))
    Assert.assertEquals("Running Expr(9.5) % Expr(3.0)...", Expr(0.5), Expr(9.5) % Expr(3.0))
  }

  fun msg(channel: String, msg: String?) {
    System.out.println(String.format("TECHIO> message --channel \"%s\" \"%s\"", channel, msg))
  }

  fun success(success: Boolean) {
    System.out.println(String.format("TECHIO> success %s", success))
  }
}
