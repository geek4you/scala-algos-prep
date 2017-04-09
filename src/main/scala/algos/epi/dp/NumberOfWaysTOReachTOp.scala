package algos.epi.dp

/**
  * Created by geek4you on 4/6/17.
  */
object NumberOfWaysTOReachTOp {

  def numberOfWaysToTop(top: Int, maximumStep: Int): Int = {
    computeNumberOfWaysToH(top, maximumStep, new Array[Int](top + 1))
  }

  def computeNumberOfWaysToH(n: Int,
                             maximumStep: Int,
                             numberOfWaysToH: Array[Int]): Int = {
    1
  }
}
