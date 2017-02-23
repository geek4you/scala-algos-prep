package algos.geeks4geeks.trees

import java.util

/**
  * Created by geek4you on 2/20/17.
  */
/**
  * http://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/
  * Given a binary tree, print out all of its root-to-leaf paths one per line.
  */
object PrintRootToLeafPaths extends App {

  def printRootToLeafPaths[A](node: Node[A]): Unit = {
    if (Option(node).isDefined)
      printRootToLeafPathsUtil(node, new util.ArrayList(), 0)
  }

  def printRootToLeafPathsUtil[A](node: Node[A],
                                  list: util.ArrayList[A],
                                  index: Int): Unit = {
    if (Option(node).isDefined) {
      list.add(index, node.data)
      if (Option(node.left).isEmpty && Option(node.right).isEmpty) {
        for (i <- 0 to index)
          print(list.get(i))
        println()
      } else {
        printRootToLeafPathsUtil(node.left, list, index + 1)
        printRootToLeafPathsUtil(node.right, list, index + 1)
      }
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    printRootToLeafPaths(root)
  }
}
