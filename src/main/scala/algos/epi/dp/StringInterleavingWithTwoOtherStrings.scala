package algos.epi.dp

/**
  * Created by geek4you on 4/4/17.
  */
/**
  * Page :316
  *
  * @see [[http://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings/]]
  * The solution in the above link doesn't work for all the cases.
  * @see [[http://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2/]]
  */
object StringInterleavingWithTwoOtherStrings {

  /**
    * Non DP Solution
    */
  def isInterleavedRecursive(str1: String,
                             str2: String,
                             interleavedString: String,
                             str1Idx: Int,
                             str2Idx: Int,
                             str3Idx: Int): Boolean = {
    // Base Case: If all strings are empty
    if (str1Idx == str1.length && str2Idx == str2.length && str3Idx == interleavedString.length)
      return true

    // If interleavedString is empty and any of the two strings is not empty
    if (str3Idx == interleavedString.length)
      return false

    // If any of the below mentioned two possibilities is true,
    // then return true, otherwise false
    // 1) If first character of interleavedString matches with first character of str1, we move one character ahead in
    // str1 and interleavedString and recursively check.
    // 2) If first character of interleavedString matches with first character of str2, we move one character ahead in
    // str2 and interleavedString and recursively check.

    ((interleavedString.charAt(str3Idx) == str1.charAt(str1Idx)) && isInterleavedRecursive(
      str1,
      str2,
      interleavedString,
      str1Idx + 1,
      str2Idx,
      str3Idx + 1)) || ((interleavedString.charAt(str3Idx) == str2.charAt(
      str2Idx)) && isInterleavedRecursive(str1,
                                          str2,
                                          interleavedString,
                                          str1Idx,
                                          str2Idx + 1,
                                          str3Idx + 1))

  }

  def main(args: Array[String]): Unit = {
    val str1 = "aab"
    val str2 = "axy"
    val interleavedString = "aaxaby"
    println(isInterleavedRecursive(str1, str2, interleavedString, 0, 0, 0))
  }
}
