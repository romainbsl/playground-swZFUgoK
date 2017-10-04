data class KPoint(var x: Double, var y: Double) {
  /*
    implement operators '+', '-', '++' and '--'
   */
  operator fun plus(p: KPoint): KPoint = KPoint(Double.MIN_VALUE, Double.MAX_VALUE)
  operator fun minus(p: KPoint): KPoint = KPoint(Double.MIN_VALUE, Double.MAX_VALUE)
  operator fun dec(): KPoint = KPoint(Double.MIN_VALUE, Double.MAX_VALUE)
  operator fun inc(): KPoint = KPoint(Double.MIN_VALUE, Double.MAX_VALUE)

//{autofold
  override fun toString() = "KPoint($x, $y)"
//}
}
