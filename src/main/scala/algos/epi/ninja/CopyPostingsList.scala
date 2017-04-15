package algos.epi.ninja

/**
  * Created by geek4you on 4/14/17.
  */
object CopyPostingsList {

  def copyPostingList(head: PostingListNode): PostingListNode = {
    if (Option(head).isEmpty)
      head

    // stage1: make a copy of the original list without assigning the jump field, and
    // creates the mapping for each node in the original list to the copied list
    var iter = head
    while (Option(iter).isDefined) {
      val newNode = PostingListNode(iter.data, iter.next, null)
      iter.next = newNode
      iter = newNode.next
    }

    // Stage2: assigns the jump field in the copied list
    iter = head
    while (Option(iter).isDefined) {
      if (Option(iter.jump).isDefined) {
        iter.next.jump = iter.jump.next
      }
      iter = iter.next.next
    }

    // stage3: reverts the original list
    iter = head
    var newListHead = iter.next
    while (Option(iter).isDefined) {
      val temp = iter.next
      iter.next = temp.next
      iter = temp
    }
    newListHead
  }

  case class PostingListNode(var data: Int,
                             var next: PostingListNode,
                             var jump: PostingListNode)
}
