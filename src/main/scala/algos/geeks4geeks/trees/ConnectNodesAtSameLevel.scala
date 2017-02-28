package algos.geeks4geeks.trees

import java.util

/**
  * Created by geek4you on 2/23/17.
  */
/**
  *
  * Input Tree
  *
       A
      / \
     B   C
    / \   \
   D   E   F

    Output Tree

       A--->NULL
      / \
     B-->C-->NULL
    / \   \
   D-->E-->F-->NULL

  * Solution1: Level order traversal
  *[[http://www.geeksforgeeks.org/connect-nodes-at-same-level/]]
  *
  * Solution2: Preorder traversal but only works for Balanced trees
  *
  * Optimized Solution:
  * [[http://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/]]
  */
// todo: REVISIT
// FIXME: Implement Optimized Solution
object ConnectNodesAtSameLevel extends App {

  def connectSameLvlNodesUsingLvlOrder[A](
      node: NodeWithNextRightPointer[A]): Unit = {
    if (Option(node).isDefined) {
      val queue = new util.ArrayDeque[NodeWithNextRightPointer[A]]()
      queue.add(node)
      while (!queue.isEmpty) {
        var nodeCount = queue.size()
        var prev: NodeWithNextRightPointer[A] = null
        while (nodeCount > 0) {
          val current = queue.poll()
          if (Option(prev).isDefined)
            prev.nextRight = current
          if (Option(current.left).isDefined)
            queue.add(current.left)
          if (Option(current.right).isDefined)
            queue.add(current.right)
          prev = current
          nodeCount -= 1
        }
      }
    }
  }

  override def main(args: Array[String]): Unit = {

    /* Constructed binary tree is
          10
        /   \
      8      2
    /         \
  3            90
     */
    val root = NodeWithNextRightPointer(10)
    root.left = NodeWithNextRightPointer(8)
    root.right = NodeWithNextRightPointer(2)
    root.left.left = NodeWithNextRightPointer(3)
    root.right.right = NodeWithNextRightPointer(90)
    connectSameLvlNodesUsingLvlOrder(root)

    println(s"Next right of 8 is ${root.left.nextRight.data}")
    println(s"Next right of 2 is ${root.right.nextRight}")
    println(s"Next right of 3 is ${root.left.left.nextRight.data}")
    println(s"Next right of 90 is ${root.right.right.nextRight}")
  }
}

case class NodeWithNextRightPointer[A](
    data: A,
    var left: NodeWithNextRightPointer[A],
    var right: NodeWithNextRightPointer[A],
    var nextRight: NodeWithNextRightPointer[A]) {
  def this(data: A) = this(data, null, null, null)
}

object NodeWithNextRightPointer {
  def apply[A](value: A): NodeWithNextRightPointer[A] =
    new NodeWithNextRightPointer(value)
}
