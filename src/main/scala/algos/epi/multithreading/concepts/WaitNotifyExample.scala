package algos.epi.multithreading

import java.util.Scanner
import java.util.concurrent.TimeUnit

/**
  * Created by geek4you on 4/29/17.
  */
object WaitNotifyExample extends App{

  val executor = java.util.concurrent.Executors.newFixedThreadPool(2)
  val processor = new Processor

  val producerRunnable = new Runnable {
    override def run(): Unit = processor.produce
  }

  val consumerRunnable = new Runnable {
    override def run(): Unit = processor.consume
  }

  executor.submit(producerRunnable)
  executor.submit(consumerRunnable)


}

class Processor {

  @throws(classOf[InterruptedException])
  def produce: Unit = {
    this.synchronized{
      println("Producer Thread running !!")
      wait()
      println("Producer resumed !! ")
    }
  }

  @throws(classOf[InterruptedException])
  def consume: Unit = {
    val scanner = new Scanner(System.in)
    TimeUnit.SECONDS.sleep(2)
    this.synchronized{
      println("Consumer Thread Started !!")
      scanner.nextLine()
      println("Return Key Pressed !!")
      notify()
      TimeUnit.SECONDS.sleep(5)
    }
  }
}