package algos.epi.hashtable

import java.util

/**
  * Created by geek4you on 3/16/17.
  */

/**
  * Page 223
  */
object SmallestSubArrayCoveringSubset {

  def smallestSubArrayCoveringSubset(paragraph: Array[String], keywords: Array[String]): SubArray = {
    val dict = new util.LinkedHashMap[String, Integer]()
    keywords.foreach(elem => dict.put(elem, null))

    val result = SubArray(-1,-1)
    var idx = 0
    val iter = paragraph.iterator
    var numStringsFromKeywordsSeenSoFar = 0

    while (iter.hasNext){
      val s = iter.next()
      if(dict.containsKey(s)){ // s is in keywords
        val it = dict.get(s)
        if(Option(it).isEmpty){
          // first time seeing this string from keywords
          numStringsFromKeywordsSeenSoFar += 1
        }
        // dict.put(s,idx) won't work because it does not move entry to the front of the queue if an entry with key s is already
        // present, so we explicitly remove the entry with key s , then put (s,idx)
        dict.remove(s)
        dict.put(s,idx) // linkedhash map preserves the order in which the elements are inserted. so this is the last entry in the linkedhashmap
      }

      if(numStringsFromKeywordsSeenSoFar == keywords.length){
        // we have seen all the strings in keywords, lets go work
        if((result.start == -1 && result.end == -1) || idx - getValueForFirstEntry(dict) < result.end - result.start){
          result.start = getValueForFirstEntry(dict)
          result.end =  idx
        }
      }
      idx += 1
    }
    result
  }

  def getValueForFirstEntry(map: util.LinkedHashMap[String,Integer]): Int = {
    // LinkedHashMap guarantees iteration over key-value pairs takes place in insertion order,most recent first
    map.entrySet().iterator().next().getValue
  }

  def main(args: Array[String]): Unit = {
    val paragraph = Array("A", "B", "C", "D", "E", "F", "A", "E" , "H")
    val keywords = Array("A", "D", "E")
    println(smallestSubArrayCoveringSubset(paragraph, keywords))
  }

}

case class SubArray(var start: Int, var end: Int)
