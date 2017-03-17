package algos.geeks4geeks.arrays

/**
  * Created by geek4you on 3/8/17.
  */
/**
  * [[http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/]]
  */
object UnionAndIntersectionsArrays extends App {

  def union(arr1: Array[Int], arr2: Array[Int]): Unit = {
    var (i, j) = (0, 0)
    while (i < arr1.length && j < arr2.length) {
      if (arr1(i) == arr2(j)) {
        print(s"${arr1(i)} ")
        i += 1
        j += 1
      } else if (arr1(i) > arr2(j)) {
        print(s"${arr1(i)} ")
        i += 1
      } else {
        print(s"${arr2(j)} ")
        j += 1
      }
    }

    while (i < arr1.length) {
      print(s"${arr1(i)} ")
      i += 1
    }

    while (j < arr2.length) {
      print(s"${arr2(j)} ")
      j += 1
    }
  }

  def intersection(arr1: Array[Int], arr2: Array[Int]): Unit = {
    var (i, j) = (0, 0)
    while (i < arr1.length && j < arr2.length) {
      if (arr1(i) == arr2(j)) {
        print(s"$arr1(i")
        i += 1
        j += 1
      } else if (arr1(i) > arr2(j)) {
        j += 1
      } else {
        i += 1
      }
    }
  }

  override def main(args: Array[String]) {}
}
