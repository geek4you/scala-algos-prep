package algos.epi.strings

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 3/9/17.
  */
/**
  * Page: 102
  */
// todo: Check the style. Very Imp. can be reused in many places. 7loops => recursive calls
object MnemonicsForPhoneNumber {

  val mapping = Array[String]("0",
                              "1",
                              "ABC",
                              "DEF",
                              "GHI",
                              "JKL",
                              "MNO",
                              "PQRS",
                              "TUV",
                              "WXYZ")

  def phoneMnemonic(phoneNumber: String): ArrayBuffer[String] = {
    val mnemonics = new ArrayBuffer[String]()
    directedPhoneMnemonic(phoneNumber, 0, new ArrayBuffer[Char](), mnemonics)
    mnemonics
  }

  def directedPhoneMnemonic(phoneNumber: String,
                            level: Int,
                            partialMnemonic: ArrayBuffer[Char],
                            mnemonics: ArrayBuffer[String]): Unit = {
    if (level == phoneNumber.length)
      mnemonics += new String(partialMnemonic.toArray)
    else {
      val digit = phoneNumber.charAt(level) - '0'
      for (i <- 0 until mapping(digit).length) {
        partialMnemonic += mapping(digit).charAt(i)
        directedPhoneMnemonic(phoneNumber,
                              level + 1,
                              partialMnemonic,
                              mnemonics)
        partialMnemonic.remove(partialMnemonic.size - 1)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val number = "669258"
    println(phoneMnemonic(number).mkString("\n"))
  }
}
