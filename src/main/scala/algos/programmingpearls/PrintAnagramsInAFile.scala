package algos.programmingpearls

import scala.collection.mutable.ListBuffer

/**
  * Created by geek4you on 3/3/17.
  */
/**
  * Two words are anagrams if each other can be formed by permuting the letters of the other word.
  *
  * 1) Do permutations of the word and check al words. Takes Decades.
  * 2) Compared all the words. Takes 15 hrs.
  * 3) Sign each word such that all the anagrams have the same sign and bring the words together with equal signatures.
  * This divides the problem into two sub-problems.
  *   a) selecting a signature
  *   b) collecting the words with same signature
  *
  * solutiion1:
  * a) -> sorting the individual words
  * b) -> sorting the whole list of words based on signatures.
  *
  * other selection of signs:
  * a) sort and then representing the duplicates by a count
  * mississippi -> i4m1p2s4 / i4mp2s4 if 1's are deleted
  * b) 26 Integer array to tell how many times a character appears
  *
  */
object PrintAnagramsInAFile {

  /**
    * Also prints words which don't have anagrams
    */
  def printAnagramsTogether(arr: Array[String]): Unit = {
    val list = new ListBuffer[WordWithSign]()
    arr.foreach { elem =>
      list.append(WordWithSign(elem, getWordSignature(elem)))
    }
    val soretedList = list.sortBy(word => word.sign)
    soretedList.foreach(x => println(x.word))
  }

  def getWordSignature(word: String): String = {
    new String(word.toCharArray.sorted) // todo: counting sort might be faster since all elems are chars.
  }

  def main(args: Array[String]): Unit = {
    val arr = Array[String]("cat", "dog", "tac", "god", "act", "gdo")
    printAnagramsTogether(arr)
  }
}

case class WordWithSign(word: String, sign: String)
