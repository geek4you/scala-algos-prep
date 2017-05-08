package algos.epi.binarysearchtree

/**
  * Created by geek4you on 5/7/17.
  */
case class Node[A](data: A, left: Node[A], right: Node[A]) {
  def this(data: A) = this(data, null, null)
}
object Node {
  def apply[A](data: A) = new Node(data)
}
