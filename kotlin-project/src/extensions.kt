fun msgDestructuring(str: String) = msg("Destructuring Declaration", str)

fun msg(channel: String, msg: String?) {
  println("""TECHIO> message --channel "$channel" "$msg"""")
}
