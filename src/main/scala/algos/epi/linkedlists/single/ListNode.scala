package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/11/17.
  */

/**
  * Node class for SingleLinkedList
  */
case class ListNode[A](var data: A, var next: ListNode[A]) {
  def this(data: A) = this(data, null)

  override def toString: String = s"ListNode: Node[$data]"
}

object ListNode {
  def apply[A](data: A): ListNode[A] = new ListNode[A](data)
}
