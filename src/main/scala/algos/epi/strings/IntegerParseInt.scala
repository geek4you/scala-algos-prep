package algos.epi.strings

/**
  * Created by geeks4geeks on 3/7/17.
  */
/**
  * Page 96
  * Convert String into Integer
  */
object IntegerParseInt extends App {

  def convert(string: String): Int = {

    // get the sign
    var i = 0
    var negative = false
    if (string.charAt(0) == '-') {
      negative = true
    }
    var result = 0
    while (i < string.length) {
      val char = string.charAt(i)
      if (char >= '0' && char <= '9') {
        val digit = char - '0'
        result = result * 10 + digit
      }
      i += 1
    }

    if (negative)
      result *= -1

    result
  }

  override def main(args: Array[String]): Unit = {
    val str1 = "-123"
    val str2 = "023"
    println(convert(str1))
    println(convert(str2))
  }
}
