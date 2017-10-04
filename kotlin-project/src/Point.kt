data class Point(var x: Double, var y: Double) {
  /*
    implement operators
   */
  operator fun plus(p: Point): Point {return Point(Double.MIN_VALUE, Double.MAX_VALUE) }
  operator fun minus(p: Point): Point { return Point(Double.MIN_VALUE, Double.MAX_VALUE) }
  operator fun dec() : Point { return Point(Double.MIN_VALUE, Double.MAX_VALUE) }
  operator fun inc() : Point { return Point(Double.MIN_VALUE, Double.MAX_VALUE) }
}