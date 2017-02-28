package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/22/17.
  */
/**
  * [[http://www.geeksforgeeks.org/foldable-binary-trees/]]
  * A tree can be folded if left and right subtrees of the tree are structure wise mirror image of each other.
  * An empty tree is considered as foldable.
  * Consider the below trees:
  * (a) and (b) can be folded.
  * (c) and (d) cannot be folded.
  * <p>
  * (a)
  *      10
  *    /    \
  *   7      15
  *    \    /
  *    9  11
  * <p>
  * (b)
  *      10
  *     /  \
  *    7    15
  *   /      \
  *  9       11
  * <p>
  * (c)
  *       10
  *      /  \
  *     7   15
  *    /    /
  *   5   11
  * <p>
  * (d)
  * <p>
  *      10
  *     /   \
  *    7     15
  *   /  \    /
  *  9   10  12
  */
object FoldableBinaryTree extends App {

  def isFoldable[A](node: Node[A]): Boolean = {
    if (Option(node).isEmpty)
      true
    else
      isFoldableUtil(node.left, node.right)

  }

  def isFoldableUtil[A](node1: Node[A], node2: Node[A]): Boolean = {
    if (Option(node1).isEmpty && Option(node2).isEmpty)
      true
    else if (Option(node1).isEmpty || Option(node2).isEmpty)
      false
    else
      isFoldableUtil(node1.left, node2.right) && isFoldableUtil(node1.right,
                                                                node2.left)
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.right.left = Node(4)
    root.left.right = Node(5)

    println(isFoldable(root))
  }
}
