package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/27/17.
  */
/**
  *Reverse alternate levels of a perfect binary tree
Given a Perfect Binary Tree, reverse the alternate level nodes of the binary tree.


Given tree:
               a
            /     \
           b       c
         /  \     /  \
        d    e    f    g
       / \  / \  / \  / \
       h  i j  k l  m  n  o

Modified tree:
  	          a
            /     \
           c       b
         /  \     /  \
        d    e    f    g
       / \  / \  / \  / \
      o  n m  l k  j  i  h
  */
/**
  *Method 2 (Using Two Traversals)

Another is to do two inorder traversals. Following are steps to be followed.
1) Traverse the given tree in inorder fashion and store all odd level nodes in an auxiliary array. For the above example given tree, contents of array become {h, i, b, j, k, l, m, c, n, o}
2) Reverse the array. The array now becomes {o, n, c, m, l, k, j, b, i, h}

3) Traverse the tree again inorder fashion. While traversing the tree, one by one take elements from array and store elements from array to every odd level traversed node.
For the above example, we traverse ‘h’ first in above array and replace ‘h’ with ‘o’. Then we traverse ‘i’ and replace it with n.

 methods: use preorder

 [[http://www.geeksforgeeks.org/reverse-alternate-levels-binary-tree/]]
  */
// todo: revisit
object ReverseAlternateLevelsPerfectBinaryTree {}
