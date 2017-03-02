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
object ReverseAlternateLevelsPerfectBinaryTree extends App {

  def preOrder[A](root1: Node[A], root2: Node[A], lvl: Int): Unit = {
    if (Option(root1).isDefined && Option(root2).isDefined) {
      // Swap subtrees if level is even
      if (lvl % 2 == 0)
        swap(root1, root2)

      // Recur for left and right subtrees (Note : left of root1
      // is passed and right of root2 in first call and opposite
      // in second call.
      preOrder(root1.left, root2.right, lvl + 1)
      preOrder(root1.right, root1.left, lvl + 1)
    }
  }

  def swap[A](node1: Node[A], node2: Node[A]): Unit = {
    val tmp = node1.data
    node1.data = node2.data
    node2.data = tmp
  }

  override def main(args: Array[String]): Unit = {
    val root = Node('a')
    root.left = Node('b')
    root.right = Node('c')
    root.left.left = Node('d')
    root.left.right = Node('e')
    root.right.left = Node('f')
    root.right.right = Node('g')
    root.left.left.left = Node('h')
    root.left.left.right = Node('i')
    root.left.right.left = Node('j')
    root.left.right.right = Node('k')
    root.right.left.left = Node('l')
    root.right.left.right = Node('m')
    root.right.right.left = Node('n')
    root.right.right.right = Node('o')
    println(s"Inorder Traversal : ${InOrderTraversal.inorder(root)}")
    preOrder(root.left, root.right, 0)
    println(s"Inorder Traversal : ${InOrderTraversal.inorder(root)}")

  }
}
