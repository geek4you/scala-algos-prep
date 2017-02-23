package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/20/17.
  */

/**
  * [[http://www.geeksforgeeks.org/double-tree/]]
  * Double Tree
  * Write a program that converts a given tree to its Double tree. To create Double tree of the given tree, create a new duplicate for each node, and insert the duplicate as the left child of the original node.
  */
object DoubleTree extends App {

  /**
    * Top down
    */
  def makeDoubleTree[A](node: Node[A]): Unit = {
    if (Option(node).isDefined) {
      if (Option(node.left).isDefined) {
        val leftChild = node.left
        node.left = Node(node.data)
        node.left.left = leftChild
        makeDoubleTree(leftChild)
      } else {
        node.left = Node(node.data)
      }
      makeDoubleTree(node.right)
    }
  }

  /**
    * Bottom-up
    */
  def doubleTree[A](root: Node[A]): Unit = {
    if (Option(root).isDefined) {
      // left and right sub trees
      doubleTree(root.left)
      doubleTree(root.right)

      // process this node.
      val tmp = new Node(root.data)
      tmp.left = root.left
      root.left = tmp
      root
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)

    println(s"Inorder traversal : ${InOrderTraversal.inorder(root)}")
    doubleTree(root)
    println(s"Inorder traversal : ${InOrderTraversal.inorder(root)}")
  }

}
