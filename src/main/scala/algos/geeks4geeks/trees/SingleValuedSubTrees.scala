package algos.geeks4geeks.trees

/**
  * Created by geek4you on 3/1/17.
  */
/**
  * Find Count of Single Valued Subtrees
Given a binary tree, write a program to count the number of Single Valued Subtrees. A Single Valued Subtree is one in
which all the nodes have same value. Expected time complexity is O(n).

Example:

Input: root of below tree
              5
             / \
            1   5
           / \   \
          5   5   5
Output: 4
There are 4 subtrees with single values.


Input: root of below tree
              5
             / \
            4   5
           / \   \
          4   4   5
Output: 5
There are five subtrees with single values.


  */

// todo : Didn't understand the question.
object SingleValuedSubTrees {

  /**
    * An Efficient Solution is to traverse the tree in bottom up manner. For every subtree visited, return true if
    * subtree rooted under it is single valued and increment count. So the idea is to use count as a reference parameter
    * in recursive calls and use returned values to find out if left and right subtrees are single valued or not.
    */
  def numSingleValuedSubTrees(node: Node[Int]): Boolean = {

    numSingleValuedSubTreesUtil(node, SingleValuedSubTreesCount(0))

  }

  def numSingleValuedSubTreesUtil(
      node: Node[Int],
      count: SingleValuedSubTreesCount): Boolean = {
    // Base case
    if (Option(node).isEmpty) {
      return true
    }

    // Recursively count in left and right subtrees also
    val leftRes = numSingleValuedSubTreesUtil(node.left, count)
    val rightRes = numSingleValuedSubTreesUtil(node.right, count)

    // If any of the subtrees is not singly, then this
    // cannot be singly.
    if(!leftRes || !rightRes){
      return false
    }

    // If left subtree is singly and non-empty, but data
    // doesn't match
    if(Option(node.left).isDefined && node.data != node.left.data)
      return false

    // Same for right subtree
    if(Option(node.right).isDefined && node.data != node.right.data)
      return false

    // If none of the above conditions is true, then
    // tree rooted under root is single valued, increment
    // count and return true.
    count.count += 1
    true
  }

}

case class SingleValuedSubTreesCount(var count: Int)
