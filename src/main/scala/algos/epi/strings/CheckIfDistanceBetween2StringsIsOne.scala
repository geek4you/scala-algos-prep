package algos.epi.strings

/**
  * Created by geek4you on 4/4/17.
  */
/**
  * @see http://www.geeksforgeeks.org/check-if-two-given-strings-are-at-edit-distance-one/
  *     An edit between two strings is one of the following changes.
  *     Add a character
  *     Delete a character
  *     Change a character
  *     Given two string s1 and s2, find if s1 can be converted to s2 with exactly one edit.
  *     Expected time complexity is O(m+n) where m and n are lengths of two strings.
  */
object CheckIfDistanceBetween2StringsIsOne {

  def check(input1: String, input2: String): Boolean = {

    if (Math.abs(input1.length - input2.length) > 1)
      false
    else {
      var count = 0 // Count of edits
      var (i, j) = (0, 0)
      while (i < input1.length && j < input2.length) {
        // If current characters don't match
        if (input1.charAt(i) != input2.charAt(j)) {
          if (count == 1)
            return false

          // If length of one string is
          // more, then only possible edit
          // is to remove a character
          if (input1.length > input2.length)
            i += 1
          else if (input1.length < input2.length)
            j += 1
          else { //Iflengths of both strings is same
            i += 1
            j += 1
          }

          count += 1 // Increment count of edits
        } else // If current characters match
          {
            i += 1
            j += 1
          }
      }

      // If last character is extra in any string
      if (i < input1.length || j < input2.length)
        count += 1

      count == 1
    }
  }

  def main(args: Array[String]): Unit = {
    val input1 = "geeks"
    val input2 = "geek"
    println(check(input1, input2))
  }
}
