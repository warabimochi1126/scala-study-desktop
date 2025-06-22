object Repl extends App {
  println(List(1, 2, 3).foldLeft(1000)((acc, x) => {
    println(s"acc: ${acc}")
    println(s"x: ${x}")
    3000
  }))
}
