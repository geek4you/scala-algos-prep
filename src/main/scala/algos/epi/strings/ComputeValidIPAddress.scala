package algos.epi.strings

import java.util

/**
  * Created by geek4you on 3/9/17.
  */
/**
  * Page 106
  */
object ComputeValidIPAddress extends App {

  /**
    * Checks if the string is valid ip part.
    * 1) String should not be more than 3 chars
    * 2) "00", "000","01" are invalid parts. You can have "0"
    * 3) part value should lie between 0 and 255
    */
  def isValidPart(part: String): Boolean = {
    if (part.length > 3) {
      false
    } else if (part.startsWith("0") && part.length > 1) {
      false
    } else {
      val p = Integer.parseInt(part)
      p >= 0 && p <= 255
    }
  }

  def getValidIps(input: String): util.List[String] = {
    val result = new util.ArrayList[String]()

    var i = 1 // starts from 1 as subSring(0,1) = first char
    while (i < input.length && i < 4) {
      val first = input.substring(0, i)
      if (isValidPart(first)) {
        var j = 1
        while (j + i < input.length && j < 4) {
          val second = input.substring(i, i + j)
          if (isValidPart(second)) {
            var k = 1
            while (k + i + j < input.length && k < 4) {
              val third = input.substring(i + j, i + j + k)
              val fourth = input.substring(i + j + k)
              if (isValidPart(third) && isValidPart(fourth)) {
                result.add(s"$first.$second.$third.$fourth")
              }
              k += 1
            }
          }
          j += 1
        }
      }
      i += 1
    }
    result
  }

  override def main(args: Array[String]): Unit = {
    val input = "19216811"
    getValidIps(input).forEach(x => println(x))
  }
}
