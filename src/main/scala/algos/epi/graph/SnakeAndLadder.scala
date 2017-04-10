package algos.epi.graph

import scala.collection.mutable.ListBuffer

/**
  * Created by geek4you on 4/9/17.
  */
/**
  * @see http://www.geeksforgeeks.org/snake-ladder-problem-2/
  */
object SnakeAndLadder {

  /**
    * This function returns minimum number of dice throws required to
    * Reach last cell from 0'th cell in a snake and ladder game.
    * moves[] is an array of size N where N is no. of cells on board
    * If there is no snake or ladder from cell i, then move[i] is -1
    * Otherwise move[i] contains cell to which snake or ladder at i
    * takes to.
    */
  def getMinDiceThrows(moves: Array[Int]): Int = {
    // The graph has N vertices. Mark all the vertices as
    // not visited
    val visited = new Array[Boolean](moves.length)

    // create a queue for BFS
    val queue = new ListBuffer[QueueEntry]()

    // Mark the node 0 as visited and enqueue it.
    visited(0) = true
    queue += QueueEntry(0, 0) // // distance of 0't vertex is also 0

    var queueEntry = queue.head
    // Do a BFS starting from vertex at index 0
    var done = false
    while (queue.nonEmpty && !done) {
      queueEntry = queue.head
      val vertex = queueEntry.vertexId // vertex no. of queue entry

      // If front vertex is the destination vertex,
      // we are done
      if (vertex == moves.length - 1)
        done = true
      else {
        // Otherwise dequeue the front vertex and enqueue
        // its adjacent vertices (or cell numbers reachable
        // through a dice throw)
        queue.remove(0)
        var j = vertex + 1
        while (j <= (vertex + 6) && j <= moves.size - 1) {
          // If this cell is already visited, then ignore
          if (!visited(j)) {
            // Otherwise calculate its distance and mark it
            // as visited
            // Check if there a snake or ladder at 'j'
            // then tail of snake or top of ladder
            // become the adjacent of 'i'
            visited(j) = true
            val vertexId = if (moves(j) != -1) moves(j) else j
            queue += QueueEntry(vertexId, queueEntry.distance + 1)
          }
          j += 1
        }
      }
    }
    queueEntry.distance
  }

  def main(args: Array[String]): Unit = {

    // construct snake and ladder board
    val moves = Array.fill(30)(-1)

    // ladders
    moves(2) = 21
    moves(4) = 7
    moves(10) = 25
    moves(19) = 28

    // snakes
    moves(26) = 0
    moves(20) = 8
    moves(16) = 3
    moves(18) = 6

    println(s"Min Dice throws required is : ${getMinDiceThrows(moves)}")
  }

  /**
    * vertexId and Distance of this vertex from source
    */
  case class QueueEntry(vertexId: Int, distance: Int)
}
