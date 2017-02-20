package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/19/17.
  */
/**
  * [[http://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/]]
  * Given a binary tree and a number, return true if the tree has a root-to-leaf path such that
  * adding up all the values along the path equals the given number.
  * Return false if no such path can be found.
  */
object PathSum extends App {

  def pathSum(node: Node[Int], sum: Int): Boolean = {
    if (Option(node).isEmpty) {
      if (sum == 0)
        true
      else
        false
    } else {
      pathSumUtil(node, 0, sum)
    }
  }

  def pathSumUtil(node: Node[Int], sumTillHere: Int, sum: Int): Boolean = {
    if (Option(node).isDefined) {
      isLeaf(node) match {
        case true => (sumTillHere + node.data) == sum
        case false =>
          pathSumUtil(node.left, sumTillHere + node.data, sum) ||
            pathSumUtil(node.right, sumTillHere + node.data, sum)
      }
    } else {
      sumTillHere == sum
    }
  }

  def isLeaf[A](node: Node[A]): Boolean = {
    if (Option(node).isDefined) {
      if (Option(node.left).isEmpty && Option(node.right).isEmpty)
        true
      else
        false
    } else
      false
  }

  override def main(args: Array[String]): Unit = {
    val root = new Node(10)
    root.left = new Node(8)
    root.right = new Node(2)
    root.left.left = new Node(3)
    root.left.right = new Node(5)
    root.right.left = new Node(2)

    println(pathSum(root, 21))
  }
}
