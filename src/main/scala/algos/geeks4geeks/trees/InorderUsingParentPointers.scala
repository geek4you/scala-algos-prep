package algos.geeks4geeks.trees

/**
  * Created by geek4you on 3/1/17.
  */
/**
  *Inorder Non-threaded Binary Tree Traversal without Recursion or Stack
We have discussed Thread based Morris Traversal. Can we do inorder traversal without threads if we have parent pointers available to us?

Input: Root of Below Tree [Every node of
       tree has parent pointer also]
        10
      /    \
     5     100
           /  \
          80  120
Output: 5 10 80 100 120
The code should not extra space (No Recursion
and stack)
We strongly recommend you to minimize your browser and try this yourself first.
In inorder traversal, we follow “left root right”. We can move to children using left and right pointers. Once a node is visited, we need to move to parent also. For example, in the above tree, we need to move to 10 after printing 5. For this purpose, we use parent pointer. Below is algorithm.

1. Initialize current node as root
2. Initialize a flag: leftdone = false;
3. Do following while root is not NULL
     a) If leftdone is false, set current node as leftmost
        child of node.
     b) Mark leftdone as true and print current node.
     c) If right child of current nodes exists, set current
        as right child and set leftdone as false.
     d) Else If parent exists, If current node is left child
        of its parent, set current node as parent.
        If current node is right child, keep moving to ancestors
        using parent pointer while current node is right child
        of its parent.
     e) Else break (We have reached back to root)
Illustration:

Let us consider below tree for illustration.
        10
      /    \
     5     100
           /  \
          80  120

Initialize: Current node = 10, leftdone = false

Since leftdone is false, we move to 5 (3.a), print it
and set leftdone = true.

Now we move to parent of 5 (3.d). Node 10 is
printed because leftdone is true.

We move to right of 10 and set leftdone as false (3.c)

Now current node is 100. Since leftdone is false, we move
to 80 (3.a) and set leftdone as true.  We print current
node 80 and move back to parent 100 (3.d).  Since leftdone
is true, we print current node 100.

Right of 100 exists, so we move to 120 (3.c).   We print
current node 120.

Since 120 is right child of its parent we keep moving to parent
while parent is right child of its parent.  We reach root. So
we break the loop and stop
Below is C++ implementation of above algorithm. Note that the implementation uses Binary Search Tree instead of Binary Tree. We can use the same function inorder() for Binary Tree also. The reason for using Binary Search Tree in below code is, it is easy to construct a Binary Search Tree with parent pointers and easy to test the outcome (In BST inorder traversal is always sorted).
  *
  * [[http://www.geeksforgeeks.org/inorder-non-threaded-binary-tree-traversal-without-recursion-or-stack/]]
  */
//todo: REVISIT IMP
object InorderUsingParentPointers extends App {

  def inorder[A](node: NodeWithParentPointer[A]): Unit = {
    var leftDone = false
    var current = node
    var done = false

    // Start traversal from root
    while (Option(current).isDefined && !done) {
      // If left child is not traversed, find the
      // leftmost child
      if (!leftDone) {
        while (Option(current.left).isDefined) current = current.left
      }

      // Print root's data
      println(current.data)

      // Mark left as done
      leftDone = true

      // If right child exists
      if (Option(current.right).isDefined) {
        leftDone = false
        current = current.right
      } // If right child doesn't exist, move to parent
      else if (Option(current.parent).isDefined) {
        // If this current is right child of its parent,
        // visit parent's parent first
        while (Option(current.parent).isDefined
               && current == current.parent.right) current = current.parent

        if (Option(current.parent).isEmpty)
          done = true
        else
          current = current.parent
      } else done = true
    }
  }

}
