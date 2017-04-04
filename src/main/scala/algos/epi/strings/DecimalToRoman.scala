package algos.epi.strings

/**
  * Created by geek4you on 3/10/17.
  */
/**
  * Page 106
  *
  */
object DecimalToRoman extends App {

  /**
    * Rules:
    *  I can immediately precede V and X
    *  X can immediately precede L and C
    *  C can immediately precede D and M
    */
  def decimalToRoman(input: Int): String = {
    val l = mapping.floorKey(input)
    if (l == input) {
      mapping.get(input)
    } else {
      mapping.get(l) + decimalToRoman(input - l)
    }
  }

  def mapping = {
    val map = new java.util.TreeMap[Int, String]()
    map.put(1000, "M")
    map.put(900, "CM")
    map.put(500, "D")
    map.put(400, "CD")
    map.put(100, "C")
    map.put(90, "XC")
    map.put(50, "L")
    map.put(40, "XL")
    map.put(10, "X")
    map.put(9, "IX")
    map.put(5, "V")
    map.put(4, "IV")
    map.put(1, "I")
    map
  }

  override def main(args: Array[String]): Unit = {
    val number = 1907
    println(decimalToRoman(number))
  }
}
