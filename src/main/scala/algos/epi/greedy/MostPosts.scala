package algos.epi.greedy

/**
  * Created by geek4you on 4/8/17.
  */
/**
  * Page 346
  * Majority Element
  */
/*
There is an non negative integer array. Each number represent the author ID of a post in a forum.
We already know that an author writes more than half of all posts in this forum, find this author ID.

Follow up: suppose that three authors each writes more than 1/4 posts in this forum, find the three authors.

Solution for main: find majority element

 Follow up solution: simiar as above, we delete four different Ids each time, the problem condition remains unchanged.
O(n) time, O(1) space
 */

object MostPosts {

  def majorityElement(posts: Array[Int]): Int = {
    var candidate = 0
    var candidateCount = 0
    for (i <- posts.indices) {
      if (candidateCount == 0) {
        candidate = i
        candidateCount = 1
      } else if (posts(i) == posts(candidate))
        candidateCount += 1
      else
        candidateCount -= 1
    }

    // we have a candidate for the majority element
    // check if it is majority element actually
    var count = 0
    for (i <- posts.indices) {
      if (posts(i) == posts(candidate))
        count += 1
    }

    if (count >= posts.length / 2)
      candidate
    else -1
  }

  def followUp(posts: Array[Int]): Candidates = {
    var (count1, count2, count3) = (0, 0, 0)
    var (candidate1, candidate2, candidate3) = (-1, -1, -1)

    for (i <- posts.indices) {
      if (candidate1 != -1 && posts(i) == posts(candidate1)) {
        count1 += 1
      } else if (candidate2 != -1 && posts(i) == posts(candidate2)) {
        count2 += 1
      } else if (candidate3 != -1 && posts(i) == posts(candidate3)) {
        count3 += 1
      } else if (count1 == 0) {
        candidate1 = i
        count1 = 1
      } else if (count2 == 0) {
        candidate2 = i
        count2 = 1
      } else if (count3 == 0) {
        candidate3 = i
        count3 = 1
      } else {
        count1 -= 1
        count2 -= 1
        count3 -= 1
      }
    }

    Candidates(candidate1, candidate2, candidate3)

  }

  def main(args: Array[String]): Unit = {
    val arr1 = Array(1, 2, 3, 5, 3, 2, 1)
    println(followUp(arr1))
  }

  case class Candidates(candidate1: Int, candidate2: Int, candidate3: Int)
}
