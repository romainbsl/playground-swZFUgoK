data class KPoint(var x: Double, var y: Double) {
  /*
    implement operators
   */
//  operator fun plus(p: KPoint): KPoint {return KPoint(x + p.x, y + p.y) }
//  operator fun minus(p: KPoint): KPoint { return KPoint(x - p.x, y - p.y) }
//  operator fun dec() : KPoint { return KPoint(--x, --y) }
//  operator fun inc() : KPoint { return KPoint(++x, ++y) }
  operator fun plus(p: KPoint): KPoint {return KPoint(Double.MIN_VALUE, Double.MAX_VALUE) }
  operator fun minus(p: KPoint): KPoint { return KPoint(Double.MIN_VALUE, Double.MAX_VALUE) }
  operator fun dec() : KPoint { return KPoint(Double.MIN_VALUE, Double.MAX_VALUE) }
  operator fun inc() : KPoint { return KPoint(Double.MIN_VALUE, Double.MAX_VALUE) }

  override fun toString(): String {
    return "KPoint($x, $y)"
  }
}