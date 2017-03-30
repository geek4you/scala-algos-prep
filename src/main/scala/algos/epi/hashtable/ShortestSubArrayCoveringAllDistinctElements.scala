package algos.epi.hashtable

import java.util

import scala.collection.mutable

/**
  * Created by geek4you on 3/23/17.
  */
/**
  * Page 224
  *
  * Same as [[SmallestSubArrayCoveringSubset]] with the distinct elements in the array as keywords
  */
object ShortestSubArrayCoveringAllDistinctElements {

  def smallestSubArrayDistinctElements(input: Array[String]): SubArray = {
    val distinctElements = new mutable.HashSet[String]()
    input.foreach(elem => distinctElements += elem)
    val uniqueElements = distinctElements.toArray
    SmallestSubArrayCoveringSubset.smallestSubArrayCoveringSubset(
      input,
      uniqueElements)
  }

  def main(args: Array[String]): Unit = {
    val input = Array("A", "B", "C", "C", "C", "A", "A", "B", "C")
    val result = smallestSubArrayDistinctElements(input)
    println(result)
  }

}
