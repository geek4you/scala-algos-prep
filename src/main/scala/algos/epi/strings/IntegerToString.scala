package algos.epi.strings

/**
  * Created by geek4you on 3/7/17.
  */
class IntegerToString extends App {

  def convert(int: Int): Unit = {
    var number = int
    val negative = if (number < 0) true else false
    val builder = new StringBuilder()

    do {
      val digit = '0' + Math.abs(number % 10)
      builder.append(digit)
      number = number / 10
    } while (number != 0)

    if (negative)
      builder.append('-')

    builder.reverse.toString()
  }

  override def main(args: Array[String]): Unit = {
    val number1 = -434
    println(convert(number1))
    val number2 = 65
    println(convert(number2))
  }
}
