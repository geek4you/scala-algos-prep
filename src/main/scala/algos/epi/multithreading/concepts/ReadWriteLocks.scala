package algos.epi.multithreading

import java.util.concurrent.locks.ReentrantReadWriteLock

/**
  * Created by geek4you on 4/29/17.
  */
/**
  * A ReadWriteLock maintains a pair of associated locks, one for read-only operations and one for writing.
  * The read lock may be held simultaneously by multiple reader threads, so long as there are no writers.
  * The write lock is exclusive.
  *
  * It exploits the fact that while only a single thread at a time (a writer thread) can modify the shared data,
  * in many cases any number of threads can concurrently read the data (hence reader threads).
  *
  * The idea behind read-write locks is that it's usually safe to read mutable variables concurrently as long as nobody
  * is writing to this variable. So the read-lock can be held simultaneously by multiple threads as long as no threads
  * hold the write-lock. This can improve performance and throughput in case that reads are more frequent than writes.
  */
object ReadWriteLocks extends App {

  val executor = java.util.concurrent.Executors.newFixedThreadPool(2)
  val map = scala.collection.mutable.Map[String, String]()
  val lock = new ReentrantReadWriteLock()

  val writeTask = new Runnable {
    override def run(): Unit = {
      lock.writeLock().lock()
      try {
        ConcurrentUtils.sleep(1)
        map += ("foo" -> "bar")
      } finally {
        lock.writeLock().unlock()
      }
    }
  }

  executor.submit(writeTask)
  // The above example first acquires a write-lock in order to put a new value to the map after sleeping for one second.
  // Before this task has finished two other tasks are being submitted trying to read the entry from the map and sleep
  // for one second:

  val readTask = new Runnable {
    override def run(): Unit = {
      lock.readLock.lock()
      try {
        println(map.get("foo"))
        ConcurrentUtils.sleep(1)
      } finally {
        lock.readLock.unlock()
      }
    }
  }

  executor.submit(readTask)
  executor.submit(readTask)

  ConcurrentUtils.stop(executor)

  // When you execute this code sample you'll notice that both read tasks have to wait the whole second until the write
  // task has finished. After the write lock has been released both read tasks are executed in parallel and print the
  // result simultaneously to the console. They don't have to wait for each other to finish because read-locks can safely
  // be acquired concurrently as long as no write-lock is held by another thread.

}
