package algos.epi.arrays

/**
  * Created by geek4you on 3/4/17.
  */
/**
  * page - 69s
  * T(n) = O(n)
  * Space = O(1)
  */
object RemoveDuplicatesFromSortedArray {

  def removeDuplicates(arr: Array[Int]): Unit = {
    var writeIndex = 1
    for(i <- 1 until arr.length){
      if(arr(writeIndex-1) != arr(i)){
        arr(writeIndex) = arr(i)
        writeIndex += 1
      }
    }
  }

  def main(args: Array[String]): Unit = {
    var arr = Array[Int](2, 3, 5, 5, 7, 11, 11, 11, 13)
    println(arr.mkString(" "))
    removeDuplicates(arr)
    println(arr.mkString(" "))
  }

}
