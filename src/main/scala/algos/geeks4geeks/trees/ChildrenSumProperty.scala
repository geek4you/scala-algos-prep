package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/19/17.
  */
/**
  * [[http://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/]]
  * <p>
  * Given a binary tree, write a function that returns true if the tree satisfies below property.
  * <p>
  * For every node, data value must be equal to sum of data values in left and right children.
  * Consider data value as 0 for NULL children
  */
object ChildrenSumProperty extends App {

  def isSumProperty(node: Node[Int]): Boolean = {
    if (Option(node).isEmpty || (Option(node.left).isEmpty && Option(
          node.right).isEmpty))
      true
    else {
      val leftChild =
        if (Option(node.left).isDefined)
          node.left.data
        else 0

      val rightChild =
        if (Option(node.right).isDefined)
          node.right.data
        else 0

      (node.data == (leftChild + rightChild)) && isSumProperty(node.left) && isSumProperty(
        node.right)
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(10)
    root.left = Node(8)
    root.right = Node(2)
    root.left.left = Node(3)
    root.left.right = Node(5)
    root.right.right = Node(2)

    println(isSumProperty(root))
  }
}
