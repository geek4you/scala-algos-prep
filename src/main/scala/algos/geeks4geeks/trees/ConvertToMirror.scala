package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/20/17.
  */
/**
  * Write an Efficient Function to Convert a Binary Tree into its Mirror Tree
  * Mirror of a Tree: Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children
  * of allnon-leaf nodes interchanged.
  */
object ConvertToMirror extends App {

  //bottom - up approach

  /*
   //bottom - up approach

  Change a tree so that the roles of the  left and
    right pointers are swapped at every node.

 So the tree...
       4
      / \
     2   5
    / \
   1   3

 is changed to...
       4
      / \
     5   2
        / \
       3   1
   */
  def convertToMirror[A](node: Node[A]): Node[A] = {
    if (Option(node).isDefined) {
      val left = convertToMirror(node.left)
      val right = convertToMirror(node.right)
      node.left = right
      node.right = left
      node
    } else
      null
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)

    println(s"preorder : ${PreOrderTraversal.preOrder(root)}")
    println(s"prorder: ${PreOrderTraversal.preOrder(convertToMirror(root))}")
  }
}
