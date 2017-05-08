package algos.epi.binarytrees

/**
  * Created by geek4you on 5/6/17.
  */
case class Node[A](var data: A, var left: Node[A], var right: Node[A]) {
  def this(value: A) = this(value, null, null)
  override def toString: String = {
    s"Node{val: $data, left: $left, right: $right}"
  }
}

object Node {
  def apply[A](value: A): Node[A] = new Node[A](value, null, null)
}
