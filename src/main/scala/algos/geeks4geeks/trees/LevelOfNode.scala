package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/19/17.
  */
object ølLevelOfNode extends App {

  def level[A](node: Node[A], a: A): Int = {
    if (Option(node).isEmpty)
      -1
    else
      lvlUtil(node, a, 1)
  }

  def lvlUtil[A](node: Node[A], a: A, lvl: Int): Int = {
    if (Option(node).isDefined) {
      if (node.data == a)
        lvl
      else {
        val tmp = lvlUtil(node.left, a, lvl + 1)
        if (tmp != -1)
          tmp
        else
          lvlUtil(node.right, a, lvl + 1)
      }
    } else
      -1
  }
  override def main(args: Array[String]): Unit = {
    val root = new Node(3)
    root.left = new Node(2)
    root.right = new Node(5)
    root.left.left = new Node(1)
    root.left.right = new Node(4)

    for (i <- 1 to 5) {
      println(s"level of $i : ${level(root, i)}")
    }
  }
}
