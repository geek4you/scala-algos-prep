package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/12/17.
  */
/**
  * Page: 130
  */
object AddListBasedIntegers {

  def add(head1: ListNode[Int], head2: ListNode[Int]): ListNode[Int] = {
    var (sum, carry) = (0, 0)
    var (num1Iter, num2Iter) = (head1, head2)
    var dummyResultHead = ListNode(0)
    var resultIter = dummyResultHead
    while (Option(num1Iter).isDefined && Option(num2Iter).isDefined) {
      sum = num1Iter.data + num2Iter.data + carry
      if (sum >= 10) {
        carry = sum / 10
        sum = sum % 10
      } else {
        carry = 0
      }
      resultIter.next = ListNode(sum)
      resultIter = resultIter.next
      num1Iter = num1Iter.next
      num2Iter = num2Iter.next
    }

    while (Option(num1Iter).isDefined) {
      sum = num1Iter.data + carry
      if (sum >= 10) {
        carry = sum / 10
        sum = sum % 10
      } else {
        carry = 0
      }
      num1Iter = num1Iter.next
      resultIter.next = ListNode(sum)
      resultIter = resultIter.next
    }

    while (Option(num2Iter).isDefined) {
      sum = num2Iter.data + carry
      if (sum >= 10) {
        carry = sum / 10
        sum = sum % 10
      } else {
        carry = 0
      }
      num2Iter = num2Iter.next
      resultIter.next = ListNode(sum)
      resultIter = resultIter.next
    }

    if (carry > 0) {
      resultIter.next = ListNode(carry)
    }
    dummyResultHead.next
  }

  def main(args: Array[String]): Unit = {
    var node = new ListNode[Int](6)
    node = Push.push(node, 4)
    node = Push.push(node, 9)
    node = Push.push(node, 5)
    node = Push.push(node, 7)
    var node1 = new ListNode[Int](4)
    node1 = Push.push(node1, 8)
    println(s"Number1: ${PrintLinkedList.print(node)}")
    println(s"Number2: ${PrintLinkedList.print(node1)}")
    println(s"Addition Number: ${PrintLinkedList.print(add(node, node1))}")

  }
}
