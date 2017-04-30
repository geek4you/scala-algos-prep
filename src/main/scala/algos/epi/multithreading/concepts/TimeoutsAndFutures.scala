package algos.epi.multithreading

import java.util
import java.util.concurrent.TimeUnit

import algos.epi.multithreading.Executors.MyThread1

/**
  * Created by geek4you on 4/28/17.
  */
object TimeoutsAndFutures extends App{

  // Any call to future.get() will block and wait until the underlying callable has been terminated.
  // In the worst case a callable runs forever - thus making your application unresponsive.
  // You can simply counteract those scenarios by passing a timeout:

  class MyCallable extends java.util.concurrent.Callable[Int]{
    override def call(): Int = {
      try{
        import java.util.concurrent.TimeUnit
        TimeUnit.SECONDS.sleep(1)
        123
      }catch {
        case e: InterruptedException => throw new IllegalStateException("task interrupted", e)
      }
    }
  }

  val executors = java.util.concurrent.Executors.newSingleThreadExecutor()

  val future = executors.submit(new MyCallable)
  try{
    future.get(2, TimeUnit.NANOSECONDS)
  }catch {
    case e: Exception => e.printStackTrace()
  }


  // invoke all
  // Executors support batch submitting of multiple callables at once via invokeAll().
  // This method accepts a collection of callables and returns a list of futures.
  val callables = util.Arrays.asList(new MyThread1, new MyThread1)
  // executors.invokeAll(callables)
  executors.shutdownNow()
}
