package datastructures

/**
  * Created by geek4you on 3/20/17.
  */
object BitMap {
  final val Bytes = Array(128, 64, 32, 16, 8, 4, 2, 1)

  def apply(bytes: Seq[Byte]): BitMap = new BitMap(bytes: _*)

}

/**
  *
  * Implements a bit map where you can check which bits are set and which are not.
  *
  * @param bytes
  */
class BitMap(bytes: Byte*) extends IndexedSeq[(Int, Boolean)] {

  val length = bytes.length * 8

  /**
    *
    * Returns true if the bit at the given index is set, false if it is not.
    *
    * @param index the bit position, starts at 0
    * @return
    */
  def isSet(index: Int): Boolean = {
    val quotient = index / 8
    val remainder = index % 8

    (bytes(quotient) & BitMap.Bytes(remainder)) != 0
  }

  override def foreach[U](f: ((Int, Boolean)) => U) {
    var currentIndex = 0
    for (byte <- bytes) {
      var x = 0
      while (x < BitMap.Bytes.length) {
        f(currentIndex, (byte & BitMap.Bytes(x)) != 0)
        x += 1
        currentIndex += 1
      }
    }
  }

  def apply(idx: Int): (Int, Boolean) = (idx, this.isSet(idx))

  override def toString: String =
    this.map(entry => if (entry._2) '1' else '0').mkString("")
}
