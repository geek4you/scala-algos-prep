package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/12/17.
  */
/**
  * link : http://www.geeksforgeeks.org/flattening-a-linked-list/
  *
  * Flattening a Linked List
  * Given a linked list where every node represents a linked list and contains two pointers of its type:
  * (i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
  * (ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
  * All linked lists are sorted. See the following example
  * <p>
  * 5 -> 10 -> 19 -> 28
  * |    |     |     |
  * V    V     V     V
  * 7    20    22    35
  * |          |     |
  * V          V     V
  * 8          50    40
  * |                |
  * V                V
  * 30               45
  * Write a function flatten() to flatten the lists into a single linked list. The flattened linked list should also be sorted.
  * For example, for the above input list, output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50.
  * <p>
  * The idea is to use Merge() process of merge sort for linked lists. We use merge() to merge lists one by one.
  * We recursively merge() the current list with already flattened list.
  * The down pointer is used to link nodes of the flattened list.
  */

// todo: very very Imp
object FlattenLinkedList {

  def flattenLinkedList(node: FlattenNode): FlattenNode = {
    // base case
    if (Option(node).isEmpty || Option(node.right).isEmpty) {
      node
    } else {
      // Merge this list with the list on right side
      merge(node, flattenLinkedList(node.right))
    }
  }

  def merge(node1: FlattenNode, node2: FlattenNode): FlattenNode = {
    // If first list is empty, the second list is result
    if (Option(node1).isEmpty)
      node2

    // If second list is empty, the second list is result
    else if (Option(node2).isEmpty)
      node1
    else {
      // Compare the data members of head nodes of both lists
      // and put the smaller one in result
      val dummyHead = FlattenNode(0)
      var resultIter = dummyHead
      if (node1.data < node2.data) {
        resultIter.down = node1
        resultIter = resultIter.down
        resultIter.down = merge(node1.down, node2)
      } else {
        resultIter.down = node2
        resultIter = resultIter.down
        resultIter.down = merge(node1, node2.down)
      }
      dummyHead.down
    }
  }

  def main(args: Array[String]): Unit = {

    /* Let us create the following linked list
   5 -> 10 -> 19 -> 28
   |    |     |     |
   V    V     V     V
   7    20    22    35
   |          |     |
   V          V     V
   8          50    40
   |                |
   V                V
   30               45
     */
    var root: FlattenNode = null
    root = PushFlattenNode.push(root, 30)
    root = PushFlattenNode.push(root, 8)
    root = PushFlattenNode.push(root, 7)
    root = PushFlattenNode.push(root, 5)

    root.right = PushFlattenNode.push(root.right, 20)
    root.right = PushFlattenNode.push(root.right, 10)

    root.right.right = PushFlattenNode.push(root.right.right, 50)
    root.right.right = PushFlattenNode.push(root.right.right, 22)
    root.right.right = PushFlattenNode.push(root.right.right, 19)

    root.right.right.right = PushFlattenNode.push(root.right.right.right, 45)
    root.right.right.right = PushFlattenNode.push(root.right.right.right, 40)
    root.right.right.right = PushFlattenNode.push(root.right.right.right, 35)
    root.right.right.right = PushFlattenNode.push(root.right.right.right, 28)

    root = flattenLinkedList(root)
    printList(root)
  }

  def printList(head: FlattenNode): Unit = {
    var node = head
    while (node != null) {
      print(s"${node.data} ")
      node = node.down
    }
  }
}

case class FlattenNode(var data: Int,
                       var right: FlattenNode,
                       var down: FlattenNode) {
  def this(data: Int) = this(data, null, null)
}

object PushFlattenNode {

  // A utility function to insert a new node at the begining
  //  of linked list */
  def push(head: FlattenNode, data: Int): FlattenNode = {
    val newNode = FlattenNode(data)
    /* link the old list off the new node */
    newNode.down = head
    newNode
  }
}

object FlattenNode {
  def apply(data: Int): FlattenNode = new FlattenNode(data)
}
