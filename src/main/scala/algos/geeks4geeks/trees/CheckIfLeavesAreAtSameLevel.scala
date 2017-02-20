package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/19/17.
  */
/**
  * Check if all leaves are at same level
  * Given a Binary Tree, check if all leaves are at same level or not.
  */
object CheckIfLeavesAreAtSameLevel extends App {

  def leftMostLeafLevel[A](node: Node[A]): Int = {
    if (Option(node).isDefined) {
      var current = node
      var count = 0
      while (Option(current.left).isDefined || Option(current.right).isDefined) {
        if (Option(current.left).isDefined) {
          current = current.left
        } else {
          current = current.right
        }
        count += 1
      }
      count
    } else {
      0
    }
  }

  def check[A](node: Node[A]): Boolean = {
    val leftMostLeafLvl = leftMostLeafLevel(node)
    checkUtil(node, 0, leftMostLeafLvl)
  }

  def checkUtil[A](node: Node[A], lvl: Int, leftMostLeafLvl: Int): Boolean = {
    if (Option(node).isEmpty) {
      true
    } else if (isLeaf(node)) {
      lvl == leftMostLeafLvl
    } else {
      checkUtil(node.left, lvl + 1, leftMostLeafLvl) &&
      checkUtil(node.right, lvl + 1, leftMostLeafLvl)
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
    val root = Node(12)
    root.left = Node(5)
    root.left.left = Node(3)
    root.left.right = Node(9)
    root.left.left.left = Node(1)
    root.left.right.left = Node(1)
    println(check(root))
  }

}
