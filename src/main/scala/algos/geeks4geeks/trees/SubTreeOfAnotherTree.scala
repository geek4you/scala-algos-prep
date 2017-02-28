package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/23/17.
  */
/**
  *  Solution1: T(n) = O(mn)
  *  Traverse the tree T in preorder fashion. For every visited node in the traversal,
  *  see if the subtree rooted with this node is identical to S.
  * [[http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/]]
  *
  * Optimized Solution:
  * The idea is based on the fact that inorder and preorder/postorder uniquely identify a binary tree.
  * Tree S is a subtree of T if both inorder and preorder traversals of S arew substrings of inorder and
  * preorder traversals of T respectively.
  * Following are detailed steps.
  * 1) Find inorder and preorder traversals of T, store them in two auxiliary arrays inT[] and preT[].
  * 2) Find inorder and preorder traversals of S, store them in two auxiliary arrays inS[] and preS[].
  * 3) If inS[] is a subarray of inT[] and preS[] is a subarray preT[], then S is a subtree of T. Else not.
  * We can also use postorder traversal in place of preorder in the above algorithm.
  * Let us consider the above example
  * Inorder and Preorder traversals of the big tree are.
  * inT[]   =  {a, c, x, b, z, e, k}
  * preT[]  =  {z, x, a, c, b, e, k}
  * Inorder and Preorder traversals of small tree are
  * inS[]  = {a, c, x, b}
  * preS[] = {x, a, c, b}
  * We can easily figure out that inS[] is a subarray of
  * inT[] and preS[] is a subarray of preT[].
  * [[http://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/]]
  *
  * subString can be implemented in O(n) using KMP Algorithm
  * [[http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/]]
  */
// todo: REVISIT
object SubTreeOfAnotherTree {}
