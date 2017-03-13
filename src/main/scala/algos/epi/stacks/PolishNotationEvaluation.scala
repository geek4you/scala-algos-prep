package algos.epi.stacks

import java.util

/**
  * Created by geek4you on 3/12/17.
  */
/**
  * Page 136
  * Reverse of RPN [[ReversePolishNotationEvalutaion]]
  */
object PolishNotationEvaluation extends App {

  def eval(pnExpression: String): Int = {
    val intermediateList = new util.LinkedList[Int]()
    val reversePnExpression = pnExpression.reverse
    val delimiter = ","
    val tokens = reversePnExpression.split(delimiter)

    tokens.foreach(token => {
      if (token.length == 1 & "+-*/".contains(token)) {
        val firstNumber = intermediateList.removeFirst()
        val secondNumber = intermediateList.removeFirst()

        val intermediateResult = token.charAt(0) match {
          case '+' => firstNumber + secondNumber
          case '-' => firstNumber - secondNumber
          case '*' => firstNumber * secondNumber
          case '/' => firstNumber / secondNumber
          case _ =>
            throw new RuntimeException(s"Malformed RPN with token $token")
        }
        intermediateList.addFirst(intermediateResult)
      } else { // number
        intermediateList.addFirst(Integer.parseInt(token))
      }
    })
    intermediateList.removeFirst()
  }

  override def main(args: Array[String]): Unit = {
    val pnExpression = "-,+,*,2,3,*,5,4,9"
    println(eval(pnExpression))
  }

}
