package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/11/17.
  */
object ReverseLinkedListInGroups extends App {

  def reverseInGroups[A](head: ListNode[A], k: Int): ListNode[A] = {

    if (Option(head).isEmpty) {
      null
    } else {
      var current = head
      var prev = head
      var next = head
      var count = 0

      /*reverse first k nodes of the linked list */
      while (count < k && Option(current).isDefined) {
        next = current.next
        current.next = prev
        prev = current
        current = next
        count += 1
      }

      /* next is now a pointer to (k+1)th node
       Recursively call for the list starting from current.
       And make rest of the list as next of first node */
      head.next = reverseInGroups(current, k)

      /* prev is new head of the input list */
      prev
    }
  }

  override def main(args: Array[String]): Unit = {
    var node = new ListNode[Int](80)
    node = Push.push(node, 70)
    node = Push.push(node, 60)
    node = Push.push(node, 50)
    node = Push.push(node, 40)
    node = Push.push(node, 30)
    node = Push.push(node, 20)
    node = Push.push(node, 10)
    PrintLinkedList.print(node)
    System.out.println()
    PrintLinkedList.print(reverseInGroups(node, 3))
  }
}
