package algos.geeks4geeks.trees

/**
  * Created by geek4you on 3/2/17.
  */

/**
 * Sink Odd nodes in Binary Tree
Given a Binary Tree having odd and even elements, sink all its odd valued nodes such that no node with odd value could be parent of node with even value. There can be multiple outputs for a given tree, we need to print one of them. It is always possible to convert a tree (Note that a node with even nodes and all odd nodes follows the rule)

Input :
       1
    /    \
   2      3
Output
       2            2
    /    \   OR   /   \
   1      3      3     1


Input :
       1
     /    \
    5       8
  /  \     /  \
 2    4   9    10
Output :
    2                 4
  /    \            /    \
 4       8    OR   2      8    OR .. (any tree with
/  \    /  \      /  \   / \          same keys and
5   1  9   10    5    1 9   10        no odd is parent
                                      of even)

 */

/**
 * [[http://www.geeksforgeeks.org/sink-odd-nodes-binary-tree/]]
 */
object SinkOddNodesInBinaryTree {}
