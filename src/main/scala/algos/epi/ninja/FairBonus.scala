package algos.epi.ninja

import scala.collection.mutable

/**
  * Created by geek4you on 4/15/17.
  */
/**
  * Page 464
  */
object FairBonus {

  def optimizedCalculateBonuses(productivities: Array[Int]): Array[Int] = {
    // initially assigns one ticket to everyone
    val tickets = Array.fill(productivities.length)(1)

    // from left to right
    for (i <- 1 until productivities.length) {
      if (productivities(i) > productivities(i - 1)) {
        tickets(i) = tickets(i - 1) + 1
      }
    }

    // from right to left
    for (i <- productivities.length - 2 to 0 by -1) {
      if (productivities(i) > productivities(i + 1)) {
        tickets(i) = Math.max(tickets(i), tickets(i + 1) + 1)
      }
    }
    tickets
  }

  def calculateBonuses(productivities: Array[Int]): Array[Int] = {
    val minHeap = new mutable.PriorityQueue[EmployeeData]()

    // add all the elements to the priority queue
    for (i <- productivities.indices) {
      minHeap.enqueue(EmployeeData(productivities(i), i))
    }

    // initially assigns one ticket to everyone
    val tickets = Array.fill(productivities.length)(1)
    // fills from lowest rating to highest rating
    while (minHeap.nonEmpty) {
      val p = minHeap.head
      val nextDev = p.index

      // Handles left neighbour
      if (nextDev > 0) {
        if (productivities(nextDev) > productivities(nextDev - 1)) {
          tickets(nextDev) = tickets(nextDev - 1) + 1
        }
      }

      // handles right neighbour
      if (nextDev < productivities.length - 1) {
        if (productivities(nextDev) > productivities(nextDev + 1)) {
          tickets(nextDev) = Math.max(
            tickets(nextDev),
            tickets(nextDev + 1) + 1) // tickets (nextDev) might be incremented by the left neighbour condition. So don't increment one more. Use max function.
        }
      }
      minHeap.dequeue()
    }
    tickets
  }

  case class EmployeeData(productivity: Int, index: Int)
      extends Ordered[EmployeeData] {
    override def compare(that: EmployeeData): Int =
      if ((that.productivity compare this.productivity) == 0)
        that.index compare this.index
      else that.productivity compare this.productivity
  }

  def main(args: Array[String]): Unit = {
    val productivities = Array(300, 400, 500, 200)
    println(calculateBonuses(productivities).mkString(", "))
    println(optimizedCalculateBonuses(productivities).mkString(", "))
  }
}
