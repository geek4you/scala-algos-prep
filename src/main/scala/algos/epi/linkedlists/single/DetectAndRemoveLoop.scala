package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/12/17.
  */

/**
  * Page 119
  * @see [[http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/]] for reasoning about why they meet at the start of the loop
  */
object DetectAndRemoveLoop extends App {

  def detectAndRemoveLoop[A](head: ListNode[A]): Unit = {

    // todo: fast is head.next
    var (slow, fast, done) = (head, head.next, false)

    while (Option(fast).isDefined && Option(fast.next).isDefined && Option(
             fast.next.next).isDefined && !done) {
      slow = slow.next
      fast = fast.next.next

      if (slow == fast) { // we have a loop
        done = true
      }
    }

    // get the node in loop just before the start
    // todo: condition different from [[StartOfTheLoop]]
    slow = head
    while (slow != fast.next) {
      slow = slow.next
      fast = fast.next
    }

    // make the next of the node in loop just before start to null
    fast.next = null
  }

  override def main(args: Array[String]): Unit = {
    var node = new ListNode[Int](20)
    node = Push.push(node, 4)
    node = Push.push(node, 15)
    node = Push.push(node, 10)
    // create loop
    node.next.next.next.next = node
    detectAndRemoveLoop(node)
    PrintLinkedList.print(node)
  }
}
