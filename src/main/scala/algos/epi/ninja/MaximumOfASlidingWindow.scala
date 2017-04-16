package algos.epi.ninja

import algos.epi.queues.QueueWithMax

import scala.collection.mutable.ArrayBuffer

/**
  * Created by geek4you on 4/15/17.
  */
/**
  * Page 459
  */
object MaximumOfASlidingWindow {

  def computeTrafficVolumes(trafficInfo: Array[TrafficElement],
                            windowSize: Int): ArrayBuffer[TrafficElement] = {
    val slidingWindow = new QueueWithMax[TrafficElement]()
    val maximumVolumes = new ArrayBuffer[TrafficElement]()
    trafficInfo.foreach(trafficElem => {
      slidingWindow.enqueue(trafficElem)
      while (trafficElem.time - slidingWindow.peek().time > windowSize) {
        slidingWindow.deQueue()
      }
      maximumVolumes += TrafficElement(trafficElem.time,
                                       slidingWindow.max().volume)
    })
    maximumVolumes
  }

  case class TrafficElement(time: Int, volume: Int)
      extends Ordered[TrafficElement] {
    override def compare(that: TrafficElement): Int = time.compare(that.time)
  }

}
