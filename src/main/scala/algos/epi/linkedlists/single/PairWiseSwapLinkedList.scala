package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/12/17.
  */
/**
  * Pairwise swap elements of a given linked list
  * Given a singly linked list, write a function to swap elements pairwise. For example, if the linked list is
  * 1->2->3->4->5 then the function should change it to 2->1->4->3->5, and if the linked list is 1->2->3->4->5->6
  * then the function should change it to 2->1->4->3->6->5.
  *
  * @see http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
  */
object PairWiseSwapLinkedList {

  def pairWiseSwap[A](head: ListNode[A]): ListNode[A] = {
    ReverseLinkedListInGroups.reverseInGroups(head, 2)
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
    PrintLinkedList.print(pairWiseSwap(node))
  }
}
