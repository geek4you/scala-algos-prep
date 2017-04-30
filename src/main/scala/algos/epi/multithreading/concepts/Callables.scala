package algos.epi.multithreading

/**
  * Created by geek4you on 4/28/17.
  */

/**
  * In addition to Runnable executors support another kind of task named Callable.
  * Callables are functional interfaces just like runnables but instead of being void they return a
  * value.
  */
object Callables extends App{

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

  // Callables can be submitted to executor services just like runnables.
  // But what about the callables result? Since submit() doesn't wait until the task completes,
  // the executor service cannot return the result of the callable directly. Instead the executor
  // returns a special result of type Future which can be used to retrieve the actual result at a
  // later point in time.
  val executors = java.util.concurrent.Executors.newSingleThreadExecutor()
  val future = executors.submit(new MyCallable)

  // After submitting the callable to the executor we first check if the future has already been finished execution via
  // isDone(). I'm pretty sure this isn't the case since the above callable sleeps for one second before returning the
  // integer.
  println(s"is future done: ${future.isDone}")

  // Calling the method get() blocks the current thread and waits until the callable completes before returning the
  // actual result 123
  val result = future.get()

  println(s"is future done: ${future.isDone}")

  println(s"result: $result")

  // Futures are tightly coupled to the underlying executor service. Keep in mind that every non-terminated future will
  // throw exceptions if you shutdown the executor:
  executors.shutdown()

}
