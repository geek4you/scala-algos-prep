package algos.epi.multithreading

/**
  * Created by geek4you on 4/30/17.
  */
/**
  * Page 385
  */
class OddEvenMonitor {
  import OddEvenMonitor._
  var turn = oddTurn

  // need synchronization inorder to call wait
  @throws(classOf[InterruptedException])
  def waitTurn(oldTurn: Boolean): Unit = synchronized {
    while (turn != oldTurn) {
      wait()
    }
    // move on its our turn
  }

  // need synchronization inorder to call notify
  def toggleTurn: Unit = synchronized {
    turn ^= true
    notify()
  }
}

object OddEvenMonitor extends App {
  var oddTurn = true
  var evenTurn = false

  val executors = java.util.concurrent.Executors.newFixedThreadPool(2)
  val monitor = new OddEvenMonitor
  executors.submit(new OddRunnable(monitor))
  executors.submit(new EvenRunnable(monitor))

  executors.shutdown()
}

/**
  * Odd Runnable for crating Odd Thread
  */
class OddRunnable(monitor: OddEvenMonitor) extends Runnable {

  override def run(): Unit = {
    for (i <- 1 to 100 by 2) {
      monitor.waitTurn(OddEvenMonitor.oddTurn)
      println(s"Thread: ${Thread.currentThread()} $i")
      monitor.toggleTurn
    }
  }
}

class EvenRunnable(monitor: OddEvenMonitor) extends Runnable {
  override def run(): Unit = {
    for (i <- 2 to 100 by 2) {
      monitor.waitTurn(OddEvenMonitor.evenTurn)
      println(s"Thread: ${Thread.currentThread()} $i")
      monitor.toggleTurn
    }
  }
}
