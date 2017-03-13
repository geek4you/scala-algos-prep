package algos.epi.stacks

import java.util

/**
  * Created by geek4you on 3/12/17.
  */
/**
  * Page: 136
  */
object ReversePolishNotationEvalutaion extends App {

  def eval(rpnExpression: String): Int = {

    val intermediateList = new util.LinkedList[Int]()
    val delimiter = ","
    val tokens = rpnExpression.split(delimiter)

    tokens.foreach(token => {
      if (token.length == 1 && "+-*/"
            .contains(token)) {
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
      } else { // it is a number
        intermediateList.addFirst(Integer.parseInt(token))
      }
    })
    intermediateList.removeFirst()
  }

  override def main(args: Array[String]): Unit = {
    val rpn = "3,4,+,2,*,1,+"
    println(eval(rpn))
    assert(eval(rpn) == 15)
  }
}
