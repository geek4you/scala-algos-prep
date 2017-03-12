package algos.epi.linkedlists.single

/**
  * Print Linked List
  * Time: O(n)
  * Space : O(1)
  */
object PrintLinkedList {
  def print[A](head: ListNode[A]) {
    if (Option(head).isDefined) {
      var current = head
      while (Option(current.next).isDefined) {
        System.out.print(current.data)
        System.out.print("-->")
        current = current.next
      }
      System.out.print(current.data)
    }
  }

  def main(args: Array[String]) {
    val node = new ListNode(10)
    val node1 = new ListNode(20)
    val node2 = new ListNode(30)
    val node3 = new ListNode(40)
    val node4 = new ListNode(50)
    node.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4
    print(node)
  }
}
