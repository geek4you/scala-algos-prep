package algos.geeks4geeks.trees

/**
  * Created by geek4you on 3/2/17.
  */
/**
  * Density = size/height
  */
object DensityOfTreeInOneTraversal extends App {

  /**
    * returns the height of the tree
    * size contains the size of the tree
    */
  def densityUtil[A](node: Node[A], size: Size): Int = {
    if (Option(node).isDefined) {
      val left = densityUtil(node.left, size)
      val right = densityUtil(node.right, size)

      size.size += 1

      Math.max(left, right) + 1
    } else 0
  }

  def density[A](node: Node[A]): Int = {
    val size = Size(0)
    val height = densityUtil(node, size)
    size.size / height
  }

  override def main(args: Array[String]): Unit = {
    val root = new Node(1)
    root.left = new Node(2)
    root.right = new Node(3)
    println(density(node = root))
  }
}

case class Size(var size: Int)
