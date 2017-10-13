class EqFraction(val numerator: Int, val denominator: Int) {
  val decimal by lazy { numerator.toDouble() / denominator }

  override fun equals(other: Any?): Boolean {
    TODO("not implemented")
  }

  override fun toString() = "Fraction($numerator, $denominator) "
}