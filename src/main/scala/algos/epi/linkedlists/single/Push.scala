package algos.epi.linkedlists.single

/**
  * Add a node at the beginning of the list.
  * Time: O(1)
  * Space: O(1)
  */
object Push {
  def push[A](head: ListNode[A], data: A): ListNode[A] = {
    if (Option(head).isEmpty) ListNode(data)
    else {
      val newNode = ListNode(data)
      newNode.next = head
      newNode
    }
  }

  def pushNode[A](head: ListNode[A], node: ListNode[A]): ListNode[A] = {
    if (Option(head).isEmpty && Option(node).isEmpty) null
    else if (Option(node).isEmpty) head
    else {
      var headVar = head
      node.next = headVar
      headVar = node
      headVar
    }
  }

  def main(args: Array[String]) {
    PrintLinkedList.print(push(null, 10))
    System.out.println()
    val node = new ListNode(10)
    val node1 = new ListNode(20)
    val node2 = new ListNode(30)
    val node3 = new ListNode(40)
    val node4 = new ListNode(50)
    node.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4
    PrintLinkedList.print(push(node, 5))
  }
}
