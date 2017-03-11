package algos.epi.strings

import java.util

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

  def phoneMnemonic(phoneNumber: String): util.ArrayList[String] = {
    val partialMnemonic = new Array[Char](phoneNumber.length)
    val mnemonics = new util.ArrayList[String]()
    phoneMnemonicHelper(phoneNumber, 0, partialMnemonic, mnemonics)
    mnemonics
  }

  def phoneMnemonicHelper(phoneNumber: String,
                          digit: Int,
                          partialMnemonic: Array[Char],
                          mnemonics: util.ArrayList[String]): Unit = {

    if (digit == phoneNumber.length) {
      // All the digits are processed, so add partialMnemonic to the mnemonics
      // we add a copy since subsequent calls modify the partialMnemonic
      mnemonics.add(new String(partialMnemonic))
    } else {
      // Try all possible characters for this digit
      for (i <- 0 until mapping(phoneNumber.charAt(digit) - '0').length) {
        val ch = mapping(phoneNumber.charAt(i) - '0').charAt(i)
        partialMnemonic(digit) = ch
        phoneMnemonicHelper(phoneNumber, digit + 1, partialMnemonic, mnemonics)
      }
    }
  }
}
