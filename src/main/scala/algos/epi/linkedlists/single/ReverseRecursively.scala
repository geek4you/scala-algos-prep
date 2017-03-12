package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/11/17.
  */
object ReverseRecursively {

  def recursiveReverse[A](head: ListNode[A]): ListNode[A] = {
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
      val reversedList = recursiveReverse(next)

      // join two lists
      reversedList.next = first

      reversedList
    }
  }
}
