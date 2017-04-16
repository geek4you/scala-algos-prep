package algos.epi.ninja

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 4/14/17.
  */
/**
  * Page 453
  */
object JustifyText {

  def justifyText(words: Array[String], lineLength: Int): ArrayBuffer[String] = {
    var currLineStart = 0
    var numWordsCurrLine = 0
    var currLineLength = 0
    val result = new ArrayBuffer[String]()
    for (i <- words.indices) {
      // currLineStart is the first word in the current line, and i is used to identify the last word.
      numWordsCurrLine += 1
      // lookAheadLineLength = current line length + the length if the current
      //                        word is added to the line + spaces
      val lookAheadLineLength = currLineLength + words(i).length + (numWordsCurrLine - 1)
      if (lookAheadLineLength == lineLength) { // length of the line with the current word matches the total length permitted
        result += joinLinesWithSpace(words,
                                     currLineStart,
                                     i,
                                     i - currLineStart)
        currLineStart = i + 1
        numWordsCurrLine = 0
        currLineLength = 0
      } else if (lookAheadLineLength > lineLength) { // length of the line with current word exceeds the total length permitted
        result += joinLinesWithSpace(words,
                                     currLineStart,
                                     i - 1,
                                     lineLength - currLineLength)
        currLineStart = i
        numWordsCurrLine = 1
        currLineLength = words(i).length
      } else { // lookAheadLineLength < lineLength , so more words can potentially fit in this line
        currLineLength += words(i).length
      }
    }

    // // handles last line. last line is left alligned
    if (numWordsCurrLine > 0) {
      val line = new StringBuilder(
        joinLinesWithSpace(words,
                           currLineStart,
                           words.length - 1,
                           numWordsCurrLine - 1))
      for (i <- 0 until (lineLength - currLineLength - (numWordsCurrLine - 1))) {
        line.append("_")
      }
      result += line.toString()
    }
    result
  }

  /**
    * Join strings in words[start : end] with numSpaces spaces spread evenly.
    */
  def joinLinesWithSpace(words: Array[String],
                         start: Int,
                         end: Int,
                         numSpaces: Int): String = {
    var numWordsCurrLine = end - start + 1
    var totalNumSpaces = numSpaces
    val line = new StringBuilder()
    for (i <- start until end) {
      line.append(words(i))
      numWordsCurrLine -= 1
      val numCurrSpaces =
        Math.ceil(totalNumSpaces.toDouble / numWordsCurrLine).toInt
      for (j <- 0 until numCurrSpaces) {
        line.append("_")
      }
      totalNumSpaces -= numCurrSpaces
    }
    line.append(words(end))
    for (i <- 0 until totalNumSpaces) {
      line.append("_")
    }
    line.toString()
  }

  def main(args: Array[String]): Unit = {
    val words = Array("The",
                      "quick",
                      "brown",
                      "fox",
                      "jumped",
                      "over",
                      "the",
                      "lazy",
                      "dogs")
    justifyText(words, 11).foreach(println)
  }
}
