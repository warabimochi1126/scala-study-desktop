object Repl extends App {
  val length = 10
  val list = (for (i <- 1 to length) yield BigInt(i)).toList

  println(list.splitAt(5))
}
