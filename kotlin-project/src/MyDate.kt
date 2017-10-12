data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
  override fun compareTo(other: MyDate): Int {
    // TODO Implement function
    return 1
  }
}