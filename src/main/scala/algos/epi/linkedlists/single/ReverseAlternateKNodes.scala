package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/11/17.
  */
object ReverseAlternateKNodes {

  def reverseAlternateKNode[A](head: ListNode[A], k: Int): ListNode[A] = {
    if (Option(head).isEmpty) {
      null
    } else {
      var current = head
      var prev = current
      var next = current.next
      var count = 0

      // reverse first k nodes
      while (Option(current).isDefined && count < k) {
        next = current.next
        current.next = prev
        prev = current
        current = next
        count += 1
      }

      head.next = current

      // iterate next k nodes and call recursion
      count = 0
      while (count < k - 1 && Option(current).isDefined) {
        current = current.next
        count += 1
      }

      if (Option(current).isDefined)
        current.next = reverseAlternateKNode(current.next, k)

      prev
    }
  }

  def main(args: Array[String]): Unit = {
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
    PrintLinkedList.print(reverseAlternateKNode(node, 3))
  }

}
