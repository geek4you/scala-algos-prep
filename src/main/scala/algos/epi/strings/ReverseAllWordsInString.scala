package algos.epi.strings

/**
  * Created by geek4you on 3/9/17.
  */
object ReverseAllWordsInString extends App {

  def reverseWords(string: String): String = {
    var chArry = string.toCharArray
    var startIdx = 0
    var endIdx = 0
    var i = 0
    var done = false
    while (i < chArry.length && !done) {
      endIdx = find(chArry, ' ', i)
      if(endIdx == -1){
        done = true
      }else{
        reverse(chArry, startIdx, endIdx-1)
        startIdx = endIdx+1
        i = endIdx+1
      }
    }

    if(endIdx == -1 && startIdx != 0){
      reverse(chArry, startIdx, chArry.length-1)
    }
    reverse(chArry, 0, chArry.length-1)
    new String(chArry)
  }

  def reverse(chArray: Array[Char], idx1: Int, idx2: Int): Unit = {

    var left = idx1
    var right = idx2

    while (left < right) {
      val tmp = chArray(left)
      chArray(left) = chArray(right)
      chArray(right) = tmp
      left += 1
      right -= 1
    }
  }

  /**
    * Returns the first occurrence of ch in the arr starting from index startIdx
    */
  def find(arr: Array[Char], ch: Char, startIdx: Int): Int = {
    var i = startIdx
    while (i < arr.length) {
      if (arr(i) == ch) {
        return i
      }
      i += 1
    }
    -1
  }

  override def main(args: Array[String]): Unit = {
    val str = "alice likes boby"
    println(reverseWords(str))
  }

}
