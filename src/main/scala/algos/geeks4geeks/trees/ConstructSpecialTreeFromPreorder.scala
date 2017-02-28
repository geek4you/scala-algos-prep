package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/23/17.
  */
/**
  * Construct a special tree from given preorder traversal
Given an array ‘pre[]’ that represents Preorder traversal of a spacial binary tree where every node has either 0 or 2 children. One more array ‘preLN[]’ is given which has only two possible values ‘L’ and ‘N’. The value ‘L’ in ‘preLN[]’ indicates that the corresponding node in Binary Tree is a leaf node and value ‘N’ indicates that the corresponding node is non-leaf node. Write a function to construct the tree from the given two arrays.

Source: Amazon Interview Question

Example:

Input:  pre[] = {10, 30, 20, 5, 15},  preLN[] = {'N', 'N', 'L', 'L', 'L'}
Output: Root of following tree
          10
         /  \
        30   15
       /  \
      20   5
The first element in pre[] will always be root. So we can easily figure out root. If left subtree is empty, the right subtree must also be empty and preLN[] entry for root must be ‘L’. We can simply create a node and return it. If left and right subtrees are not empty, then recursively call for left and right subtrees and link the returned nodes to root.
  */
// todo: REVISIT interesting
object ConstructSpecialTreeFromPreorder extends App {

  var indexPtr: Int = 0

  /**
    * A recursive function to create a Binary Tree from given pre[]
   preLN[] arrays. The function returns root of tree. indexPtr is used
   to update index values in recursive calls. index must be initially 0
    */
  def constructTree(preArr: Array[Int], preLNArr: Array[Char]): Node[Int] = {
    val index = indexPtr // store the current value of index in pre[]

    // Base Case: All nodes are constructed
    if (index == preArr.length)
      null
    else {
      // Allocate memory for this node and increment index for
      // subsequent recursive calls
      val node = Node(preArr(index))
      indexPtr += 1

      // If this is an internal node, construct left and right subtrees and link the subtrees
      if (preLNArr(index) == 'N') {
        node.left = constructTree(preArr, preLNArr)
        node.right = constructTree(preArr, preLNArr)
      }

      node
    }
  }

  override def main(args: Array[String]): Unit = {
    val preArr = Array[Int](10, 30, 20, 5, 15)
    val preLNArr = Array[Char]('N', 'N', 'L', 'L', 'L')
    val root = constructTree(preArr, preLNArr)

    println(s"Inorder traversal : ${InOrderTraversal.inorder(root)}")
  }
}
