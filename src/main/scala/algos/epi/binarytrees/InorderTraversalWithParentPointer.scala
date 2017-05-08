package algos.epi.binarytrees

/**
  * Created by geek4you on 5/6/17.
  */
/**
  * Page 166
  */
object InorderTraversalWithParentPointer {

  def inorder(root: NodeWithParentPointer): Unit = {
    var prev: NodeWithParentPointer = null
    var current = root

    while (Option(current).isDefined) {
      var next: NodeWithParentPointer = null
      if (current.parent == prev) {
        // we came down to curr from prev
        if (Option(current.left).isDefined)
          next = current.left
        else {
          println(current.data)
          // done with left, so go right if right is not empty else go to parent
          if (Option(current.right).isDefined)
            next = current.right
          else
            next = current.parent
        }

      } else if (current.left == prev) {
        println(current.data)
        // done with left, so go right if right is not empty else go to parent
        if (Option(current.right).isDefined)
          next = current.right
        else // done with both children, go up
          next = current.parent
      }
      prev = current
      current = next
    }
  }

  case class NodeWithParentPointer(data: Int,
                                   left: NodeWithParentPointer,
                                   right: NodeWithParentPointer,
                                   parent: NodeWithParentPointer)
}
