package algos.epi.binarytrees

/**
  * Created by geek4you on 5/6/17.
  */
/**
  * Page 159
  */
object SumRootToLeafPaths {

  def sumRootToLeafPath(node: Node[Int]): Int = {
    sumRootToLeafPathHelper(node, 0)
  }

  def sumRootToLeafPathHelper(node: Node[Int], partialSum: Int): Int = {
    if (Option(node).isEmpty)
      0
    else {
      val partialSumNew = partialSum * 2 + node.data
      if (Option(node.left).isEmpty && Option(node.right).isEmpty)
        partialSumNew
      else {
        sumRootToLeafPathHelper(node.left, partialSumNew) + sumRootToLeafPathHelper(
          node.right,
          partialSumNew)
      }
    }
  }
}
