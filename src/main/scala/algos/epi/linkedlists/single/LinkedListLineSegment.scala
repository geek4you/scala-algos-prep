package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/12/17.
  */
/**
  * @see [[http://www.geeksforgeeks.org/given-linked-list-line-segments-remove-middle-points/]]
  *
  *  Given a linked list of line segments, remove middle points
Given a linked list of co-ordinates where adjacent points either form a vertical line or a horizontal line. Delete points from the linked list which are in the middle of a horizontal or vertical line.

Examples:

Input:  (0,10)->(1,10)->(5,10)->(7,10)
                                  |
                                (7,5)->(20,5)->(40,5)
Output: Linked List should be changed to following
        (0,10)->(7,10)
                  |
                (7,5)->(40,5)
The given linked list represents a horizontal line from (0,10)
to (7, 10) followed by a vertical line from (7, 10) to (7, 5),
followed by a horizontal line from (7, 5) to (40, 5).

Input:     (2,3)->(4,3)->(6,3)->(10,3)->(12,3)
Output: Linked List should be changed to following
    (2,3)->(12,3)
There is only one vertical line, so all middle points are removed.
  */
object LinkedListLineSegment extends App {

  def removeMiddle(head: CoordinateNode): CoordinateNode = {
    if (Option(head).isEmpty || Option(head.next).isEmpty || Option(
          head.next.next).isEmpty) {
      head
    } else {
      var next = head.next
      var nextNext = next.next
      // check if vertical or horizontal
      if (head.x == next.x) { // vertical

        while (Option(nextNext).isDefined && next.x == nextNext.x) {
          head.next = nextNext
          next.next = null
          next = nextNext
          nextNext = next.next
        }
      } else if (head.y == next.y) { // horizontal

        while (Option(nextNext).isDefined && next.y == nextNext.y) {
          head.next = nextNext
          next.next = null
          next = nextNext
          nextNext = next.next
        }
      } else
        throw new RuntimeException(
          "Either x or y should be same for adjacent nodes!!")

      next = removeMiddle(head.next)
    }
    head
  }

  def print(head: CoordinateNode) {
    if (null == head) return
    var current = head
    while (null != current) {
      System.out.print(current)
      current = current.next
    }
  }

  override def main(args: Array[String]): Unit = {
    var node = new CoordinateNode(0, 10)
    node.next = new CoordinateNode(1, 10)
    node.next.next = new CoordinateNode(3, 10)
    node.next.next.next = new CoordinateNode(10, 10)
    node.next.next.next.next = new CoordinateNode(10, 8)
    node.next.next.next.next.next = new CoordinateNode(10, 5)
    node.next.next.next.next.next.next = new CoordinateNode(20, 5)
    node.next.next.next.next.next.next.next = new CoordinateNode(40, 5)

    print(removeMiddle(node))
  }
}

case class CoordinateNode(var x: Int, var y: Int, var next: CoordinateNode) {
  def this(x: Int, y: Int) = this(x, y, null)

  override def toString: String = s"[$x,$y]"
}

object CoordinateNode {
  def apply(x: Int, y: Int) = new CoordinateNode(x, y)
}
