package algos.epi.ninja

import scala.collection.mutable

/**
  * Created by geek4you on 4/15/17.
  */
/**
  * Page 474
  */
object FindShortestUniquePrefix {

  def findShortestUniquePrefix(inputString: String,
                               dictionary: mutable.HashSet[String]): String = {
    val trie = new Trie()

    // insert all into trie
    dictionary.foreach(s => trie.insert(s))
    trie.shortestUniquePrefix(inputString)
  }

  def main(args: Array[String]): Unit = {
    val dict = new mutable.HashSet[String]()
    dict ++= Array[String]("dog", "be", "cut")
    val inputString = "cat"
    println(findShortestUniquePrefix(inputString, dict))
  }
}

class Trie {
  val root = new TrieNode()

  /**
    * Returns true if s is not already present in the trie and inserts into the trie
    * returns false if s is not already present in the trie
    */
  def insert(s: String): Boolean = {
    var tCrawl = root
    for (i <- 0 until s.length) {
      val ch = s.charAt(i)
      if (!tCrawl.getLeaves().contains(ch)) {
        tCrawl.getLeaves() += (ch -> new TrieNode)
      }
      tCrawl = tCrawl.getLeaves()(ch)
    }
    // s already exists in the trie, set isString
    if (!tCrawl.getIsString()) {
      tCrawl.setIsString(true)
      true
    } else { // already present in the tries
      false
    }
  }

  def shortestUniquePrefix(s: String): String = {
    var tCrawl = root
    val builder = new mutable.StringBuilder()
    var i = 0
    var done = false
    while (i < s.length && !done) {
      val ch = s.charAt(i)
      builder += ch
      if (tCrawl.getLeaves().contains(ch)) {
        tCrawl = tCrawl.getLeaves()(ch)
      } else {
        done = true
      }
      i += 1
    }
    builder.toString()
  }

}

case class TrieNode() {
  private var isString = false
  private val leaves = mutable.Map[Char, TrieNode]()
  def getIsString(): Boolean = isString
  def setIsString(string: Boolean): Unit = { isString = string }
  def getLeaves() = leaves
}
