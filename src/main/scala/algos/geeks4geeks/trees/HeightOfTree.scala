package algos.geeks4geeks.trees

import java.util

/**
  * Created by geek4you on 2/19/17.
  */
object HeightOfTree extends App {
  def heightRecursive[A](node: Node[A]): Int = {
    if (Option(node).isEmpty)
      0
    else
      1 + Math.max(heightRecursive(node.left), heightRecursive(node.right))
  }

  def height[A](node: Node[A]): Int = {
    if (Option(node).isEmpty)
      0
    else {
      val queue = new util.LinkedList[Node[A]]()
      queue.add(node)
      var count = 0
      while (!queue.isEmpty) {
        var nodeCount = queue.size()
        count += 1
        while (nodeCount > 0) {
          val current = queue.poll()
          if (Option(current.left).isDefined)
            queue.add(current.left)
          if (Option(current.right).isDefined)
            queue.add(current.right)
          nodeCount -= 1
        }
      }
      count
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)

    println(s"Recursive Height ${heightRecursive(root)}")
    println(s"Iterative Height ${height(root)}")
  }
}
