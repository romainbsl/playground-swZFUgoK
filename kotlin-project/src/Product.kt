class Product(val name: String, val price: Double) {
  override fun equals(other: Any?): Boolean {
    TODO("not implemented")
  }

  override fun toString(): String {
    return "Product {$name - $price}"
  }
}