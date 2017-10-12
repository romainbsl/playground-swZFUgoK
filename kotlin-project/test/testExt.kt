val running: (String) -> String = { "💡 Running $it..." }
val badImpl: (String) -> String = { "🐞 Bad implementation of the $it operator" }
val error: (String, String) -> String = { first, second -> "🐞 <$first> was expected, but was <$second>" }

//fun test() {
//  val equals1 = expr1 == expr2
//  msgEquals(running("$product1 == $product2"))
//  if (equals1) {
//    msgEquals(badImpl("equals()"))
//    msgEquals(error("false", "$equals1"))
//  } else msgEquals("🌟 $equals1")
//}

fun msg(channel: String, msg: String?) {
  println("""TECHIO> message --channel "$channel" "$msg"""")
}

fun success(success: Boolean) {
  println("TECHIO> success $success")
}
