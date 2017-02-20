package algos.geeks4geeks.trees

import java.util

/**
  * Created by geek4you on 2/19/17.
  */
/**
  * breadth first traversal
  */
object LevelOrderTraversal extends App {

  /**
   * printLevelorder(tree)
    1) Create an empty queue q
    2) temp_node = root /*start from root*/
    3) Loop while temp_node is not NULL
      a) print temp_node->data.
      b) Enqueue temp_node’s children (first left then right children) to q
      c) Dequeue a node from q and assign it’s value to temp_node
   */
  def lvlOrder[A](node: Node[A]): Unit = {
    if (Option(node).isDefined) {
      val queue = new util.ArrayDeque[Node[A]]()
      queue.add(node)
      while (!queue.isEmpty) {
        val current = queue.poll()
        println(current.data)
        if (Option(current.left).isDefined)
          queue.add(current.left)
        if (Option(current.right).isDefined)
          queue.add(current.right)
      }
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    lvlOrder(root)
  }
}
