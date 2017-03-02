package algos.geeks4geeks.trees

/**
  * Created by geek4you on 3/1/17.
  */
// todo: REVISIT
object SumOfCoveredAndUncoveredNodesOfBinaryTree extends App {

  def sumOfLeftBoundary(node: Node[Int]): Int = {
    if (Option(node).isDefined) {
      var current = node
      var sumLeft: Int = 0
      var done = false
      while (!done) {
        while (Option(current.left).isDefined) {
          sumLeft += current.data
          current = current.left
        }

        if (Option(current.right).isDefined) {
          sumLeft += current.data
          current = current.right
        } else{
          sumLeft += current.data
          done = true
        }
      }
      sumLeft
    } else 0
  }

  def sumOfRightBoundary(node: Node[Int]): Int = {
    if (Option(node).isDefined) {
      var current = node
      var sumRight = 0
      while (Option(current).isDefined) {
        if (Option(current.right).isDefined) {
          sumRight += current.data
          current = current.right
        } else if (Option(current.left).isDefined) {
          sumRight += current.data
          current = current.left
        } else {
          sumRight += current.data
          current = null
        }
      }
      sumRight
    } else 0
  }

  def sumOfAllNodes(node: Node[Int], sum: SumHolder): Unit = {
    if (Option(node).isDefined) {
      sum.sum += node.data
      sumOfAllNodes(node.left, sum)
      sumOfAllNodes(node.right, sum)
    }
  }

  def sum(node: Node[Int]): Unit = {
    if (Option(node).isDefined) {
      val leftBSum = sumOfLeftBoundary(node)
      val rightBSum = sumOfRightBoundary(node)
      println(s"Left Boundary sum: $leftBSum")
      println(s"Right Boundary sum: $rightBSum")
      var unCoveredNodes = leftBSum + rightBSum
      val sumHolder = SumHolder(0)
      sumOfAllNodes(node, sumHolder)
      println(s"Total sum: ${sumHolder.sum}")
      var coveredNodes = sumHolder.sum - unCoveredNodes

      println(s"Uncovered: $unCoveredNodes")
      println(s"Covered: $coveredNodes")
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(8)
    root.left = Node(3)

    root.left.left = Node(1)
    root.left.right = Node(6)
    root.left.right.left = Node(4)
    root.left.right.right = Node(7)

    root.right = Node(10)
    root.right.right = Node(14)
    root.right.right.left = Node(13)

    sum(root)
  }
}

case class SumHolder(var sum: Int)
