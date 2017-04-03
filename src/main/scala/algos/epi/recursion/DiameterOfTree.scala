package algos.epi.recursion

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 4/1/17.
  */
object DiameterOfTree {

  def computeDiameter(t: TreeNode): Double = {
    if (Option(t).isDefined)
      computeHeightAndDiameter(t).diameter
    else
      0.0
  }

  def computeHeightAndDiameter(t: TreeNode): HeightAndDiameter = {
    var diameter = Double.MinValue
    var heights = Array(0.0, 0.0) // stores the max two heights
    t.edges.foreach(edge => {
      val heightAndDiameter = computeHeightAndDiameter(edge.root)
      if (heightAndDiameter.height + edge.length > heights(0)) {
        heights(1) = heights(0)
        heights(0) = heightAndDiameter.height + edge.length
      } else if (heightAndDiameter.height + edge.length > heights(1)) {
        heights(1) = heightAndDiameter.height + edge.length
      }
      diameter = Math.max(diameter, heightAndDiameter.diameter)
    })

    HeightAndDiameter(heights(0), Math.max(diameter, heights(0) + heights(1)))
  }

  def main(args: Array[String]): Unit = {
    assert(computeDiameter(null) == 0)

    val t = TreeNode()
    t.edges += Edge(TreeNode(), 10.0)
    t.edges(0).root.edges += Edge(TreeNode(), 50.0)
    t.edges += Edge(TreeNode(), 20.0)
    assert(80 == computeDiameter(t))
  }
}

case class HeightAndDiameter(height: Double, diameter: Double)
case class TreeNode(edges: ArrayBuffer[Edge]) {
  def this() = this(new ArrayBuffer[Edge]())
}
object TreeNode {
  def apply() = new TreeNode()
}
case class Edge(root: TreeNode, length: Double)
