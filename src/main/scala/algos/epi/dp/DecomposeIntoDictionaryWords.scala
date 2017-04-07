package algos.epi.dp

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Created by geek4you on 4/5/17.
  */
/**
  * Page 326
  * @see http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
  */
object DecomposeIntoDictionaryWords {

  def decomposeIntoDictionaryWords(
      domain: String,
      dictionary: mutable.HashSet[String]): mutable.Seq[String] = {

    val lastLength = Array.fill(domain.length)(-1)

    // when the algorithm finishes, lastLength(i) != -1 indicates
    // domain.subString(0, i+1) has a valid decomposition, and the length of the last string
    // in the decomposition will br lastLength(i).

    for (i <- 0 until domain.length) {
      // if domain.subString(0,i+1) is a valid word, set lastLength(i) to the length of the word
      if (dictionary.contains(domain.substring(0, i + 1))) {
        lastLength(i) = i + 1
      }

      // if lastLength(i) == -1 look for j < i such that domain.subString(0,j+1) has a valid
      // decomposition and domain.subString(j+1, i+1) is dictionary word. If so, record the
      // length of that word in lastLength(i)
      if (lastLength(i) == -1) {
        var done = false
        var j = 0
        while (j < i && !done) {
          if (lastLength(j) != -1 && dictionary.contains(
                domain.substring(j + 1, i + 1))) {
            lastLength(i) = i - j
            done = true
          }
          j += 1
        }
      }
    }

    val decompositions = new ListBuffer[String]()
    if (lastLength(lastLength.length - 1) != -1) {
      var idx = domain.length - 1
      while (idx >= 0) {
        decompositions.prepend(
          domain.substring(idx + 1 - lastLength(idx), idx + 1))
        idx -= lastLength(idx)
      }
    }
    decompositions
  }

  def main(args: Array[String]): Unit = {
    val dictionary = new mutable.HashSet[String]()
    dictionary ++= Array("mobile",
                         "samsung",
                         "sam",
                         "sung",
                         "man",
                         "mango",
                         "icecream",
                         "and",
                         "go",
                         "i",
                         "like",
                         "ice",
                         "cream")
    val domain = "ilikesamsung"
    println(decomposeIntoDictionaryWords(domain, dictionary))

  }
}
