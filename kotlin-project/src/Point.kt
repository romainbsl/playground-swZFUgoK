data class Point(val x: Double, val y: Double) : Comparable<Point> {
  operator fun plus(p: Point) = Point(x + p.x, y + p.y)
  operator fun minus(p: Point) = Point(x - p.x, y - p.y)
  operator fun times(p: Point) = Point(x * p.x, y * p.y)
  operator fun div(p: Point) = Point(x / p.x, y / p.y)
  operator fun inc() = Point(x + 1, y + 1)
  operator fun dec() = Point(x - 1, y - 1)

  override fun compareTo(other: Point): Int = when {
    y != other.y -> (y - other.y).toInt()
    else -> (x - other.x).toInt()
  }
}

operator fun ClosedRange<Point>.iterator() = object : Iterator<Point> {
  var currentPoint = start
  override fun hasNext() = currentPoint <= endInclusive
  override fun next() = currentPoint++
}
