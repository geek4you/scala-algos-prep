package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/20/17.
  */
/**
  * Given two Binary Trees, write a function that returns true if two trees are mirror of each other,
  * else false. For example, the function should return true for following input trees.
  *
  * For two trees ‘a’ and ‘b’ to be mirror images, the following three conditions must be true:
  *  1) Their root node’s key must be same
  *  2) Left subtree of root of ‘a’ and right subtree root of ‘b’ are mirror.
  *  3) Right subtree of ‘a’ and left subtree of ‘b’ are mirror.
  */
object CheckIfMirror extends App {
  def mirrorCheck[A](node1: Node[A], node2: Node[A]): Boolean = {

    // Base case : Both empty
    if (Option(node1).isEmpty && Option(node2).isEmpty)
      true
    // If only one is empty
    else if (Option(node1).isEmpty || Option(node2).isEmpty)
      false
    // Both non-empty, compare them recursively Note that in recursive calls, we pass left
    // of one tree and right of other tree
    else
      node1.data == node2.data &&
      mirrorCheck(node1.left, node2.right) &&
      mirrorCheck(node1.right, node2.left)
  }

  override def main(args: Array[String]): Unit = {
    val root1 = Node(1)
    val root2 = Node(1)
    root1.left = Node(2)
    root1.right = Node(3)
    root1.left.left = Node(4)
    root1.left.right = Node(5)

    root2.left = Node(3)
    root2.right = Node(2)
    root2.right.left = Node(5)
    root2.right.right = Node(4)

    println(mirrorCheck(root1, root2))
  }
}
