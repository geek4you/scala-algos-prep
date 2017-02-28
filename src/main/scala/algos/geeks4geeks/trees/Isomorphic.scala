package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/24/17.
  */
/**
  *
  */
object Isomorphic extends App {

  def isIsomorphic[A](node1: Node[A], node2: Node[A]): Boolean = {

    // Both roots are NULL, trees isomorphic by definition
    if (Option(node1).isEmpty && Option(node2).isEmpty)
      true
    // Exactly one of the n1 and n2 is NULL, trees not isomorphic
    else if (Option(node1).isEmpty || Option(node2).isEmpty)
      false
    else if (node1.data != node2.data)
      false
    else {
      // There are two possible cases for n1 and n2 to be isomorphic
      // Case 1: The subtrees rooted at these nodes have NOT been "Flipped".
      // Both of these subtrees have to be isomorphic, hence the &&
      // Case 2: The subtrees rooted at these nodes have been "Flipped"
      (isIsomorphic(node1.left, node2.left) && isIsomorphic(node1.right,
                                                            node2.right)) ||
      (isIsomorphic(node1.left, node2.right) && isIsomorphic(node1.right,
                                                             node2.left))
    }
  }

  override def main(args: Array[String]): Unit = {
    val n1 = new Node(1)
    n1.left = new Node(2)
    n1.right = new Node(3)
    n1.left.left = new Node(4)
    n1.left.right = new Node(5)
    n1.right.left = new Node(6)
    n1.left.right.left = new Node(7)
    n1.left.right.right = new Node(8)

    val n2 = new Node(1)
    n2.left = new Node(3)
    n2.right = new Node(2)
    n2.right.left = new Node(4)
    n2.right.right = new Node(5)
    n2.left.right = new Node(6)
    n2.right.right.left = new Node(8)
    n2.right.right.right = new Node(7)

    println(isIsomorphic(n1, n2))
  }
}
