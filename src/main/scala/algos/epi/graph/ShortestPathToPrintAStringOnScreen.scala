package algos.epi.graph

/**
  * Created by geek4you on 4/9/17.
  */
/**
  * @see http://www.geeksforgeeks.org/print-shortest-path-print-string-screen/
  */
object ShortestPathToPrintAStringOnScreen {

  def printPath(input: String): Unit = {
    // start from charcater 'A' present at position (0, 0)
    var curCh = ChPosition(0, 0)

    for (i <- 0 until input.length) {
      val nextCh =
        ChPosition((input.charAt(i) - 'A') / 5, (input.charAt(i) - 'A') % 5)

      // move up if nextCh is above
      while (curCh.row - nextCh.row > 0) {
        println(s"Move Up from $curCh for $nextCh")
        curCh.row -= 1
      }

      // move down if nextCh is below
      while (curCh.row - nextCh.row < 0) {
        println(s"Move Down from $curCh for $nextCh")
        curCh.row += 1
      }

      // move left if nextCh is left
      while (curCh.col - nextCh.col > 0) {
        println(s"Move left from $curCh for $nextCh")
        curCh.col -= 1
      }

      // move right if nextCh is right
      while (curCh.col - nextCh.col < 0) {
        println(s"Move right from $curCh for $nextCh")
        curCh.col += 1
      }

      println("Press Ok")
    }

  }

  def main(args: Array[String]): Unit = {
    val str = "COZY"
    printPath(str)
  }

  case class ChPosition(var row: Int, var col: Int)
}
