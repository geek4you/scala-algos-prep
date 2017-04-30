package algos.epi.multithreading

import java.util.concurrent.TimeUnit

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
  * Created by geek4you on 4/29/17.
  */
object ProducerConsumerWaitNotify extends App{


  val queue = new ArrayBuffer[Int]()
  val maxSize = 2
  val executor = java.util.concurrent.Executors.newFixedThreadPool(3)
  executor.submit(new Producer(queue,maxSize))
  TimeUnit.SECONDS.sleep(2)
  executor.submit(new Consumer(queue))

  class Producer(queue: ArrayBuffer[Int], maxSize: Int) extends Runnable {

    override def run(): Unit = {
      produce
    }

    @throws(classOf[InterruptedException])
    private def produce: Unit = {
      val rand = new Random()
      while (true) {
        queue.synchronized {
          while (queue.size == maxSize) {
            println(
              "Max queue size reached !! Producer thread waiting for consumer to consume !!")
            queue.wait()
          }

          val next = rand.nextInt
          println(s"Producing value : $next")
          queue += next
          queue.notifyAll()
        }
      }
    }
  }

  class Consumer(queue: ArrayBuffer[Int]) extends Runnable {
    override def run(): Unit = {consume()}

    @throws(classOf[InterruptedException])
    def consume(): Unit = {

      while (true) {
        queue.synchronized {
          while (queue.isEmpty) {
            println(
              "Queue empty !! Consumer thread waiting for producer to produce !!")
            queue.wait()
          }

          val next = queue.remove(0)
          println(s"Consumer thread ${Thread.currentThread()} consumed $next")
          queue.notifyAll()
        }
      }
    }
  }

}
