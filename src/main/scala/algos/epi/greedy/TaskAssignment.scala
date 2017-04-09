package algos.epi.greedy

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 4/7/17.
  */
/**
  * Page 339
  */
object TaskAssignment {

  def optimumTaskAssignment(taskDurations: Array[Int]): Seq[PairedTasks] = {
    val sortedTaskDurations = taskDurations.sortBy(x => x)
    val optimumAssignments = new ArrayBuffer[PairedTasks]()
    var (i, j) = (0, sortedTaskDurations.length - 1)
    while (i < j) {
      optimumAssignments += PairedTasks(sortedTaskDurations(i),
                                        sortedTaskDurations(j))
      i += 1
      j -= 1
    }
    optimumAssignments
  }

  def main(args: Array[String]): Unit = {
    val taskDurations = Array(5, 2, 1, 6, 4, 4)
    println(optimumTaskAssignment(taskDurations).mkString("\n"))
  }
  case class PairedTasks(task1: Int, task2: Int)
}
