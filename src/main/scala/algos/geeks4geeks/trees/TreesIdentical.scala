package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/20/17.
  */
object TreesIdentical extends App {

  def isIdentical[A](node1: Node[A], node2: Node[A]): Boolean = {

    // both empty
    if (Option(node1).isEmpty && Option(node2).isEmpty)
      true
    // only one is empty
    else if (Option(node1).isEmpty || Option(node2).isEmpty)
      false
    else {
      node1.data == node2.data &&
      isIdentical(node1.left, node2.left) &&
      isIdentical(node1.right, node2.right)
    }
  }

  override def main(args: Array[String]): Unit = {
    val root1 = Node(1)
    val root2 = Node(1)
    root1.left = Node(2)
    root1.right = Node(3)
    root1.left.left = Node(4)
    root1.left.right = Node(5)

    root2.left = Node(2)
    root2.right = Node(3)
    root2.left.left = Node(4)
    root2.left.right = Node(5)

    println(isIdentical(root1, root2))
  }
}
