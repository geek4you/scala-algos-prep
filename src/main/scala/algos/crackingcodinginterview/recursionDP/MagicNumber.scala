package algos.crackingcodinginterview.recursionDP

/**
  * Created by geek4you on 4/24/17.
  */
/**
  * Page 109
  */
object MagicNumber {

  def magicNumber(input: Array[Int]): Int = {
    directedMagicNumber(input, 0, input.length - 1)

  }
  def directedMagicNumber(input: Array[Int], start: Int, end: Int): Int = {
    if (end < start || (!input.indices.contains(end)) || (!input.indices
          .contains(start)))
      -1
    else {
      val midIndex = start + (end - start) / 2
      val midValue = input(midIndex)
      if (midIndex == midValue) {
        return midIndex
      }

      // search left
      val leftIndex = Math.min(midIndex - 1, midValue)
      val left = directedMagicNumber(input, start, leftIndex)
      if (left >= 0)
        return left

      // seach right
      val rightIndex = Math.max(midIndex - 1, midValue)
      val right = directedMagicNumber(input, rightIndex, end)
      right
    }
  }
}
