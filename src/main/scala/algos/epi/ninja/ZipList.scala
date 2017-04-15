package algos.epi.ninja

/**
  * Created by geek4you on 4/14/17.
  */
/**
  * Page 455
  */
object ZipList {

  def zippingLinkedList(head: ListNode): ListNode = {
    if (Option(head).isEmpty || Option(head.next).isEmpty)
      head
    else {
      // find second half of the list
      var (slowIter, fastIter) = (head, head)
      while (Option(fastIter).isDefined && Option(fastIter.next).isDefined && Option(
               fastIter.next.next).isDefined) {
        slowIter = slowIter.next
        fastIter = fastIter.next.next
      }

      var firstHalfHead = head
      var secondHalfHead = slowIter.next
      slowIter.next = null // splits the list into two halves
      secondHalfHead = recursive(secondHalfHead)

      val dummyHead = ListNode(0, null)
      var resultIter = dummyHead
      var firstHalfIter = firstHalfHead
      var secondHalfIter = secondHalfHead
      var firstTurn = true
      while (Option(firstHalfIter).isDefined && Option(secondHalfIter).isDefined) {
        if (firstTurn) {
          resultIter.next = firstHalfIter
          firstHalfIter = firstHalfIter.next
          resultIter = resultIter.next
          firstTurn = false
        } else {
          resultIter.next = secondHalfIter
          secondHalfIter = secondHalfIter.next
          resultIter = resultIter.next
          firstTurn = true
        }
      }
      if (Option(firstHalfIter).isDefined) {
        resultIter.next = firstHalfIter
      } else if (Option(secondHalfIter).isDefined) {
        resultIter.next = secondHalfIter
      }
      dummyHead.next
    }
  }

  def recursive(head: ListNode): ListNode = {
    // reverse of the null (empty list) is null
    if (Option(head).isEmpty) {
      head
    } else if (Option(head.next).isEmpty) {
      // reverse of one element list is itself
      head
    } else {
      val first = head
      val next = head.next
      // reverse of an n-element list is reverse of the second element on followed by the first.
      first.next = null
      // then we reverse everything from second element
      val reversedList = recursive(next)

      // join two lists
      reversedList.next = first

      reversedList
    }
  }
  case class ListNode(data: Int, var next: ListNode)
}
