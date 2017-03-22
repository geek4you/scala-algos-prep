package algos.tries

import scala.collection.mutable

/**
  * Created by geek4you on 3/21/17.
  */
case class TrieNode[A](var prefixCount: Int,
                       children: mutable.Map[A, TrieNode[A]],
                       var isEnd: Boolean) {
  def this() = this(0, mutable.Map[A, TrieNode[A]](), false)
}

object TrieNode {
  def apply() = new TrieNode()
}
