import java.util.concurrent.Executors

object ExcecutorServiceStudy2 extends App {
  // poolsize       はスレッドプール内スレッドでタスクが実行されたらインクリメント.指定個数で頭打ち
  // active threads はスレッドプール内の現在実行中スレッドの数
  // queued tasks   はスレッドプールが満タンで実行を待っているタスクの数
  // completed tasks はスレッドプール内スレッドで実行が終了したタスクの数
  val excecutors = Executors.newFixedThreadPool(3)

  println(s"生成直後のthread pool:${excecutors}")

  for(i <- 1 to 5) {
    excecutors.submit(new Runnable {
      override def run(): Unit = {
        Thread.sleep(1000)
        println(s"これは${i}番目のスレッドです。")
      }
    })
  }

  println(s"実行直後のthread pool:${excecutors}")

  Thread.sleep(2100)
  println(s"実行終了後のthread pool:${excecutors}")

  excecutors.shutdown()
  excecutors.shutdownNow()
}
