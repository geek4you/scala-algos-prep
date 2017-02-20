package algos.geeks4geeks.trees

/**
 * Created by geek4you on 2/19/17.
 */
object CountLeafNodes extends App{

  def countLeafs[A](node: Node[A]): Int = {
    if(Option(node).isDefined){
      isLeaf(node) match {
        case true => 1
        case false => countLeafs(node.left) + countLeafs(node.right)
      }
    }else
      0
  }

  def isLeaf[A](node: Node[A]): Boolean = {
    if (Option(node).isDefined) {
      if (Option(node.left).isEmpty && Option(node.right).isEmpty)
        true
      else
        false
    } else
      false
  }

  override def main(args: Array[String]): Unit = {
    val root = new Node(10)
    root.left = new Node(8)
    root.right = new Node(2)
    root.left.left = new Node(3)
    root.left.right = new Node(5)
    root.right.left = new Node(2)

    println(countLeafs(root))
  }
}
