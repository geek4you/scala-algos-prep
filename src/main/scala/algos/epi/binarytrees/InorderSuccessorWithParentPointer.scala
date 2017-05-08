package algos.epi.binarytrees

/**
  * Created by geek4you on 5/6/17.
  */
/**
  * Page 165
  */
object InorderSuccessorWithParentPointer {

  def inorderSuccessor(node: NodeWithParentPointer): NodeWithParentPointer = {
    if (Option(node).isDefined) {
      var iter = node
      if (Option(iter.right).isDefined) {
        iter = iter.right
        while (Option(iter.left).isDefined) {
          iter = iter.left
        }
        return iter
      } else {
        while (Option(iter.parent).isDefined && iter.parent.right == iter) {
          iter = iter.parent
        }
        iter.parent
      }
    } else null
  }

  case class NodeWithParentPointer(data: Int,
                                   left: NodeWithParentPointer,
                                   right: NodeWithParentPointer,
                                   parent: NodeWithParentPointer)
}
