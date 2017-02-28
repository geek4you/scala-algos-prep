package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/25/17.
  */
/**
  * [[http://www.geeksforgeeks.org/print-nodes-dont-sibling-binary-tree/]]
  *
  * Given a Binary Tree, print all nodes that don’t have a sibling (a sibling is a node that has same parent.
  * In a Binary Tree, there can be at most one sibling). Root should not be printed as root cannot have a sibling.
  *
  * This is a typical tree traversal question. We start from root and check if the node has one child, if yes then print
  * the only child of that node. If node has both children, then recur for both the children.
  */
object PrintNodesWithoutSiblings {}
