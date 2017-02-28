package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/24/17.
  */
/**
  * Print Left View of a Binary Tree
Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from left side. Left view of following tree is 12, 10, 25.

          12
       /     \
     10       30
            /    \
          25      40
The left view contains all nodes that are first nodes in their levels. A simple solution is to do level order traversal and print the first node in every level.

The problem can also be solved using simple recursive traversal. We can keep track of level of a node by passing a parameter to all recursive calls. The idea is to keep track of maximum level also. Whenever we see a node whose level is more than maximum level so far, we print the node because this is the first node in its level (Note that we traverse the left subtree before right subtree). Following is the implementation-
  */
object LeftViewBinaryTree {

  var maxLvl: Int = _
  def leftViewOfBinaryTree[A](root: Node[A]): Unit = {

    if (Option(root).isDefined) {
      leftViewUtil(root, 1)
    }

  }

  def leftViewUtil[A](root: Node[A], lvl: Int) {
    if (Option(root).isDefined) {
      if (lvl > maxLvl) {
        println(root.data)
        maxLvl = lvl
      }

      leftViewUtil(root.left, lvl + 1)
      leftViewUtil(root.right, lvl + 1)
    }

  }
}
