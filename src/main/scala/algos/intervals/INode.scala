package algos.intervals

/**
  * Created by geek4you on 3/8/17.
  */
case class Interval(start: Int, end: Int) {
  override def toString: String = {
    s"[s:$start,e:$end]"
  }

  def doOVerlap(i2: Interval): Boolean = {
    if (this.start <= i2.end && i2.start <= this.end) true
    else
      false
  }
}

// Structure to represent a node in Interval Search Tree
case class INode(interval: Interval,
                 var max: Int,
                 var left: INode,
                 var right: INode) {
  def this(interval: Interval) = this(interval, interval.end, null, null)

  override def toString: String = {
    s"{ interval: $interval , max: $max }"
  }
}

object INode {
  def apply(interval: Interval) = new INode(interval)
}
