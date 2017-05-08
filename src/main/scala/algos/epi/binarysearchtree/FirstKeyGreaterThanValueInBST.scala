package algos.epi.binarysearchtree

/**
  * Created by geek4you on 5/7/17.
  */
object FirstKeyGreaterThanValueInBST {

  def findFirstGreaterKeyInBST(root: Node[Int], key: Int): Node[Int] = {
    var subTree = root
    var firstSoFar: Node[Int] = null
    while (Option(subTree).isDefined) {
      if (subTree.data > key) {
        firstSoFar = subTree
        subTree = subTree.left
      } else { // Root and all the keys in the left sub tree are smaller than the key. Skip them go the right sub tree
        subTree = subTree.right
      }
    }
    firstSoFar
  }
}
