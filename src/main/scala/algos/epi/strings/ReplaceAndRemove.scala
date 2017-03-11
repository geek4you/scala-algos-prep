package algos.epi.strings

/**
  * Page: 98
  * Created by geek4you on 3/8/17.
  */
object ReplaceAndRemove {

  def replaceAndRemove(arr: Array[Char]): Int = {

    // first remove b's and count number of a's
    var (writeIdx, aCount) = (0, 0)

    for (i <- arr.indices) {
      if (arr(i) != 'b') {
        arr(writeIdx) = arr(i)
        writeIdx += 1
      }
      if (arr(i) == 'a')
        aCount += 1
    }

    // backward iteration: replace a's with dd's starting from the end
    var curIdx = writeIdx - 1
    writeIdx = writeIdx + aCount - 1
    val finalSize = writeIdx + 1

    while (curIdx >= 0) {
      if (arr(curIdx) == 'a') {
        arr(writeIdx) = 'd'
        writeIdx -= 1
        arr(writeIdx) = 'd'
        writeIdx -= 1
      } else {
        arr(writeIdx) = arr(curIdx)
        writeIdx -= 1
      }
      curIdx -= 1
    }

    finalSize
  }

  def main(args: Array[String]): Unit = {
    val chArry = new Array[Char](6)
    chArry(0) = 'a'
    chArry(1) = 'b'
    chArry(2) = 'a'
    chArry(3) = 'c'

    replaceAndRemove(chArry)
    println(chArry.mkString)
  }
}
