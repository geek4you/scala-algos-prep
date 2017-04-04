package algos.epi.dp

/**
  * Created by geek4you on 4/3/17.
  */
/**
  * [[NumberOfCombinationsForFinalScore]] in O(n) space
  * @see http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
  */
object NumberOfCombinationsForFinalScoreOnSpace {

  def numCombinationsForFinalScore(finalScore: Int,
                                   individualPlayScores: Array[Int]): Int = {
    // table[i] will be storing the number of solutions for
    // value i. We need n+1 rows as the table is constructed
    // in bottom up manner using the base case (n = 0)
    val table = new Array[Int](finalScore + 1)

    // Base case (If given value is 0)
    table(0) = 1

    for (i <- individualPlayScores.indices) {
      for (j <- individualPlayScores(i) to finalScore)
        table(j) += table(j - individualPlayScores(i))
    }
    table(finalScore)
  }

  def main(args: Array[String]): Unit = {
    val individualPlayScores = Array(2, 3, 7)
    println(numCombinationsForFinalScore(12, individualPlayScores))
  }
}
