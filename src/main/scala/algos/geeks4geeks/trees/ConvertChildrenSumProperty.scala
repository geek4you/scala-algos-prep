package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/22/17.
  */
/**
  * [[http://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/]]
  * <p>
  * Given an arbitrary binary tree, convert it to a binary tree that holds Children Sum Property.
  * You can only increment data values in any node (You cannot change structure of tree and cannot decrement value of any
  * node).
  * <p>
  * For example, the below tree doesn’t hold the children sum property, convert it to a tree that holds the property.
  * <p>
  *           50
  *          /     \
  *        /         \
  *       7             2
  *      / \             /\
  *    /     \          /   \
  *   3        5      1      30
  */
/*
Algorithm:
Traverse given tree in post order to convert it, i.e., first change left and right children to hold the children sum
property then change the parent node.

Let difference between node’s data and children sum be diff.

     diff = node’s children sum - node’s data
If diff is 0 then nothing needs to be done.

If diff > 0 ( node’s data is smaller than node’s children sum) increment the node’s data by diff.

If diff < 0 (node’s data is greater than the node's children sum) then increment one child’s data.
We can choose to increment either left or right child if they both are not NULL. Let us always first increment the
left child. Incrementing a child changes the subtree’s children sum property so we need to change left subtree also.
So we recursively increment the left child. If left child is empty then we recursively call increment() for right child.
Let us run the algorithm for the given example. First convert the left subtree (increment 7 to 8).

             50
           /     \
         /         \
       8             2
     / \             /\
   /     \          /   \
  3        5      1      30
Then convert the right subtree (increment 2 to 31)

          50
        /    \
      /        \
    8            31
   / \           / \
 /     \       /     \
3       5    1       30
Now convert the root, we have to increment left subtree for converting the root.

          50
        /    \
      /        \
    19           31
   / \           /  \
 /     \       /      \
14      5     1       30
Please note the last step – we have incremented 8 to 19, and to fix the subtree we have incremented 3 to 14.
 */

// todo: revisit
object ConvertChildrenSumProperty extends App {

  def convertToChildrenSumProperty(node: Node[Int]): Unit = {
    if (Option(node).isDefined) {
      // check if not leaf else return
      if (Option(node.left).isDefined || Option(node.right).isDefined) {

        // convert left and right subtrees
        convertToChildrenSumProperty(node.left)
        convertToChildrenSumProperty(node.right)

        // If left child is not present then 0 is used as data of left   child
        val left =
          if (Option(node.left).isDefined)
            node.left.data
          else 0

        //If right child is not present then 0 is used as data of right child
        val right =
          if (Option(node.right).isDefined)
            node.right.data
          else
            0

        // get the diff of node's data and children sum
        val diff = node.data - (left + right)

        //if diff == 0  we are good
        if (diff < 0) {
          // children sum is greater than node data. increment node.data
          node.data += Math.abs(diff)
        } else if (diff > 0) {
          // this is tricky. root data is greater than children. increment children
          increment(node, diff)
        }
      }
    }
  }

  /**
    * Increment the roots children top down
    * increment left child if present else increment right child
    */
  def increment(node: Node[Int], inc: Int): Unit = {
    if (Option(node).isDefined) {
      if (Option(node.left).isDefined || Option(node.right).isDefined) {
        // if left node is present increment and move top down
        if (Option(node.left).isDefined) {
          node.left.data += inc
          increment(node.left, inc)
        } else {
          // if left node is not present increment right node and move top down
          node.right.data += inc
          increment(node.right, inc)
        }
      }
    }
  }

  override def main(args: Array[String]): Unit = {
    val root = Node(50)
    root.left = Node(7)
    root.right = Node(2)
    root.left.left = Node(3)
    root.left.right = Node(5)
    root.right.left = Node(1)
    root.right.right = Node(30)

    println(s"Inorder traversal before conversion : ${InOrderTraversal.inorder(root)}")
    convertToChildrenSumProperty(root)
    println(s"Inorder traversal after conversion : ${InOrderTraversal.inorder(root)}")
  }

}
