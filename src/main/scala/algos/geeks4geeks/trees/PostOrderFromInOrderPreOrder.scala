package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/24/17.
  */
/**
  * Print Postorder traversal from given Inorder and Preorder traversals
Given Inorder and Preorder traversals of a binary tree, print Postorder traversal.

Example:

Input:
Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
Preorder traversal pre[] = {1, 2, 4, 5, 3, 6}

Output:
Postorder traversal is {4, 5, 2, 6, 3, 1}
Trversals in the above example represents following tree

         1
      /     \
     2       3
   /   \      \
  4     5      6

 A naive method is to first construct the tree, then use simple recursive method to print postorder traversal of the constructed tree.


 We can print postorder traversal without constructing the tree. The idea is, root is always the first item in preorder traversal and it must be the last item in postorder traversal. We first recursively print left subtree, then recursively print right subtree. Finally, print root. To find boundaries of left and right subtrees in pre[] and in[], we search root in in[], all elements before root in in[] are elements of left subtree and all elements after root are elements of right subtree. In pre[], all elements after index of root in in[] are elements of right subtree. And elements before index (including the element at index and excluding the first element) are elements of left subtree.

  */
object PostOrderFromInOrderPreOrder {
  var postIndex: Int = _
  var elemToIndexMap: Map[Int, Int] = _

  def printPostOrder(preOrder: Array[Int],
                     inOrder: Array[Int],
                     postOrder: Array[Int], preIndex: Int): Unit = {
      if (Option(elemToIndexMap).isEmpty) {
        elemToIndexMap = elemToIndexMap(inOrder)
      }
      // get the pos of preOrder(preIndex) in inOrder array
      val indexInInorder = elemToIndexMap(preOrder(preIndex))

      // If left subtree is not empty, print left subtree
      if(indexInInorder != 0){
        printPostOrder(preOrder, inOrder, postOrder, preIndex + 1)
      }


      // If right subtree is not empty, print right subtree


      // left

      postOrder(postIndex) = inOrder(indexInInorder)
  }

  def main(args: Array[String]): Unit = {
    val inOrder = Array(4, 2, 5, 1, 3, 6)
    val preOrder = Array(1, 2, 4, 5, 3, 6)
    val postOrder = Array[Int](preOrder.length)
    // printPostOrder(preOrder, inOrder, postOrder, 0, inOrder.length - 1)
    println(postOrder.mkString(" "))
  }

  /**
    * function to return the element -> index map
    */
  def elemToIndexMap(arr: Array[Int]): Map[Int, Int] = {
    Map(arr.zipWithIndex: _*)
  }

}
