package algos.programmingpearls

import java.io.{BufferedWriter, File, FileWriter}

import scala.collection.mutable
import scala.io.Source

/**
  * Created by geek4you on 2/18/17.
  */

/**
  * Programming Pearls 2nd edition
  * Page : 2 Problem: 1.2
  *
  * 1) Disk MergeSort or ExternalSort
  * 2) Bit Vector / Bit Map
  *
  *  BitVector is efficient
  *  Time : O(n)
  *
  * This solution takes advantage of three things which are not usually found in Sorting.
  * 1) Input is relatively small range.
  * 2) It contains no duplicates.
  * 3) No data is associated with each record beyond the single integer.
  */
object DiskSortWithMemoryConstraint extends App {

  def sort(inputFile: String, outputFile: String): Unit = {
    // initialize the bit set / bit vector
    // @FIXME bitset doesn't act as bitvector/bitmap :(. Try to implement bitvector
    val bitSet = new mutable.BitSet(10000000)

    // insert elements into the bitset
    for (line <- Source.fromFile(inputFile).getLines()) {
      bitSet(line.toInt)
    }

    // write sorted output
    for (i <- 0 until 10000000) {
      if (bitSet.contains(i)) {
        val bw = new BufferedWriter(new FileWriter(new File(outputFile)))
        bw.write(i)
        bw.close()
      }
    }
  }

  override def main(args: Array[String]): Unit = {
    val bitSet = new mutable.BitSet()
    bitSet.add(1)
    bitSet.add(2)
    bitSet.add(5)
    println(bitSet.mkString(" "))
  }

}
