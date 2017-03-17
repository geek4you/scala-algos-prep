package datastructures.graph

class Graph {
  val nodeLookUp = scala.collection.mutable.Map[Int, Node]()

  /**
    * Adds a new node to the graph
    */
  def addNode(id: Int): Unit = {
    val node = Node(id)
    nodeLookUp += (id -> node)
  }

  /**
    * get the node from the node id
    */
  def getNode(id: Int): Node = {
    nodeLookUp(id)
  }

  /**
    * adds the edge from the src node to dst
    */
  def addEdge(src: Int, dest: Int): Unit = {
    val srcNode = nodeLookUp(src)
    val destNode = nodeLookUp(dest)
    srcNode.adjacent.add(destNode)
  }

  /**
    * remvoes the edge from src to dest
    */
  def removeEdge(src: Int, dest: Int): Boolean = {
    val srcNode = nodeLookUp(src)
    val destNode = nodeLookUp(dest)
    srcNode.adjacent.remove(destNode)
  }

  /**
    * Number of vertices in the graph
    */
  def numVertices(): Int = {
    nodeLookUp.size
  }

  /**
    * Returns a copy of the Linked List of outward edges from a vertex
    */
  def getEdgesFromVertex(id: Int): java.util.LinkedList[Node] = {
    nodeLookUp(id).adjacent
  }

  /**
    * Prints the adjacency list
    */
  def printAdjacencyList(): Unit = {
    val iter = nodeLookUp.iterator
    while (iter.hasNext) {
      val entry = iter.next
      println(entry._2)
    }
  }

  /**
    * DFS check for path between src and dst
    */
  def hasPathDFS(src: Int, dest: Int): Boolean = {
    val srcNode = getNode(src)
    val destNode = getNode(dest)
    val visited = new java.util.HashSet[Int]()
    hasPathDfsUtil(srcNode, destNode, visited)
  }

  private def hasPathDfsUtil(src: Node,
                             dest: Node,
                             visited: java.util.HashSet[Int]): Boolean = {
    if (visited.contains(src.id)) return false
    visited.add(src.id)
    if (src == dest) return true

    val iter = src.adjacent.iterator

    while (iter.hasNext) {
      if (hasPathDfsUtil(iter.next, dest, visited)) {
        return true
      }
    }
    false
  }

  private def hasPathBFSUtil(src: Node, dest: Node): Boolean = {
    val queue = new java.util.LinkedList[Node]()
    val visited = new java.util.HashSet[Int]()
    queue.add(src)
    while (!queue.isEmpty) {
      val node = queue.removeFirst()
      if (node == dest)
        return true
      if (!visited.contains(node.id)) { // only process if this node is not already visited
        visited.add(node.id)
        val iter = node.adjacent.iterator
        while (iter.hasNext) {
          queue.add(iter.next)
        }
      }
    }
    false
  }

  /**
    * BFS check for path between src and dst
    */
  def hasPathBFS(src: Int, dest: Int): Boolean = {
    val srcNode = nodeLookUp(src)
    val destNode = nodeLookUp(dest)
    hasPathBFSUtil(srcNode, destNode)
  }
}

case class Node(id: Int, adjacent: java.util.LinkedList[Node]) {
  def this(id: Int) = this(id, new java.util.LinkedList[Node]())
}

object Node {
  def apply(id: Int) = new Node(id)
}
