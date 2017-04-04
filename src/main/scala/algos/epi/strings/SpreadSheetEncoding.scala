package algos.epi.strings

/**
  * Created by geek4you on 3/8/17.
  */
// TODO: revisit
/**
  * Page 98
  */
object SpreadSheetEncoding extends App {

  def encode(col: String): Int = {
    var power = 1
    var result = 0
    var i = col.length - 1
    while (i >= 0) {
      val digit = col.charAt(i)
      val valueOfDigit = digit - 'A' + 1
      result += power * valueOfDigit
      power = power * 26
      i -= 1
    }
    result
  }

  def decode(col: Int): String = {
    val buf = new StringBuffer()
    var num = col
    while (num > 0) {
      // Find remainder
      val rem = num % 26

      // If remainder is 0, then a 'Z' must be there in output
      if (rem == 0) {
        buf.append('Z')
        num = num / 26 - 1
      } else {
        buf.append(rem + 'A')
        num /= 26
      }
    }
    buf.reverse().toString
  }

  override def main(args: Array[String]): Unit = {
    val col = "ZZ"
    println(encode(col))
    println(decode(702))
  }

}
