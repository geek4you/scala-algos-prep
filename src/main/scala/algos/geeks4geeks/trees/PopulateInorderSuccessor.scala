package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/23/17.
  */
/**
  * [[http://www.geeksforgeeks.org/populate-inorder-successor-for-all-nodes/]]
  * Since it is difficult to keep track of the next node we can do a reverse inorder traversal and
  * keep track of prev node.
  */
// todo: REVISIT
object PopulateInorderSuccessor {

  def inOrderSuccessor[Int](node: NodeWithNextPointer[Int],
                            successor: NodeWithNextPointer[Int]): Unit = {
    if (Option(node).isDefined) {
      // traverse the right child first (reverse inorder)
      inOrderSuccessor(node.right, successor)
      node.next = successor
      // traverse the left child
      inOrderSuccessor(node.left, node)
    }
  }
}

case class NodeWithNextPointer[A](data: A,
                                  var left: NodeWithNextPointer[A],
                                  var right: NodeWithNextPointer[A],
                                  var next: NodeWithNextPointer[A]) {
  def this(data: A) = this(data, null, null, null)
}

object NodeWithNextPointer {
  def apply[A](value: A): NodeWithNextPointer[A] =
    new NodeWithNextPointer[A](value)
}
