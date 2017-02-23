package algos.geeks4geeks.trees

import java.util

/**
  * Created by geek4you on 2/20/17.
  */
/**
  * We can print spiral order traversal in O(n) time and O(n) extra space. The idea is to use two stacks.
  * We can use one stack for printing from left to right and other stack for printing from right to left.
  * In every iteration, we have nodes of one level in one of the stacks.
  * We print the nodes, and push nodes of next level in other stack.
  */
object LevelOrderTraversalSpiral extends App {
  def printSpiral[A](node: Node[A]): Unit = {
    if (Option(node).isDefined) {
      val stack1 = new util.ArrayDeque[Node[A]]()
      val stack2 = new util.ArrayDeque[Node[A]]()

      stack1.push(node)
      while (!stack1.isEmpty || !stack2.isEmpty) {

        while (!stack1.isEmpty) {
          val currentNode = stack1.pop()
          println(currentNode.data)
          if (Option(currentNode.left).isDefined)
            stack2.push(currentNode.left)
          if (Option(currentNode.right).isDefined)
            stack2.push(currentNode.right)
        }

        while (!stack2.isEmpty) {
          val currentNode = stack2.pop()
          println(currentNode.data)
          if (Option(currentNode.right).isDefined)
            stack1.push(currentNode.right)
          if (Option(currentNode.left).isDefined)
            stack1.push(currentNode.left)
        }

      }
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(20)
    root.left = Node(8)
    root.right = Node(22)
    root.left.left = Node(4)
    root.left.right = Node(12)
    root.left.right.left = Node(10)
    root.left.right.right = Node(14)

    printSpiral(root)
  }
}
