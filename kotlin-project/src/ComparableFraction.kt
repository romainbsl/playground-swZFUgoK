data class ComparableFraction(val numerator: Int, val denominator: Int) : Comparable<ComparableFraction> {
  private val decimal by lazy { numerator.toDouble() / denominator }
  
  override fun compareTo(other: ComparableFraction): Int {
    TODO("not implemented")
  }
}
