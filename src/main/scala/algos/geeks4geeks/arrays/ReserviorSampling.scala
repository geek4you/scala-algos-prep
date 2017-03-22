
/**
* Created by geek4you on 03/17/17
*/

/**
 * @see [[http://www.geeksforgeeks.org/reservoir-sampling/]]
 */
object ReserviorSampling{

  def reserviorSampling(stream: Array[Int], k: Int): Array[Int] = {

    // index for elements in stream[]
    var i = 0
    val reservior = new Array[Int](k)
    // reservoir[] is the output array. Initialize it with
    // first k elements from stream[]
    for(i <- 0 to k-1)
      reservior(i) = stream(i)

    // Use a different seed value so that we don't get
    // same result each time we run this program
    val rand = new scala.util.Random(System.currentTimeMillis())

    // Iterate from the (k+1)th element to nth element
    for(idx <- i until stream.length){
      // Pick a random index from 0 to i.
      val j = rand.nextInt(i+1)
      // If the randomly  picked index is smaller than k, then replace
      // the element present at the index with new element from stream
      if(j < k){
        reservior(j) = stream(idx)
      }
    }
    println(s"Following are k randomly selected items ${reservior.mkString(",")}")
    reservior
  }

  def main(args: Array[String]): Unit = {
    val stream = Array[Int](1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    val k = 5
    reserviorSampling(stream, k)
  }
}
