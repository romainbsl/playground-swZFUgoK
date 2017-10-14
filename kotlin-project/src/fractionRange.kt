operator fun ClosedRange<RangeFraction>.iterator() = object : Iterator<RangeFraction> {
  var currentFraction: RangeFraction = start
  override fun hasNext() = currentFraction <= endInclusive
  override fun next() = currentFraction++
}