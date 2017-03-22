package algos.tries

import scala.collection.mutable

/**
  * Created by geek4you on 3/21/17.
  */
class Trie {

  val root = new TrieNode1()

  def insert(keys: Array[Int]): Unit = {
    var tCrawl = root
    keys.foreach(key => {
      if (!tCrawl.children.contains(key)) {
        tCrawl.children += (key -> new TrieNode1())
      }
      tCrawl = tCrawl.children(key)
    })
    tCrawl.isEnd = true
  }

  def search(keys: Array[Int]): Boolean = {
    var tCrawl = root

    keys.foreach(key => {
      if (!tCrawl.children.contains(key)) {
        return false
      }
      tCrawl = tCrawl.children(key)
    })

    tCrawl.isEnd
  }
}

case class TrieNode1(var prefixCount: Int,
                     children: mutable.Map[Int, TrieNode1],
                     var isEnd: Boolean) {
  def this() = this(0,  mutable.Map[Int, TrieNode1](), false)
}

object TrieNode1 {
  def apply() = new TrieNode1()
}
