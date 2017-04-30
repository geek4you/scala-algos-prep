package algos.epi.multithreading

import java.util.concurrent.TimeUnit

/**
  * Created by geek4you on 4/28/17.
  */

/**
  * The Concurrency API introduces the concept of an ExecutorService as a higher level replacement
  * for working with threads directly. Executors are capable of running asynchronous tasks and
  * typically manage a pool of threads, so we don't have to create new threads manually.
  * All threads of the internal pool will be reused under the hood for relevant tasks, so we can
  * run as many concurrent tasks as we want throughout the life-cycle of our application with a
  * single executor service.
  */
object Executors extends App{

  // The class Executors provides convenient factory methods for creating different kinds of
  // executor services. In this sample we use an executor with a thread pool of size one.
  val executors = java.util.concurrent.Executors.newSingleThreadExecutor()

  val executorService = java.util.concurrent.Executors.newFixedThreadPool(10)

  class MyThread1 extends Runnable {
    override def run(): Unit = {
      val threadName = Thread.currentThread().getName
      println(s"Hello $threadName")

      // Threads can be put to sleep for a certain duration.
      try {
        TimeUnit.SECONDS.sleep(1)
        // or alternatively
        Thread.sleep(1000)
      } catch {
        case e: InterruptedException => e.printStackTrace()
      }

    }
  }

  executorService.submit(new MyThread1)

  // the java process never stops! Executors have to be stopped explicitly - otherwise they
  // keep listening for new tasks.

  // An ExecutorService provides two methods for that purpose: shutdown() waits for currently
  // running tasks to finish while shutdownNow() interrupts all running tasks and shut the
  // executor down immediately.
  executorService.shutdown()

  // This is the preferred way how I typically shutdown executors:
  executors.submit(new MyThread1)
  try {
    System.out.println("attempt to shutdown executor")
    executors.shutdown()
    executors.awaitTermination(5, TimeUnit.SECONDS)
  }catch {
    case e: InterruptedException => e.printStackTrace()
  }finally {
    if (!executors.isTerminated()) {
      println("cancel non finished jobs")
      executors.shutdownNow
      println("shutdown finished !!")
    }
  }
  // The above code does this : The executor shuts down softly by waiting a certain amount of time
  // for termination of currently running tasks. After a maximum of five seconds the executor
  // finally shuts down by interrupting all running tasks.

}
