package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/12/17.
  */
/**
  * page 118
  */
object StartOfTheLoop {

  def startOfLoop[A](head: ListNode[A]): ListNode[A] = {

    if (Option(head).isDefined) {
      var (slow, fast, done) = (head, head, false)

      while (Option(fast).isDefined && Option(fast.next).isDefined && Option(
               fast.next.next).isDefined) {
        slow = slow.next
        fast = fast.next.next
        if (slow == fast) { // there is a cycle
          // tries to find the start of the cycles
          slow = head
          // both pointers advance at the same speed
          while (slow != fast) {
            slow = slow.next
            fast = fast.next
          }
          return slow
        }
      }
      null

    } else
      null
  }

  def main(args: Array[String]): Unit = {
    var node = new ListNode[Int](20)
    node =Push.push(node,4)
    node =Push.push(node,15)
    node = Push.push(node,10)

    // create loop
    node.next.next.next.next = node

    println(startOfLoop(node))

  }

}
