package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/28/17.
  */
/**
  * Find Minimum Depth of a Binary Tree
Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from root node down to the nearest leaf node.

 Note that the path must end on a leaf node. For example, minimum height of below Binary Tree is also 2.

          10
        /
      5

 Method1: The idea is to traverse the given Binary Tree. For every node, check if it is a leaf node. If yes, then return 1. If not leaf node then if left subtree is NULL, then recur for right subtree. And if right subtree is NULL, then recur for left subtree. If both left and right subtrees are not NULL, then take the minimum of two heights.

 Method2:  Better Solution
 The above method may end up with complete traversal of Binary Tree even when the topmost leaf is close to root. A Better Solution is to do Level Order Traversal. While doing traversal, returns depth of the first encountered leaf node. Below is implementation of this solution.
  */
object MinimumDepthOfBinaryTree {}
