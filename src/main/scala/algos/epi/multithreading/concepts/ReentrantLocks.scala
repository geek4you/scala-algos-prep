package algos.epi.multithreading

import java.util.concurrent.locks.ReentrantLock

/**
  * Created by geek4you on 4/29/17.
  */
/**
  * The class ReentrantLock is a mutual exclusion lock with the same basic behavior as the implicit monitors accessed
  * via the synchronized keyword but with extended capabilities. As the name suggests this lock implements reentrant
  * characteristics just as implicit monitors.
  */
object ReentrantLocks extends App{

  val lock = new ReentrantLock()
  var count = 0

  /**
    * A lock is acquired via lock() and released via unlock(). It's important to wrap your code into a try/finally block
    * to ensure unlocking in case of exceptions. This method is thread-safe just like the synchronized counterpart.
    * If another thread has already acquired the lock subsequent calls to lock() pause the current thread until the
    * lock has been unlocked. Only one thread can hold the lock at any given time.
    */
  def increment(): Unit = {
    lock.lock()
    try{
      count += 1
    }finally {
      lock.unlock()
    }
  }

  val executor = java.util.concurrent.Executors.newFixedThreadPool(2)
  executor.submit(new Runnable {
    override def run(): Unit = {
      println(s"Locked: ${lock.isLocked}")
      println(s"HeldByMe: ${lock.isHeldByCurrentThread}")
      val tryLock = lock.tryLock()
      println(s"Lock acquired: $tryLock")
      lock.unlock()
      println(s"Lock acquired: ${lock.isLocked}")
    }
  })

  //The method tryLock() as an alternative to lock() tries to acquire the lock without pausing the current thread.
  // The boolean result must be used to check if the lock has actually been acquired before accessing any shared mutable
  // variables.

  ConcurrentUtils.stop(executor)

}
