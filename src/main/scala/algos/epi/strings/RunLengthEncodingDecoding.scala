package algos.epi.strings

/**
  * Created by geek4you on 3/10/17.
  */
object RunLengthEncodingDecoding extends App {

  def encode(input: String): String = {
    val buf = new StringBuilder()
    var count = 1
    for(i <- 1 to input.length){
      if(i == input.length || input.charAt(i) != input.charAt(i-1)){
        buf.append(count)
        buf.append(input.charAt(i - 1))
        count = 1
      }else{
        count += 1
      }
    }
    buf.toString()
  }

  def decode(input: String): String = {
    val buf = new StringBuilder()
    for(i <- 0 to input.length-1){
      if(!Character.isDigit(input.charAt(i))){
        var j = 0
        while (j < input.charAt(i-1) - '0'){
          buf.append(input.charAt(i))
          j += 1
        }
      }
    }
    buf.toString()
  }

  override def main(args: Array[String]): Unit = {
    val input = "abbbcccaad"
    println(encode(input))
    val input1 = "1a3b3c2a1d"
    println(decode(input1))
  }
}
