package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/24/17.
  */
/**
  *
  */
object DifferenceBwtSumOfEvenAndOddLevelNodes {

  def difference(node: Node[Int]): Int = {
    if (Option(node).isDefined) {
      node.data - difference(node.left) - difference(node.right)
    } else
      0
  }

}
