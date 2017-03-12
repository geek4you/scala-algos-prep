package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/11/17.
  */
/**
  * Page 116
  */
object ReverseSubListInList {

  def reverseSubList[A](head: ListNode[A], start: Int, finish: Int): ListNode[A] = {

    //go to the node from where you should reverse the node
    if (Option(head).isDefined) {
      var node = head
      var i = 1
      while (i <= start && Option(node).isDefined) {
        node = node.next
        i += 1
      }
    }
    head
  }
}
