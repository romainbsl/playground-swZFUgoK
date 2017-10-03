data class Expr(val value: Double) {
  operator fun plus(expr: Expr) = Expr(this.value + expr.value)
  operator fun minus(expr: Expr) = Expr(this.value - expr.value)
  operator fun times(expr: Expr) = Expr(this.value * expr.value)
  operator fun div(expr: Expr) = Expr(this.value / expr.value)
  operator fun rem(expr: Expr) = Expr(this.value % expr.value)
}