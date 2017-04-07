package algos.epi.dp

/**
  * Created by geek4you on 4/4/17.
  */
/**
  * Page : 314
  * @see [[http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/]]
  */
object LevenshteinDistance {

  /**
    * Solution without Dp. Meaning no caching of the sub problem results.
    */
  def editDistanceRecursive(missSpelledWord: String,
                            correctWord: String,
                            idx1: Int,
                            idx2: Int): Int = {

    // If first string is empty, the only option is to
    // insert all characters of second string into first
    if (idx1 < 0)
      idx2 + 1
    else

    // If second string is empty, the only option is to
    // remove all characters of first string
    if (idx2 < 0)
      idx1 + 1
    else

    // If last characters of two strings are same, nothing
    // much to do. Ignore last characters and get count for
    // remaining strings.
    if (missSpelledWord.charAt(idx1) == correctWord.charAt(idx2)) {
      editDistanceRecursive(missSpelledWord, correctWord, idx1 - 1, idx2 - 1)
    }

    // If last characters are not same, consider all three
    // operations on last character of first string, recursively
    // compute minimum cost for all three operations and take
    // minimum of three values.
    else {
      1 +
        Math.min(
          Math.min(
            // replace in this case
            editDistanceRecursive(missSpelledWord,
                                  correctWord,
                                  idx1 - 1,
                                  idx2 - 1),
            //add in this case
            editDistanceRecursive(missSpelledWord, correctWord, idx1, idx2 - 1)
          ),
          // delete in this case
          editDistanceRecursive(missSpelledWord, correctWord, idx1 - 1, idx2)
        )
    }
  }

  def levenshteinDistance(missSpelledWord: String, correctWord: String): Int = {
    val distanceBetweenPrefixes =
      Array.tabulate(missSpelledWord.length, correctWord.length)((i, j) => -1)
    computeDistanceBetweenPrefixes(missSpelledWord,
                                   correctWord,
                                   missSpelledWord.length - 1,
                                   correctWord.length - 1,
                                   distanceBetweenPrefixes)

  }

  def computeDistanceBetweenPrefixes(
      missSpelledWord: String,
      correctWord: String,
      missSpelledIdx1: Int,
      correctWordIdx2: Int,
      distanceBtwPrefixes: Array[Array[Int]]): Int = {
    if (missSpelledIdx1 < 0)
      // missSpelledWord is empty. so add all chars from correctWord
      return correctWordIdx2 + 1
    if (correctWordIdx2 < 0)
      // correctWord is empty. so delete all the chars from missSpelledWord
      return missSpelledIdx1 + 1

    if (distanceBtwPrefixes(missSpelledIdx1)(correctWordIdx2) == -1) {
      // If last characters of two strings are same, nothing
      // much to do. Ignore last characters and get count for
      // remaining strings.
      if (missSpelledWord.charAt(missSpelledIdx1) == correctWord.charAt(
            correctWordIdx2)) {
        distanceBtwPrefixes(missSpelledIdx1)(correctWordIdx2) =
          computeDistanceBetweenPrefixes(missSpelledWord,
                                         correctWord,
                                         missSpelledIdx1 - 1,
                                         correctWordIdx2 - 1,
                                         distanceBtwPrefixes)
      } else {
        // If last characters are not same, consider all three
        // operations on last character of first string, take
        // minimum of three values.
        val substituteLast = computeDistanceBetweenPrefixes(
          missSpelledWord,
          correctWord,
          missSpelledIdx1 - 1,
          correctWordIdx2 - 1,
          distanceBtwPrefixes)

        val addLast = computeDistanceBetweenPrefixes(missSpelledWord,
                                                     correctWord,
                                                     missSpelledIdx1,
                                                     correctWordIdx2 - 1,
                                                     distanceBtwPrefixes)

        val deleteLast = computeDistanceBetweenPrefixes(missSpelledWord,
                                                        correctWord,
                                                        missSpelledIdx1 - 1,
                                                        correctWordIdx2,
                                                        distanceBtwPrefixes)
        distanceBtwPrefixes(missSpelledIdx1)(correctWordIdx2) = 1 + Math.min(
          substituteLast,
          Math.min(addLast, deleteLast))
      }

    }
    distanceBtwPrefixes(missSpelledIdx1)(correctWordIdx2)

  }

  def main(args: Array[String]): Unit = {
    val missSpelledWord1 = "Carthorse"
    val correctWord1 = "Orchestra"
    val missSpelledWord = "Saturday"
    val correctWord = "Sundays"
    println(
      editDistanceRecursive(missSpelledWord,
                            correctWord,
                            missSpelledWord.length - 1,
                            correctWord.length - 1))

    println(levenshteinDistance(missSpelledWord1, correctWord))
  }

}
