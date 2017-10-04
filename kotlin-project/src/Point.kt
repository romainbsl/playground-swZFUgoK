data class Point(var x: Double, var y: Double) {
  /*
    implement operators '+', '-', '++' and '--'
   */
  operator fun plus(p: Point): Point = Point(Double.MIN_VALUE, Double.MAX_VALUE)
  operator fun minus(p: Point): Point = Point(Double.MIN_VALUE, Double.MAX_VALUE)
  operator fun dec(): Point = Point(Double.MIN_VALUE, Double.MAX_VALUE)
  operator fun inc(): Point = Point(Double.MIN_VALUE, Double.MAX_VALUE)

//{autofold
  override fun toString() = "Point($x, $y)"
//}
}
