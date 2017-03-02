package algos.geeks4geeks.trees

import scala.collection.mutable

/**
  * Created by geek4you on 2/27/17.
  */
/**
  * [[http://www.geeksforgeeks.org/diagonal-sum-binary-tree/]]
  */
object DiagnolSumBinaryTree extends App {

  def diagnolSumUtil(node: Node[Int],
                     diagLvl: Int,
                     map: mutable.Map[Int, Int]): Unit = {
    if (Option(node).isDefined) {
      if (map.contains(diagLvl)) {
        map(diagLvl) = map(diagLvl) + node.data
      } else {
        map(diagLvl) = node.data
      }

      diagnolSumUtil(node.right, diagLvl, map)
      diagnolSumUtil(node.left, diagLvl + 1, map)
    }
  }

  def diagnolSum(node: Node[Int]): Unit = {
    // stores diagnol-level -> sum
    val map = new mutable.HashMap[Int, Int]()
    if (Option(node).isDefined) {
      diagnolSumUtil(node, 0, map)
      map.foreach {
        case (_: Int, y: Int) => println(y)
      }
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(9)
    root.left.right = Node(6)
    root.right.left = Node(4)
    root.right.right = Node(5)
    root.right.left.left = Node(12)
    root.right.left.right = Node(7)
    root.left.right.left = Node(11)
    root.left.left.right = Node(10)

    diagnolSum(root)
  }

}
