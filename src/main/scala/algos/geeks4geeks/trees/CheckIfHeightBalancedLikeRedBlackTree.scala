package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/25/17.
  */
/**
  * Check if a given Binary Tree is height balanced like a Red-Black Tree
In a Red-Black Tree, the maximum height of a node is at most twice the minimum height (The four Red-Black tree properties make sure this is always followed). Given a Binary Search Tree, we need to check for following property.
For every node, length of the longest leaf to node path has not more than twice the nodes on shortest path from node to leaf.

    12                                        40
      \                                     /    \
       14                                 10      100
         \                                        /  \
          16                                     60   150
 Cannot be a Red-Black Tree              It can be Red-Black Tree
 with any color assignment
 Max height of 12 is 1
 Min height of 12 is 3


          10
        /   \
      5     100
           /   \
          50   150
         /
        40
 It can also be Red-Black Tree
Expected time complexity is O(n). The tree should be traversed at-most once in the solution.

We strongly recommend to minimize the browser and try this yourself first.
For every node, we need to get the maximum and minimum heights and compare them. The idea is to traverse the tree and for every node check if it’s balanced. We need to write a recursive function that returns three things, a boolean value to indicate the tree is balanced or not, minimum height and maximum height. To return multiple values, we can either use a structure or pass variables by reference. We have passed maxh and minh by reference so that the values can be used in parent calls.

[[http://www.geeksforgeeks.org/check-given-binary-tree-follows-height-property-red-black-tree/]]

  */
//todo: revisit

object CheckIfHeightBalancedLikeRedBlackTree {

}
