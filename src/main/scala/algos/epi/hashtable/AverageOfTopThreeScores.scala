package algos.epi.hashtable

import scala.collection.mutable

/**
  * Created by geek4you on 4/23/17.
  */
object AverageOfTopThreeScores {

  def findStudentWithHighestBestOfThreeScores(
      nameScores: Iterator[NameScore]): String = {
    val studentScores = mutable.Map[String, mutable.PriorityQueue[Int]]()

    while (nameScores.hasNext) {
      val curNameScore = nameScores.next()
      val opScores = studentScores.get(curNameScore.name)
      if (opScores.isEmpty) {
        val scores = new mutable.PriorityQueue[Int]()(MinOrder)
        studentScores += (curNameScore.name -> scores)
      }
      val scores = studentScores(curNameScore.name)
      scores += curNameScore.score
      if (scores.size > 3) // only keep top three scores.
        scores.dequeue()
    }

    var topStudent = "no such student"
    var currentTopThreeScoresSumm = 0
    studentScores.foreach(entry => {
      if (entry._2.size > 2) {
        val currScores = entry._2
        var sum = 0
        while (currScores.nonEmpty) {
          sum += currScores.dequeue()
        }
        if (currentTopThreeScoresSumm < sum) {
          topStudent = entry._1
          currentTopThreeScoresSumm = sum
        }
      }
    })
    topStudent
  }

  case class NameScore(name: String, score: Int)
  object MinOrder extends Ordering[Int] {
    override def compare(x: Int, y: Int): Int = y compare x
  }
}
