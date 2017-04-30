package algos.epi.multithreading

import java.util.concurrent.TimeUnit

/**
  * Created by geek4you on 4/28/17.
  */
object ThreadCreation extends App {

  /**
    * Threads can be formed by extending Thread class
    */
  class MyThread extends Thread {
    override def run(): Unit = {
      val threadName = Thread.currentThread().getName
      println(s"Hello $threadName")
    }
  }

  /**
    * Threads can be created from Runnable
    * Define Runnable class and then use Thread constructor
    * new Thread(new Runnable{ def run: Unit = {}})
    */
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

  val thread1 = new MyThread
  val thread2 = new Thread(new MyThread1)

  thread1.start()
  thread2.start()
  println(s"Done !!")
}
