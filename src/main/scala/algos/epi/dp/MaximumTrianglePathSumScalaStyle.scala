package algos.epi.dp

/**
  * Created by geek4you on 3/21/17.
  */
/**
  * @see [[https://rosettacode.org/wiki/Maximum_triangle_path_sum#Scala]]
  * twitter interview question
  */
object MaximumTrianglePathSumScalaStyle {

  // Solution:
  def sum(triangle: Array[Array[Int]]) =
    triangle
      .reduceRight((upper, lower) =>
        upper zip (lower zip lower.tail)
          map { case (above, (left, right)) => above + Math.max(left, right) })
      .head

  def triangle = """
                          55
                        94 48
                       95 30 96
                     77 71 26 67
    """

  def parse(s: String) = s.trim.split("\\s+").map(_.toInt)

  def parseLines(s: String) = s.trim.split("\n").map(parse)

  def main(args: Array[String]): Unit = {
    println(sum(parseLines(triangle)))
  }
}
