package algos.geeks4geeks.trees

/**
  * Created by geek4you on 3/1/17.
  */
/**
  * Closest leaf to a given node in Binary Tree
Given a Binary Tree and a node x in it, find distance of the closest leaf to x in Binary Tree. If given node itself is a leaf, then distance is 0.

Examples:

Input: Root of below tree
       And x = pointer to node 13
          10
       /     \
     12       13
             /
           14
Output 1
Distance 1. Closest leaf is 14.


Input: Root of below tree
       And x = pointer to node 13
          10
       /     \
     12       13
           /     \
         14       15
        /   \     /  \
       21   22   23   24
       /\   /\   /\   /\
      1 2  3 4  5 6  7  8

Output 2
Closest leaf is 12 through 10.
  */

/**
 * The idea is to first traverse the subtree rooted with give node and find the closest leaf in this subtree. Store this distance. Now traverse tree starting from root. If given node x is in left subtree of root, then find the closest leaf in right subtree, else find the closest left in left subtree. Below is C++ implementation of this idea.
 */

// todo: solve it
object ClosestLeafToANodeInBinaryTree {}
