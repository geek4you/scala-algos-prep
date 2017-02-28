package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/23/17.
  */
/**
  * HashMap : [[http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/]]
  * Space Optimized :[[http://www.geeksforgeeks.org/vertical-sum-in-binary-tree-set-space-optimized/]]
  * Vertical Sum in a given Binary Tree
  * Given a Binary Tree, find vertical sum of the nodes that are in same vertical line. Print all sums through
  * different vertical lines.
  * Examples:
  *
  *         1
  *       /   \
  *      2      3
  *     / \    / \
  *   4   5   6   7
  *
  * The tree has 5 vertical lines
  *
  * Vertical-Line-1 has only one node 4 => vertical sum is 4
  * Vertical-Line-2: has only one node 2=> vertical sum is 2
  * Vertical-Line-3: has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12
  * Vertical-Line-4: has only one node 3 => vertical sum is 3
  * Vertical-Line-5: has only one node 7 => vertical sum is 7
  *
  * So expected output is 4, 2, 12, 3 and 7
  */
object VerticalSumInTree extends App {

  var map: scala.collection.mutable.Map[Int,Int] = _


  def verticalSum(node: Node[Int]): Unit = {
    if (Option(node).isDefined) {
      map = scala.collection.mutable.Map[Int,Int]()

      verticalSumUtil(node, 0)
      map.mkString(" ")
    }
  }

  def verticalSumUtil(node: Node[Int], horizontalDist: Int): Unit = {
    if (Option(node).isDefined) {
      if(map.contains(horizontalDist)){
        map(horizontalDist) += node.data
      }else{
        map(horizontalDist) = node.data
      }


      verticalSumUtil(node.left, horizontalDist - 1)
      verticalSumUtil(node.right, horizontalDist + 1)
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)

    verticalSum(root)
  }
}
