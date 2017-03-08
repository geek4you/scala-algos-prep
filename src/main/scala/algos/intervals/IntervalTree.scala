package algos.intervals

/**
  * Created by geek4you on 3/8/17.
  */
class IntervalTree(iNode: INode) {

  val root = iNode

  def inOrder(root: INode): Unit = {
    if (Option(root).isDefined) {
      inOrder(root.left)
      println(root)
      inOrder(root.right)
    }
  }

  // A utility function to insert a new Interval Search Tree Node
  // This is similar to BST Insert.  Here the low/start value of interval
  // is used to maintain BST property
  def insert(root: INode, interval: Interval): INode = {
    if (Option(root).isDefined) {

      // If root's low/start value is larger than interval low/start, then new interval goes to
      // left subtree
      if (interval.start < root.interval.start)
        root.left = insert(root.left, interval)
      else // Else, new node goes to right subtree.
        root.right = insert(root.right, interval)

      root.max = Math.max(root.max, interval.end)
      root
    } else
      INode(interval)
  }

}
