package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/22/17.
  */
/**
  *
  * [[http://www.geeksforgeeks.org/diameter-of-a-binary-tree/]]
  *
  * The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two leaves in
  * the tree. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path
  * are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
  *
  * The diameter of a tree T is the largest of the following quantities:

  * the diameter of T’s left subtree
  * the diameter of T’s right subtree
  * the longest path between leaves that goes through the root of T (this can be computed from the heights of the
  * subtrees of T)
  *
  * Optimization: try to avoid calculating height for every level
  */
// todo: REVIST
object DiameterOfTree extends App {
  def diameter[A](root: Node[A]): Int = {
    // use post order traversal as you need to come from down to up.
    if (null == root)
      return 0

    // get the diameters of left and right subtrees
    val lDiameter = diameter(root.left)
    val rDiameter = diameter(root.right)

    // get left and right heights
    val lh = HeightOfTree.height(root.left)
    val rh = HeightOfTree.height(root.right)

    Math.max(lDiameter, Math.max(rDiameter, lh + rh + 1))
  }

  def diameterOptimized[A](node: Node[A], height: HeightHolder): Int = {
    if (Option(node).isEmpty) {
      height.height = 0
      0
    } else {
      /* ldiameter  --> diameter of left subtree
           rdiameter  --> Diameter of right subtree */
      /* Get the heights of left and right subtrees in lh and rh
       And store the returned values in ldiameter and ldiameter */
      val lh = HeightHolder(1)
      val rh = HeightHolder(1)

      val ldiameter = diameterOptimized(node.left, lh)
      val rdiameter = diameterOptimized(node.right, rh)

      height.height = Math.max(lh.height, rh.height) + 1

      Math.max(1 + lh.height + rh.height, Math.max(rdiameter, ldiameter))
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(50)
    root.left = Node(7)
    root.right = Node(2)
    root.left.left = Node(3)
    root.left.right = Node(5)
    root.right.left = Node(1)
    root.right.right = Node(30)

    println(diameter(root))
    println(diameterOptimized(root, HeightHolder(0)))
  }
}

case class HeightHolder(var height: Int)
