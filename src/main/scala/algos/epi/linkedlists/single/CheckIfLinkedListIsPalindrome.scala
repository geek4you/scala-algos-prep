package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/12/17.
  */
object CheckIfLinkedListIsPalindrome extends App {

  def isPalindrome[A](head: ListNode[A]): Boolean = {
    if (Option(head).isDefined) {
      // get the middle node of the linked list
      var (slow, fast) = (head, head)

      while (Option(fast).isDefined && Option(fast.next).isDefined && Option(
               fast.next.next).isDefined) {
        slow = slow.next
        fast = fast.next.next
      }

      // slow.next is always the second part of the list always( even or odd length)
      // reverse the second part
      slow.next = ReverseRecursively.recursiveReverse(slow.next)
      var secondHalfIter = slow.next
      var firstHalfIter = head
      while (Option(secondHalfIter).isDefined && Option(firstHalfIter).isDefined) {
        if (secondHalfIter.data != firstHalfIter.data)
          return false

        secondHalfIter = secondHalfIter.next
        firstHalfIter = firstHalfIter.next
      }
      true
    } else
      false
  }

  override def main(args: Array[String]): Unit = {
    var node = new ListNode[Int](40)
    node = Push.push(node, 20)
    node = Push.push(node, 30)
    node = Push.push(node, 20)
    node = Push.push(node, 40)
    println(isPalindrome(node))
  }
}
