package algos.epi.multithreading

import java.util.concurrent.{Semaphore, TimeUnit}

/**
  * Created by geek4you on 4/29/17.
  */
/**
  * In addition to locks the Concurrency API also supports counting semaphores.
  * Whereas locks usually grant exclusive access to variables or resources, a semaphore is capable of maintaining whole sets of permits.
  * This is useful in different scenarios where you have to limit the amount concurrent access to certain parts of your
  * application.
  */
object Semaphores extends App {

  import java.util.concurrent.Executors
  val executor = Executors.newFixedThreadPool(10)
  val semaphore = new Semaphore(5)

  val longRunningTask = new Runnable {
    override def run(): Unit = {
      var permit: Boolean = false
      try {
        permit = semaphore.tryAcquire(1, TimeUnit.SECONDS)
        if (permit) {
          println("acquired semaphore")
          ConcurrentUtils.sleep(5)
        } else {
          println("couldn't acquire semaphore")
        }
      } catch {
        case e: InterruptedException => e.printStackTrace()
      } finally {
        if (permit)
          semaphore.release()
      }
    }
  }

  Range(0, 10).foreach(_ => executor.submit(longRunningTask))

  ConcurrentUtils.stop(executor)
}
