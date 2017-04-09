package algos.epi.greedy

/**
  * Created by geek4you on 4/8/17.
  */
object TheGasUpProblem {

  case class CityAndRemainingGas(city: Int, remainingGallons: Int)

  val Mpg = 20 // 20 miles per gallon
  /**
    * gallons(i) represents the amount of gas in city i
    * distance(i) represents the distance from city i to next
    */
  def findAmpleCity(gallons: Array[Int], distances: Array[Int]): Int = {
    var remainingGallons = 0
    var min = CityAndRemainingGas(0, 0)
    for (i <- 1 until gallons.length - 1) {
      remainingGallons += gallons(i - 1) - distances(i - 1) / Mpg
      if (remainingGallons < min.remainingGallons)
        min = CityAndRemainingGas(i, remainingGallons)
    }

    min.city
  }

}
