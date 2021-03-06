package algos.geeks4geeks.trees

/**
 * Created by geek4you on 2/24/17.
 */

/**
 * Find depth of the deepest odd level leaf node
Write a C code to get the depth of the deepest odd level leaf node in a binary tree. Consider that level starts with 1. Depth of a leaf node is number of nodes on the path from root to leaf (including both leaf and root).

For example, consider the following tree. The deepest odd level node is the node with value 9 and depth of this node is 5.

       1
     /   \
    2     3
  /      /  \
 4      5    6
        \     \
         7     8
        /       \
       9         10
                 /
                11
We strongly recommend you to minimize the browser and try this yourself first.

The idea is to recursively traverse the given binary tree and while traversing, maintain a variable “level” which will store the current node’s level in the tree. If current node is leaf then check “level” is odd or not. If level is odd then return it. If current node is not leaf, then recursively find maximum depth in left and right subtrees, and return maximum of the two depths.

 [[http://www.geeksforgeeks.org/find-depth-of-the-deepest-odd-level-node/]]
 */
object DepthOfTheDeepestOddLvlNode {

}
