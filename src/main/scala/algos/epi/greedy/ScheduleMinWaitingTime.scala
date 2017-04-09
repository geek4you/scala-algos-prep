package algos.epi.greedy

/**
  * Created by geek4you on 4/7/17.
  */
object ScheduleMinWaitingTime {

  def minimumTotalWaitingTIme(serviceTimes: Array[Int]): Int = {
    // sort the times in increasing times
    val sortedServiceTimes = serviceTimes.sorted

    var totalWaitingTime = 0
    for (i <- serviceTimes.indices) {
      var numRemainingWaiting = serviceTimes.size - (i + 1)
      totalWaitingTime += sortedServiceTimes(i) * numRemainingWaiting
    }
    totalWaitingTime
  }

  def main(args: Array[String]): Unit = {
    val serviceTimes = Array(2, 5, 1, 3)
    println(minimumTotalWaitingTIme(serviceTimes))
  }
}
