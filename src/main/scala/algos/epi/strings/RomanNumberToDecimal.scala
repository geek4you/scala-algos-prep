package algos.epi.strings

/**
  * Created by geek4you on 3/10/17.
  */
/**
  * Page 106
  * [[http://www.geeksforgeeks.org/converting-roman-numerals-decimal-lying-1-3999/]]
  */
object RomanNumberToDecimal extends App {

  def mapping =
    Map('I' -> 1,
        'V' -> 5,
        'X' -> 10,
        'L' -> 50,
        'C' -> 100,
        'D' -> 500,
        'M' -> 1000)

  def romanNumberToDecimal(input: String): Int = {
    var result = 0
    for (i <- 0 to input.length - 2) {
      if (mapping(input.charAt(i)) > mapping(input.charAt(i + 1))) {
        result += mapping(input.charAt(i))
      } else {
        result -= mapping(input.charAt(i))
      }
    }
    result += mapping(input.charAt(input.length-1))
    result
  }
  override def main(args: Array[String]): Unit = {
    val st = "MCMIV"
    println(romanNumberToDecimal(st))
  }

}
