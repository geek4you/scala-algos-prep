package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/21/17.
  */
/**
  * Method1:
  * Create an empty hash table.
  * Insert n1 and all of its ancestors in hash table.
  * Check if n2 or any of its ancestors exist in hash table, if yes return the first existing ancestor.
  * Below is C++ implementation of above steps.
  *T(n) : O(h)
  * Space: O(h)
  *
  * Method2:
  * We can solve the problem in O(1) extra space using following fact : If both nodes are at same level and if we
  * traverse up using parent pointers of both nodes, the first common node in the path to root is lca.
  * The idea is to find depths of given nodes and move up the deeper node pointer by the difference between depths.
  * Once both nodes reach same level, traverse them up and return the first common node.
  */
object LowestCommonAncestorWithParentPointer extends App {

  def lca(node1: NodeWithParentPointer[Int],
          node2: NodeWithParentPointer[Int]): NodeWithParentPointer[Int] = {
    if (Option(node1).isDefined && Option(node2).isDefined) {
      val depth1 = depthOfNode(node1)
      val depth2 = depthOfNode(node2)
      val diff = depth1 - depth2
      var node1Temp = node1
      var node2Temp = node2
      if (diff > 0) {
        // diff > 0 => node1 depth is larger
        var current = node1
        for (i <- 1 to diff) {
          current = node1.parent
        }
        node1Temp = current
      } else if (diff < 0) {
        // diff < 0 => node2 depth is larger
        var current = node2
        for (i <- 1 to diff) {
          current = node2.parent
        }
        node2Temp = current
      }

      // now node1Compare and node2Compare are at the same depth.
      var done = false
      while (Option(node1Temp).isDefined && Option(node2Temp).isDefined && !done) {
        if (node1Temp.data == node2Temp.data)
          done = true
        else {
          node1Temp = node1Temp.parent
          node2Temp = node2Temp.parent
        }
      }
      node1Temp
    }else{
      null
    }
  }

  def depthOfNode(node: NodeWithParentPointer[Int]): Int = {
    var depth = -1
    var current = node
    while (Option(current).isDefined) {
      depth += 1
      current = current.parent
    }
    depth
  }

  override def main(args: Array[String]): Unit = {
    val root = NodeWithParentPointer(20)
    root.left = NodeWithParentPointer(8, root)
    root.right = NodeWithParentPointer(22, root)
    root.left.left = NodeWithParentPointer(4, root.left)
    root.left.right = NodeWithParentPointer(12, root.left)
    root.left.right.left = NodeWithParentPointer(10, root.left.right)
    root.left.right.right = NodeWithParentPointer(14, root.left.right.right)

    println(lca(root.left.left, root.left.right.right))
  }
}

case class NodeWithParentPointer[A](data: A,
                                    var left: NodeWithParentPointer[A],
                                    var right: NodeWithParentPointer[A],
                                    var parent: NodeWithParentPointer[A]) {
  def this(data: A) = this(data, null, null, null)
  def this(data: A, parent: NodeWithParentPointer[A]) =
    this(data, null, null, parent)
}

object NodeWithParentPointer {
  def apply[A](data: A): NodeWithParentPointer[A] =
    new NodeWithParentPointer(data, null, null, null)

  def apply[A](data: A,
               parent: NodeWithParentPointer[A]): NodeWithParentPointer[A] =
    new NodeWithParentPointer(data, null, null, parent)
}
