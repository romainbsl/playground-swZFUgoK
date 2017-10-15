val running: (String) -> String = { "💡 Running $it..." }
val badImpl: (String) -> String = { "🐞 Bad implementation of the $it operator" }
val error: (String, String) -> String = { first, second -> "🐞 <$first> was expected, but was <$second>" }

fun msg(channel: String, msg: String?) {
  println("""TECHIO> message --channel "$channel" "$msg"""")
}

fun success(success: Boolean) {
  println("TECHIO> success $success")
}
