package datastructures.trees

/**
  * Created by geek4you on 2/19/17.
  */
// First, we define a Binary Tree ADT.

sealed trait Tree[+A]
case object EmptyTree extends Tree[Nothing]
case class Node1[A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A]

// In order to conveniently encode tree instances, we add following methods in the companion object of Tree.
object Tree {
  def empty[A]: Tree[A] = EmptyTree
  def node[A](value: A,
              left: Tree[A] = empty,
              right: Tree[A] = empty): Tree[A] = Node1(value, left, right)

  //Next, in order to facilitate structural recursion, we define fold function for the binary tree as follows:
  def fold[A, B](t: Tree[A], z: B)(f: (B, A, B) => B): B = t match {
    case EmptyTree => z
    case Node1(x, l, r) => f(fold(l, z)(f), x, fold(r, z)(f))
  }

  /**
    * It allows to traverse the tree, perform transformations and accumulate the result.
    * For instance, we can define a function to count the length of the tree in a generic manner–
    *
    * def size[T] (tree: Tree[T]) =
      fold(tree, 0: Int){(l,x,r) => l + r + 1}

    scala> size(t1)
    res11: Int = 7
    */
  /**
    * Also, we can define a map function that applies a function f: A ⇒ B on the value of each Node.
    * Note that the application of map is always structure-preserving, that is,
    * it retains the existing shape as it was before application (unlike the aforementioned size function)
    * and perform only local transformations.
    */
  def map[A, B](tree: Tree[A])(f: A => B): Tree[B] =
    fold(tree, Tree.empty[B]) { (l, x, r) =>
      Node1(f(x), l, r)
    }

  /**
    * scala> map (t1) ( x => x * 10)
    res11: Tree[Int] =
    Node(40,
      Node(20,
        Node(10,EmptyTree,EmptyTree),
        Node(30,EmptyTree,EmptyTree)),
      Node(70,
        Node(60,EmptyTree,EmptyTree),
        Node(90,EmptyTree,EmptyTree)))

    */
  /**
    * As you have guessed, we can similarly define the invertTree function in a generic manner as follows:
    *
    */
  def invertTree[A](tree: Tree[A]): Tree[A] =
    fold(tree, Tree.empty[A]) { (leftT, value, rightT) =>
      Node1(value, rightT, leftT)
    }

}
