package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/22/17.
  */
/**
  * [[http://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/]]
  * <p>
  * How to determine if a binary tree is height-balanced?
  * A tree where no leaf is much farther away from the root than any other leaf. Different balancing schemes allow different
  * definitions of “much farther” and different amounts of work to keep them balanced.
  * <p>
  * Consider a height-balancing scheme where following conditions should be checked to determine if a binary tree is balanced.
  * An empty tree is height-balanced. A non-empty binary tree T is balanced if:
  * 1) Left subtree of T is balanced
  * 2) Right subtree of T is balanced
  * 3) The difference between heights of left subtree and right subtree is not more than 1.
  */
object BinaryTreeHeightBalanced extends App {

  /**
    * T(n) = O(n2)
    */
  def isHeightBalanced[A](node: Node[A]): Boolean = {
    if (Option(node).isEmpty)
      true
    else {
      Math.abs(HeightOfTree.height(node.left) - HeightOfTree.height(
        node.right)) < 2 && isHeightBalanced(node.left) && isHeightBalanced(
        node.right)
    }
  }

  /**
    * T(n) = O(n)
    * calculating the height in the same recursion rather than calling a height() function separately
    */
  def isHeightBalancedOptimized[A](node: Node[A],
                                   heightHolder: HeightHolder): Boolean = {
    if (Option(node).isEmpty) {
      heightHolder.height = 0
      true
    } else {
      val lh = HeightHolder(0)
      val rh = HeightHolder(0)
      val isLeftBalanced = isHeightBalancedOptimized(node.left, lh)
      val isRightBalanced = isHeightBalancedOptimized(node.right, rh)

      heightHolder.height = 1 + Math.max(lh.height, rh.height)

      isLeftBalanced && isRightBalanced && Math.abs(lh.height - rh.height) < 2

    }
  }

  override def main(args: Array[String]): Unit = {
    val root1 = Node(1)
    root1.left = Node(2)
    root1.right = Node(3)
    root1.left.left = Node(4)
    root1.left.right = Node(5)
    root1.left.left.left = Node(8)

    println(isHeightBalancedOptimized(root1, HeightHolder(0)))

    val root2 = Node(1)
    root2.left = Node(2)
    root2.right = Node(3)
    root2.left.left = Node(4)
    root2.left.right = Node(5)

    println(isHeightBalancedOptimized(root2, HeightHolder(0)))
  }

}
