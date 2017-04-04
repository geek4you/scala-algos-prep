package algos.epi.dp

/**
  * Created by geek4you on 4/3/17.
  */
/**
  * Page 312
  */
object NumberOfCombinationsForFinalScore {

  def numCombinationsForFinalScore(finalScore: Int,
                                   individualPlayScores: Array[Int]): Int = {
    val numCombinationsForScore =
      Array.ofDim[Int](individualPlayScores.length, finalScore + 1)

    for (i <- individualPlayScores.indices) {
      numCombinationsForScore(i)(0) = 1 // one way to reach 0
      for (j <- 1 to finalScore) {
        val withOutThisPlay =
          if (i - 1 >= 0) numCombinationsForScore(i - 1)(j) else 0
        val withThisPlay =
          if (j >= individualPlayScores(i))
            numCombinationsForScore(i)(j - individualPlayScores(i))
          else 0
        numCombinationsForScore(i)(j) = withOutThisPlay + withThisPlay
      }
    }
    numCombinationsForScore(individualPlayScores.length - 1)(finalScore)
  }

  def main(args: Array[String]): Unit = {
    val individualPlayScores = Array(2, 3, 7)
    println(numCombinationsForFinalScore(12, individualPlayScores))
  }
}
