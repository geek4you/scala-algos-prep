package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/19/17.
  */
object SizeOfTree extends App {
  def size[A](node: Node[A]): Int = {
    if (Option(node).isEmpty)
      0
    else
      1 + size(node.left) + size(node.right)
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)

    println(size(root))
  }
}
