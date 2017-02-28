package algos.geeks4geeks.trees

/**
 * Created by geek4you on 2/24/17.
 */

/**
 * Remove all nodes which don’t lie in any path with sum>= k
Given a binary tree, a complete path is defined as a path from root to a leaf. The sum of all nodes on that path is defined as the sum of that path. Given a number K, you have to remove (prune the tree) all nodes which don’t lie in any path with sum>=k.

Note: A node can be part of multiple paths. So we have to delete it only in case when all paths from it have sum less than K.

Consider the following Binary Tree
          1
      /      \
     2        3
   /   \     /  \
  4     5   6    7
 / \    /       /
8   9  12      10
   / \           \
  13  14         11
      /
     15

For input k = 20, the tree should be changed to following
(Nodes with values 6 and 8 are deleted)
          1
      /      \
     2        3
   /   \        \
  4     5        7
   \    /       /
    9  12      10
   / \           \
  13  14         11
      /
     15

For input k = 45, the tree should be changed to following.
      1
    /
   2
  /
 4
  \
   9
    \
     14
     /
    15


We strongly recommend you to minimize the browser and try this yourself first.

The idea is to traverse the tree and delete nodes in bottom up manner. While traversing the tree, recursively calculate the sum of nodes from root to leaf node of each path. For each visited node, checks the total calculated sum against given sum “k”. If sum is less than k, then free(delete) that node (leaf node) and return the sum back to the previous node. Since the path is from root to leaf and nodes are deleted in bottom up manner, a node is deleted only when all of its descendants are deleted. Therefore, when a node is deleted, it must be a leaf in the current Binary Tree.

 A Simpler Solution:
The above code can be simplified using the fact that nodes are deleted in bottom up manner. The idea is to keep reducing the sum when traversing down. When we reach a leaf and sum is greater than the leaf’s data, then we delete the leaf. Note that deleting nodes may convert a non-leaf node to a leaf node and if the data for the converted leaf node is less than the current sum, then the converted leaf should also be deleted.

 [[http://www.geeksforgeeks.org/remove-all-nodes-which-lie-on-a-path-having-sum-less-than-k/]]
 */

// todo: revisit
object RemoveNodesWhichDontLieInAnyPathWithSumGreaterThanK {

}
