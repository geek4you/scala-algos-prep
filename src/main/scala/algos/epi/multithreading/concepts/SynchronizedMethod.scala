package algos.epi.multithreading

import java.util.concurrent.TimeUnit

/**
  * Created by geek4you on 4/29/17.
  */
/**
  * Intrinsic Locks and Synchronization
  * Synchronization is built around an internal entity known as the intrinsic lock or monitor lock.
  * Intrinsic locks play a role in both aspects of synchronization: enforcing exclusive access to an object's state and
  * establishing happens-before relationships that are essential to visibility.
  *
  * Every object has an intrinsic lock associated with it. By convention, a thread that needs exclusive and consistent
  * access to an object's fields has to acquire the object's intrinsic lock before accessing them, and then release the
  * intrinsic lock when it's done with them. A thread is said to own the intrinsic lock between the time it has acquired
  * the lock and released the lock. As long as a thread owns an intrinsic lock, no other thread can acquire the same lock.
  * The other thread will block when it attempts to acquire the lock.
  *
  * When a thread releases an intrinsic lock, a happens-before relationship is established between that action and any
  * subsequent acquisition of the same lock.
  *
  * Locks In Synchronized Methods
  * When a thread invokes a synchronized method, it automatically acquires the intrinsic lock for that method's object
  * and releases it when the method returns. The lock release occurs even if the return was caused by an uncaught exception.
  *
  * You might wonder what happens when a static synchronized method is invoked, since a static method is associated with
  * a class, not an object. In this case, the thread acquires the intrinsic lock for the Class object associated with the
  * class. Thus access to class's static fields is controlled by a lock that's distinct from the lock for any instance
  * of the class.
  *
  * Synchronized Statements
  * Another way to create synchronized code is with synchronized statements. Unlike synchronized methods, synchronized
  * statements must specify the object that provides the intrinsic lock
  *
  * Synchronized statements are also useful for improving concurrency with fine-grained synchronization.
  * Suppose, for example, class MsLunch has two instance fields, c1 and c2, that are never used together.
  * All updates of these fields must be synchronized, but there's no reason to prevent an update of c1 from being
  * interleaved with an update of c2 — and doing so reduces concurrency by creating unnecessary blocking.
  * Instead of using synchronized methods or otherwise using the lock associated with this, we create two objects solely
  * to provide locks.
  *
  * class MsLunch {
    private long c1 = 0;
    private long c2 = 0;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void inc1() {
        synchronized(lock1) {
            c1++;
        }
    }

    public void inc2() {
        synchronized(lock2) {
            c2++;
        }
    }
   }
  *
  * Reentrant Synchronization
  * Recall that a thread cannot acquire a lock owned by another thread. But a thread can acquire a lock that it already owns.
  * Allowing a thread to acquire the same lock more than once enables reentrant synchronization. This describes a situation
  * where synchronized code, directly or indirectly, invokes a method that also contains synchronized code, and both sets of
  * code use the same lock. Without reentrant synchronization, synchronized code would have to take many additional precautions
  * to avoid having a thread cause itself to block.
  */
object SynchronizedMethod extends App {

  // non synchronized method call
  var count = 0
  def increment(): Unit = {
    count = count + 1
  }
  val executor = java.util.concurrent.Executors.newFixedThreadPool(2)
  Range(0, 10000)
    .foreach(i =>
      executor.submit(new Runnable {
        override def run(): Unit = increment()
      }))
  TimeUnit.SECONDS.sleep(1)
  ConcurrentUtils.stop(executor)
  // Instead of seeing a constant result count of 10000 the actual result varies with every execution of the above code.
  // The reason is that we share a mutable variable upon different threads without synchronizing the access to this
  // variable which results in a race condition.

  // Three steps have to be performed in order to increment the number:
  // (i) read the current value,
  // (ii) increase this value by one and
  // (iii) write the new value to the variable.
  // If two threads perform these steps in parallel it's possible that both threads perform step 1 simultaneously thus
  // reading the same current value. This results in lost writes so the actual result is lower. In the above sample
  // increments got lost due to concurrent unsynchronized access to count but you may see different results when
  // executing the code by yourself.
  println(count)

  // Luckily Java supports thread-synchronization since the early days via the synchronized keyword.
  // We can utilize synchronized to fix the above race conditions when incrementing the count:
  count = 0
  def incrementSync(): Unit = synchronized {
    count = count + 1
  }

  /**
    * Java to scala
    * synchronized def myObjectMethod(): <SomeReturnType> = { }
    * is nothing but
    * def myObjectMethod: SomeReturnType = synchronized {stuff}
    */
  val executor1 = java.util.concurrent.Executors.newFixedThreadPool(2)
  val runnable = new Runnable {
    override def run(): Unit = incrementSync()
  }
  Range(0, 10000)
    .foreach(i => executor1.submit(runnable))
  TimeUnit.SECONDS.sleep(1)
  ConcurrentUtils.stop(executor)
  println(count)
  System.exit(0)

  // incrementSync can also be made thread safe using synchronized black on object
  def incrementSync1(): Unit = {
    this.synchronized {
      count = count + 1
    }
  }
}
