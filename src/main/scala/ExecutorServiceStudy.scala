import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.{Callable, Executors}

object ExecutorThreadPool extends App {
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

  excecutors.shutdownNow()
}