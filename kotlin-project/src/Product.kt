class Product(val name: String, val price: Double) {
  override fun equals(other: Any?): Boolean {
    // TODO implement operator
    return false
  }

  override fun toString(): String {
    return "Product {$name - $price}"
  }
}