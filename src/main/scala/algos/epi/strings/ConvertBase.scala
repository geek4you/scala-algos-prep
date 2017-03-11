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
    if (isNegative) i = 0 else i = 1

    var power = 1
    var result = 0
    while (i < numAsString.length) {
      result *= base
      val digit = numAsString.charAt(i)
        result += digit
      i += 1
    }

    if (isNegative)
      -1 * result
    else
      result
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
  }

}
