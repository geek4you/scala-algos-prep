package algos.epi.binarysearchtree

/**
  * Created by geek4you on 5/7/17.
  */
/**
  * Page 164
  */
object LCA {

  /**
    * node1 value is less than or equal to node2
    */
  def lca(root: Node[Int], node1: Node[Int], node2: Node[Int]): Node[Int] = {

    if (Option(root).isDefined) {
      if (Range(node1.data, node2.data).contains(root.data)) {
        root
      } else {
        if (root.data < node1.data) { // considering node1 smaller than node2
          lca(root.right, node1, node2)
        } else {
          lca(root.left, node1, node2)
        }
      }
    } else null
  }
}
