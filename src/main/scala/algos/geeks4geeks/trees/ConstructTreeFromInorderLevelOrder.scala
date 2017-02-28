package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/27/17.
  */
/**
  * Construct a tree from Inorder and Level order traversals
Given inorder and level-order traversals of a Binary Tree, construct the Binary Tree. Following is an example to illustrate the problem.

BinaryTree

Input: Two arrays that represent Inorder
       and level order traversals of a
       Binary Tree
in[]    = {4, 8, 10, 12, 14, 20, 22};
level[] = {20, 8, 22, 4, 12, 10, 14};

Output: Construct the tree represented
        by the two arrays.
        For the above two arrays, the
        constructed tree is shown in
        the diagram on right side

Let us consider the above example.

in[] = {4, 8, 10, 12, 14, 20, 22};
level[] = {20, 8, 22, 4, 12, 10, 14};

      20
      / \
     8   22
    / \
   4   12
       / \
      10  14

In a Levelorder sequence, the first element is the root of the tree. So we know ’20’ is root for given sequences. By searching ’20’ in Inorder sequence, we can find out all elements on left side of ‘20’ are in left subtree and elements on right are in right subtree. So we know below structure now.

             20
           /    \
          /      \
 {4,8,10,12,14}  {22}
Let us call {4,8,10,12,14} as left subarray in Inorder traversal and {22} as right subarray in Inorder traversal.
In level order traversal, keys of left and right subtrees are not consecutive. So we extract all nodes from level order traversal which are in left subarray of Inorder traversal. To construct the left subtree of root, we recur for the extracted elements from level order traversal and left subarray of inorder traversal. In the above example, we recur for following two arrays.

// Recur for following arrays to construct the left subtree
In[]    = {4, 8, 10, 12, 14}
level[] = {8, 4, 12, 10, 14}
Similarly, we recur for following two arrays and construct the right subtree.

// Recur for following arrays to construct the right subtree
In[]    = {22}
level[] = {22}
  */
// todo: REVISIT
object ConstructTreeFromInorderLevelOrder extends App{

  def constructTree(startNode: Node[Int],
                    inOrder: Array[Int],
                    lvlOrder: Array[Int],
                    inStart: Int,
                    inEnd: Int): Node[Int] = {

    // if start index is more than end index
    if (inStart > inEnd)
      null
    else if (inEnd == inStart)
      Node(inOrder(inStart))
    else {
      var startNodeTmp: Node[Int] = startNode
      var found = false
      // it represents the index in inOrder array of element that
      // appear first in levelOrder array.
      var index = 0
      var j = inStart
      var i = 0
      while (i <= inOrder.length - 1 && !found) {
        val data = lvlOrder(i)
        while (j <= inEnd && !found) {
          if (data == inOrder(j)) {
            startNodeTmp = new Node(data)
            index = j
            found = true
          }
        }
      }
      //elements present before index are part of left child of startNode.
      //elements present after index are part of right child of startNode.
      startNodeTmp.left =
        constructTree(startNodeTmp, inOrder, lvlOrder, inStart, index - 1)
      startNodeTmp.left =
        constructTree(startNodeTmp, inOrder, lvlOrder, index + 1, inEnd)
      startNodeTmp
    }
  }

  override def main(args: Array[String]): Unit = {
    val inOrder = Array(4, 8, 10, 12, 14, 20, 22)
    val lvlOrder = Array(20, 8, 22, 4, 12, 10, 14)

    PreOrderTraversal.preOrder(constructTree(null, inOrder, lvlOrder, 0, inOrder.length-1))
  }
}
