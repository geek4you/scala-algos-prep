package algos.epi.hashtable

import java.util
import java.util.Map.Entry

/**
  * Created by geek4you on 3/16/17.
  */

class IsbnCache(capacity: Int) {

  val isbnToPrice = new util.LinkedHashMap[Int, Int](capacity, 1.0f, true){
    override def removeEldestEntry(eldest: Entry[Int, Int]): Boolean = {
      this.size() > capacity
    }
  }

  def lookup(key: Int): Int = {
    if(!isbnToPrice.containsKey(key))
      -1
    else
      isbnToPrice.get(key)
  }

  /**
    * If the key is already present it should not update the value, instead it should move it to the most recently used entry
    */
  def insert(key: Int, value: Int): Int = {
    val currentValue = isbnToPrice.get(key)
    if(!isbnToPrice.containsKey(key)){
      isbnToPrice.put(key, value)
      return currentValue
    }
    -1
  }

  def erase(key: Int): Int = {
    isbnToPrice.remove(key)
  }

}
