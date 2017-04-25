package algos.epi.graph

import scala.collection.mutable

/**
  * Created by geek4you on 4/9/17.
  */
/**
  * Page 357
  */
class OutcomesOfMatches {

  case class MatchResult(winningTeam: String, losingTeam: String)

  def canTeamABeatTeamB(matches: Array[MatchResult],
                        teamA: String,
                        teamB: String): Boolean = {
    val visited = new mutable.HashSet[String]()
    isReachableDFS(buildGraph(matches), teamA, teamB, visited)
  }

  def buildGraph(matches: Array[MatchResult])
    : mutable.Map[String, mutable.HashSet[String]] = {
    val graph = mutable.Map[String, mutable.HashSet[String]]()
    matches.foreach(play => {
      val edgesOption = graph.get(play.winningTeam)
      if (Option(edgesOption).isEmpty) {
        val edges = new mutable.HashSet[String]()
        graph += (play.winningTeam -> edges)
      }
      graph(play.winningTeam) += play.losingTeam
    })
    graph
  }

  def isReachableDFS(graph: mutable.Map[String, mutable.HashSet[String]],
                     curr: String,
                     dest: String,
                     visited: mutable.HashSet[String]): Boolean = {
    if (curr == dest)
      true
    else if (visited.contains(curr) || graph.get(curr).isEmpty) {
      false
    } else {
      visited += curr
      graph(curr).foreach(
        team =>
          if (isReachableDFS(graph, team, dest, visited))
            return true)
      false
    }
  }
}
