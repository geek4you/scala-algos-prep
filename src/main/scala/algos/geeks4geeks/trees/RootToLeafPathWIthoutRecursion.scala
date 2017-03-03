package algos.geeks4geeks.trees

import java.util

import scala.collection.mutable

/**
  * Created by geek4you on 3/2/17.
  */
/**
  * Maintain a map with parent pointers and so preorder. When ever you find a leaf node, print path
  */
// todo: REVISIT
object RootToLeafPathWIthoutRecursion extends App {

  def roottoLeafPath[A](node: Node[A]): Unit = {
    if (Option(node).isDefined) {
      // stores node -> parent
      val map = mutable.Map[Node[A], Node[A]]()
      map += (node -> null)

      val stack = new util.ArrayDeque[Node[A]]()
      stack.push(node)
      while (!stack.isEmpty) {
        var current = stack.pop()
        if (Option(current.right).isDefined) {
          map += (current.right -> current)
          stack.push(current.right)
        }
        if (Option(current.left).isDefined) {
          map += (current.left -> current)
          stack.push(current.left)
        }

        if (Option(current.left).isEmpty && Option(current.right).isEmpty) {
          val list = new mutable.ListBuffer[A]()
          while (Option(current).isDefined) {
            list.append(current.data)
            current = map(current)
          }
          // reverse the list
          println(list.reverse.mkString(","))
        }
      }
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(10)
    root.left = Node(8)
    root.right = Node(2)
    root.left.left = Node(3)
    root.left.right = Node(5)
    root.right.left = Node(2)

    roottoLeafPath(root)
  }
}
