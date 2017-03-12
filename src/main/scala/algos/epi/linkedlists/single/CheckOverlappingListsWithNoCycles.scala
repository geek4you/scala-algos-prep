package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/12/17.
  */
/**
  * Page 120
  */
object CheckOverlappingListsWithNoCycles {

  def checkOverlap[A](head1: ListNode[A], head2: ListNode[A]): Boolean = {
    val len1 = length(head1)
    val len2 = length(head2)
    if (len1 == 0 || len2 == 0)
      false
    else {
      var smallHead = head1
      var bigHead = head2
      var diff = len2 - len1
      if (len1 > len2) {
        smallHead = head2
        bigHead = head1
        diff = len1 - len2
      }
      var currentBig = advanceKSteps(bigHead, diff)
      var currentSmall = smallHead

      while (Option(currentBig).isDefined && Option(currentSmall).isDefined) {
        if (currentBig == currentSmall)
          return true
        else {
          currentBig = currentBig.next
          currentSmall = currentSmall.next
        }
      }
      false
    }
  }

  def advanceKSteps[A](node: ListNode[A], k: Int): ListNode[A] = {
    var i = 0
    var nodeIter = node
    while (i < k) {
      nodeIter = nodeIter.next
      i += 1
    }
    nodeIter
  }

  def length[A](head: ListNode[A]): Int = {
    var current = head
    var len = 0
    while (Option(current).isDefined) {
      current = current.next
      len += 1
    }
    len
  }

  def main(args: Array[String]): Unit = {
    var head1 = new ListNode[Int](70)
    head1 = Push.push(head1, 60)
    head1 = Push.push(head1, 50)
    val inter = head1
    head1 = Push.push(head1, 40)
    head1 = Push.push(head1, 30)
    head1 = Push.push(head1, 20)
    head1 = Push.push(head1, 10)
    var head2 = new ListNode[Int](75)
    val last = head2
    head2 = Push.push(head2, 65)
    head2 = Push.push(head2, 55)
    head2 = Push.push(head2, 40)
    head2 = Push.push(head2, 35)
    head2 = Push.push(head2, 25)
    head2 = Push.push(head2, 15)
    last.next = inter

    println(checkOverlap(head1, head2))
  }
}
