package algos.epi.multithreading

import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit

/**
  * Created by geek4you on 4/29/17.
  */
object ConcurrentUtils {

  def stop(executor: ExecutorService): Unit = {
    try {
      executor.shutdown()
      executor.awaitTermination(5, TimeUnit.SECONDS)
    } catch {
      case e: InterruptedException =>
        println("termination interrupted")
    } finally {
      if (!executor.isTerminated)
        println("killing non-finished tasks")
      executor.shutdownNow
    }
  }

  import java.util.concurrent.TimeUnit

  def sleep(seconds: Int): Unit = {
    try
      TimeUnit.SECONDS.sleep(seconds)
    catch {
      case e: InterruptedException =>
        throw new IllegalStateException(e)
    }
  }

}
