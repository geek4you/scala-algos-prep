package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/22/17.
  */
/**
  *
  */
object PrintAncestorsOfGivenNode {

  def printAncestors[A](node: Node[A], key: A): Boolean = {
    if (Option(node).isEmpty)
      false
    else if (node.data == key) {
      true
    } else {
      if (printAncestors(node.left, key) || printAncestors(node.right, key)) {
        println(node.data)
        true
      } else
        false
    }

  }

}
