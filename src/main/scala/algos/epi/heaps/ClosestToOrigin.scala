package algos.epi.heaps

/**
  * Created by geek4you on 3/13/17.
  */
/**
  * Page 183
  */
case class Star(x: Int, y: Int, z: Int) {
  def distance: Double = {
    math.sqrt(x * x + y * y + z * z)
  }
}

object StarOrdering extends Ordering[Star] {
  val origin = Star(0, 0, 0)
  override def compare(x: Star, y: Star): Int = {
    x.distance.compare(y.distance)
  }
}

class ClosestToOrigin {

  def findClosestStarsToOrigin(stars: Iterator[Star], k: Int): List[Star] = {
    val maxHeap = scala.collection.mutable.PriorityQueue[Star]()(StarOrdering)
    while (stars.hasNext) {
      maxHeap += stars.next()
      if (maxHeap.size > k) {
        maxHeap.dequeue()
      }
    }
    maxHeap.toList.sorted(StarOrdering)
  }
}
