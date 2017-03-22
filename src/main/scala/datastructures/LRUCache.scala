package datastructures

import scala.collection.mutable

/**
  * Created by geek4you on 2/18/17.
  */
/**
  * The problem can be solved with a hash table that keeps track of the keys and its values in the
  * double linked list. One interesting property about double linked list is that the node can remove
  * itself without other reference. In addition, it takes constant time to add and remove nodes
  * from the head or tail.
  *
  * One particularity about the double linked list that I implemented is that I create a pseudo head
  * and tail to mark the boundary, so that we don't need to check the NULL node during the update.
  * This makes the code more concise and clean, and also it is good for the performance as well.
  */
/**
  * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
  * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
  * it should invalidate the least recently used item before inserting a new item.
  *
  * The LRU cache is a hash table of keys and double linked nodes. The hash table makes the time of get()
  * to be O(1). The list of double linked nodes make the nodes adding/removal operations O(1).
  */
class LRUCache(capacity: Int) {

  val head = DLLNode()
  val tail = DLLNode()
  tail.prev = head

  /**
    * Always add the new node right after head;
    */
  private def addNode(node: DLLNode): Unit = {
    node.prev = head
    node.next = head.next
    head.next.prev = node
    head.next = node
  }

  /**
    * Remove an existing node from the linked list.
    */
  private def removeNode(node: DLLNode): Unit = {
    node.next.prev = node.prev
    node.prev.next = node.next
  }

  /**
    * Move certain node in between to the head.
    */
  private def moveToHead(node: DLLNode): Unit = {
    removeNode(node)
    addNode(node)
  }

  private def popTail(): DLLNode = {
    val node = tail.prev
    removeNode(node)
    node
  }

  private val cache = mutable.Map[Int, DLLNode]()
  private var count: Int = _

  def getKey(key: Int): Int = {
    if (cache.contains(key)) {
      val node = cache(key)
      // move the accessed node to the head;
      moveToHead(node)
      node.value
    } else
      throw new RuntimeException(s"did not find key $key in cache !!")
  }

  def set(key: Int, value: Int): Unit = {
    if (!cache.contains(key)) {
      val node = DLLNode(key, value)
      addNode(node)
      moveToHead(node)
      if (capacity < cache.size) {
        val node = popTail()
        cache.remove(node.key)
      }
    } else {
      // update the value
      cache(key).value = value
      moveToHead(cache(key))
    }
  }

}

case class DLLNode(var key: Int,
                   var value: Int,
                   var next: DLLNode,
                   var prev: DLLNode) {
  def this() = this(-1, -1, null, null)
  def this(key: Int, value: Int) = this(key, value, null, null)
}

object DLLNode {
  def apply() = new DLLNode()
  def apply(key: Int, value: Int) = new DLLNode(key, value)
}
