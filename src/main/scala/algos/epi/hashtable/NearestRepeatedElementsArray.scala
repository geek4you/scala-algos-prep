package algos.epi.hashtable

import scala.collection.mutable

/**
  * Created by geek4you on 3/16/17.
  */
object NearestRepeatedElementsArray {

  /**
    * Returns the distance of the nearest repeated elements
    */
  def neareashRepeatedElements(arr: Array[String]): Int = {
    val elemToLatestSeenIndex =  mutable.Map[String, Int] ()
    var minDist = Int.MaxValue
    for(i<- arr.indices){
      if(elemToLatestSeenIndex.contains(arr(i))){
        val lastSeenIndex = elemToLatestSeenIndex(arr(i))
        minDist = Math.min(minDist, i - lastSeenIndex)
        elemToLatestSeenIndex.remove(arr(i))
        elemToLatestSeenIndex(arr(i)) = i
      }else
        elemToLatestSeenIndex += (arr(i) -> i)
    }
    minDist
  }

  def main(args: Array[String]): Unit = {
    val arr = Array("All", "work", "and", "no", "play", "makes", "for", "no", "work", "no", "fun", "and","no", "results")
    println(neareashRepeatedElements(arr))
  }
}
