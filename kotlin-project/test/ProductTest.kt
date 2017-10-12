import org.junit.Test

class ProductTest {

  private val product1 = Product("Google Pixel 2", 799.0)
  private val product2 = Product("Galaxy S8", 749.0)
  private val product3 = Product("Google Pixel 2", 799.0)
  private val product4 = Product("iPhone X", 1200.0)
  private val product5 = Product("iPhoneX", 1200.0)

  @Test
  fun equals() {
    val equals1 = product1 == product2
    msgEquals(running("$product1 == $product2"))
    if (equals1) {
      msgEquals(badImpl("equals()"))
      msgEquals(error("false", "$equals1"))
    } else msgEquals("🌟 $equals1")


    val equals2 = product1 == product3
    msgEquals(running("$product1 == $product3"))
    if (!equals2) {
      msgEquals(badImpl("equals()"))
      msgEquals(error("true", "$equals2"))
    } else msgEquals("🌟 $equals2")

    val equals3 = product4 == product5
    msgEquals(running("$product4 == $product5"))
    if (equals3) {
      msgEquals(badImpl("equals()"))
      msgEquals(error("true", "$equals3"))
    } else msgEquals("🌟 $equals3")

    success(!equals1 && equals2 && !equals3)
  }

  private fun msgEquals(str: String) = msg("Equality Test", str)
}