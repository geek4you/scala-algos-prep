package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/11/17.
  */
/**
  *
  */
object ReverseLinkedListIteratively extends App {

  def reverseList[A](head: ListNode[A]): Option[ListNode[A]] = {
    if (Option(head) == null)
      None
    else {
      var previous = head
      var current = head
      var next = current.next

      while (Option(current.next).isDefined) {
        next = current.next
        current.next = previous
        previous = current
        current = next
      }
      current.next = previous
      head.next = null
      Option(current)
    }
  }

  override def main(args: Array[String]): Unit = {
    var node = new ListNode[Int](50)
    node = Push.push(node, 40)
    node = Push.push(node, 30)
    node = Push.push(node, 20)
    node = Push.push(node, 10)
    PrintLinkedList.print(node)
    println()
    PrintLinkedList.print(reverseList(node).get)
  }

}
