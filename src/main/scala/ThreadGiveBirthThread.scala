import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger
// スレッドプールに存在するタスクが新しくスレッドプールに対してタスクを投げれば、スレッドは遊ばないんではないかという主張

object ThreadGiveBirthThread extends App {
  val executor = Executors.newFixedThreadPool(3)
  val counter = new AtomicInteger(0)


  executor.submit(new Runnable {
    override def run(): Unit = {
      Thread.sleep(1000)
      executor.submit(new Runnable {
        override def run(): Unit = {
          Thread.sleep(3000)
          println("aa")
        }
      })
    }
  })

//  executor.shutdown()
}
