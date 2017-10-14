data class RangeFraction(val numerator: Int, val denominator: Int) : Comparable<RangeFraction> {
  private val decimal by lazy { numerator.toDouble() / denominator }

  override fun compareTo(other: RangeFraction) = decimal.compareTo(other.decimal)
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as RangeFraction

    return decimal == other.decimal
  }

  operator fun inc() = RangeFraction(numerator + 1, denominator + 1)
}
