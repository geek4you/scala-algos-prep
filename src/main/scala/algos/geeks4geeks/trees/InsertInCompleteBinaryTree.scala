package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/23/17.
  */
/**
  * [[http://www.geeksforgeeks.org/linked-complete-binary-tree-its-creation/]]
  *
  *
  * A complete binary tree is a binary tree where each level ‘l’ except the last has 2^l nodes and the nodes at the last level are all left aligned. Complete binary trees are mainly used in heap based data structures.
The nodes in the complete binary tree are inserted from left to right in one level at a time. If a level is full, the node is inserted in a new level.

Below are some of the complete binary trees.

       1
      / \
     2   3

        1
       / \
      2   3
     / \  /
    4  5 6
Below binary trees are not complete:

     1
    / \
   2   3
  /    /
  4   5

       1
      / \
     2   3
    / \  /
   4  5 6
  /
 7

  * Following are steps to insert a new node in Complete Binary Tree.
1. If the tree is empty, initialize the root with new node.

2. Else, get the front node of the queue.
…….If the left child of this front node doesn’t exist, set the left child as the new node.
…….else if the right child of this front node doesn’t exist, set the right child as the new node.

3. If the front node has both the left child and right child, Dequeue() it.

4. Enqueue() the new node.
  */

// todo: REVISIT
object InsertInCompleteBinaryTree {}
