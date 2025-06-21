import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.{Callable, Executors}

object ExecutorServiceStudy extends App {
  // スレッドを10個持つスレッドプールを作成する
  val excecutors = Executors.newFixedThreadPool(10)
  val counter = new AtomicInteger(0)

  val future = for (i <- 1 to 1000) yield {
    excecutors.submit(new Callable[Int] {
      override def call(): Int = {
        val count = counter.incrementAndGet()
        println(count);
        Thread.sleep(100)
        count
      }
    })
  }

  println("sum: " + future.foldLeft(0)((acc, f) => acc + f.get()))
  excecutors.shutdownNow()
}