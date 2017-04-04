package algos.epi.strings

/**
  * Page 97
  * Created by geek4you on 3/8/17.
  */
object ConvertBase extends App {

  /**
    * Converts base string into decimal int
    */
  def convertBase(numAsString: String, base: Int): Int = {
    val isNegative = numAsString.startsWith("-")

    var i = 0
    if (isNegative) i = 1 else i = 0

    var power = 1
    var result = 0
    var j = numAsString.length - 1
    while (j >= i) {
      val digit = numAsString.charAt(j)
      val valueOfDigit = getValueOfChar(digit)
      if (valueOfDigit >= base)
        throw new RuntimeException("Invalid Number !!")
      result += valueOfDigit * power
      power *= base
      j -= 1
    }

    if (isNegative)
      -1 * result
    else
      result
  }

  /**
    * To return value of a char. For example, 2 is
    * returned for '2'.  10 is returned for 'A', 11 for 'B'
    */
  def getValueOfChar(ch: Char): Int = {
    if (ch >= '0' && ch <= '9')
      ch - '0'
    else
      ch - 'A' + 10
  }

  /**
    * Converts decimal Int into base num string
    */
  def constructFromBase(numAsInt: Int, base: Int): String = {
    if (numAsInt == 0)
      ""
    else {
      constructFromBase(numAsInt / base, base) + {
        if (numAsInt % base >= 10) {
          'A' + numAsInt % base - 10
        } else {
          '0' + numAsInt % base
        }
      }.asInstanceOf[Char]
    }
  }

  override def main(args: Array[String]): Unit = {
    val num1 = 12
    println(constructFromBase(num1, 2))
    val num2 = 282
    println(constructFromBase(num2, 16))
    println(convertBase("11A", 16))
    println(convertBase("1100", 2))
  }

}
