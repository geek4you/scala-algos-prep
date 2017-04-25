package datastructures.hashtable

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 4/10/17.
  */
/**
  * @see http://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/
  * also see http://quiz.geeksforgeeks.org/hashing-set-1-introduction/
  */
// a node of chains
case class HashNode[K, V](key: K, value: V) {
  // Reference to next node
  var next: HashNode[K, V] = _
}

/**
  * Class to represent entire hash table
  */
class HashTable[K, V] {
  // bucketArray is used to store array of chains
  private var bucketArray = new ArrayBuffer[HashNode[K, V]]()
  // create 10 buckets on initialization
  // Current capacity of array list
  private var numBuckets = 10
  for (i <- 0 until numBuckets)
    bucketArray += null

  // Current size of bucket list
  private var sizeOfHashTable = 0

  def size(): Int = sizeOfHashTable

  def isEmpty: Boolean = size == 0

  // This implements hash function to find index
  // for a key
  private def getBucketIndex(key: K): Int = {
    val hashCode = key.hashCode()
    val index = hashCode % numBuckets
    index
  }

  // Method to remove a given key
  def remove(key: K): V = {
    val bucketIndex = getBucketIndex(key)
    // Get head of chain
    val head = bucketArray(bucketIndex)

    // Search for key in its chain
    var done = false
    var curr = head
    var prev: HashNode[K, V] = null
    while (Option(curr).isDefined && done) {
      if (curr.key == key) // If Key found
        done = true
      else { // Else keep moving in chain
        prev = curr
        curr = curr.next
      }
    }
    if (Option(curr).isEmpty) // if key not found
      null.asInstanceOf[V]
    else {
      // reduce size
      sizeOfHashTable -= 1
      // remove key
      if (Option(prev).isDefined)
        prev.next = curr.next
      else
        bucketArray(bucketIndex) = curr.next
      curr.value
    }
  }

  // Returns value for a key
  def get(key: K): V = {
    val bucketIndex = getBucketIndex(key)
    val head = bucketArray(bucketIndex)
    // Search for key in its chain
    var done = false
    var curr = head
    while (!done && Option(curr).isDefined) {
      if (curr.key == key)
        done = true
      else
        curr = curr.next
    }

    if (Option(curr).isDefined)
      curr.value
    else
      null.asInstanceOf[V] // If key not found
  }

  // Adds a key value pair to hash
  def add(key: K, value: V): Unit = {
    // get the bucket index
    val bucketIndex = getBucketIndex(key)
    var head = bucketArray(bucketIndex)

    // Check if key is already present
    var done = false
    var curr = head
    while (!done && Option(curr).isDefined) {
      if (curr.key == key)
        done = true
      else
        curr = curr.next
    }

    if (Option(curr).isDefined) // key already present
      return

    sizeOfHashTable += 1

    val bucketIdx = getBucketIndex(key)
    head = bucketArray(bucketIdx)
    val newNode = new HashNode[K, V](key, value)
    newNode.next = head
    bucketArray(bucketIdx) = newNode
    // If load factor goes beyond threshold, then
    // double hash table size
    if ((1.0 * sizeOfHashTable) / numBuckets >= 0.7) {
      val tmp = bucketArray
      bucketArray = new ArrayBuffer[HashNode[K, V]]()
      numBuckets = 2 * numBuckets
      sizeOfHashTable = 0
      for (i <- 0 until numBuckets)
        bucketArray += null

      tmp.foreach(buck => {
        var cur = buck
        while (Option(cur).isDefined) {
          add(cur.key, cur.value)
          cur = cur.next
        }
      })
    }
  }

}

object HashTable extends App {
  val map = new HashTable[String, Int]()
  map.add("this", 1)
  map.add("coder", 2)
  map.add("this", 4)
  println(map.size())
  println(map.remove("this"))
  println(map.remove("this"))
  println(map.size())
  println(map.isEmpty)

}
