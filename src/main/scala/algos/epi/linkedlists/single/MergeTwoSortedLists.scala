package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/11/17.
  */

/**
 * Page: 115
 */
object MergeTwoSortedLists extends App {

  def merge(head1: ListNode[Int], head2: ListNode[Int]): ListNode[Int] = {

    // creates place holder for the result
    val dummyHead = ListNode(0)
    var current = dummyHead

    var node1 = head1
    var node2 = head2

    while (Option(node1).isDefined && Option(node2).isDefined) {
      if (node1.data <= node2.data) {
        current.next = node1
        node1 = node1.next
      } else {
        current.next = node2
        node2 = node2.next
      }
      current = current.next
    }

    // append remaining nodes
    if (Option(node1).isDefined)
      current.next = node1
    else
      current.next = node2

    dummyHead.next
  }

  override def main(args: Array[String]): Unit = {}
}
