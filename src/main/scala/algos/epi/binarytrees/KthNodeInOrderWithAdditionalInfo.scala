package algos.epi.binarytrees

/**
  * Created by aashii on 5/6/17.
  */
/**
  * Page 163
  */
object KthNodeInOrderWithAdditionalInfo {

  def kTHNode(root: NodeWithChildrenCount, k: Int): NodeWithChildrenCount = {

    var nodesLeftToK = k
    var current = root

    while (Option(current).isDefined) {

      val leftSize =
        if (Option(current).isDefined) current.left.childrenCount else 0

      if (leftSize + 1 == nodesLeftToK) {
        return current
      } else if (leftSize < nodesLeftToK) {
        nodesLeftToK -= (leftSize + 1)
        current = current.right
      } else {
        nodesLeftToK -= 1
        current = current.left
      }
    }
    null
  }

  case class NodeWithChildrenCount(var data: Int,
                                   left: NodeWithChildrenCount,
                                   right: NodeWithChildrenCount,
                                   childrenCount: Int)

}
