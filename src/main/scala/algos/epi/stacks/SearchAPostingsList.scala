package algos.epi.stacks

import scala.collection.mutable.ListBuffer

/**
  * Created by geek4you on 4/13/17.
  */
/**
  * Page 140
  */
object SearchAPostingsList {

  def setJumpOrderRecursive(postingList: PostingsListNode): Unit = {
    setJumpOrderHelper(postingList, 0)
  }

  def setJumpOrderHelper(postingList: PostingsListNode, order: Int): Int = {
    var returnOrder = order
    if (Option(postingList).isDefined && postingList.order != -1) {
      postingList.order = returnOrder
      returnOrder += 1
      returnOrder = setJumpOrderHelper(postingList.jump, returnOrder)
      returnOrder = setJumpOrderHelper(postingList.next, returnOrder)
    }
    returnOrder
  }

  def setJumpOrderIterative(postingsList: PostingsListNode): Unit = {
    val stack = new ListBuffer[PostingsListNode]()
    var order  = 0
    stack.prepend(postingsList)
    while (stack.nonEmpty){
      val curr = stack.remove(0)
      if(curr.order != -1){
        curr.order = order
        order += 1
        stack.prepend(curr.next)
        stack.prepend(curr.jump)
      }
    }
  }

}

case class PostingsListNode(var data: Int,
                            var order: Int,
                            next: PostingsListNode,
                            jump: PostingsListNode)
