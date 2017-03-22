package algos.tries

/**
  * Created by geek4you on 3/21/17.
  */
object PrintUniqueRowsInMatrix {

  def printUniqueRows(matrix: Array[Array[Int]]): Unit = {
    val trie = new Trie()

    matrix.foreach(row => {
      if (!trie.search(row)) {
        println(row.mkString(", "))
        trie.insert(row)
      }
    })
  }

  def main(args: Array[String]): Unit = {
    val arr1 = Array(0, 1, 0, 0, 1)
    val arr2 = Array(1, 0, 1, 1, 0)
    val arr3 = Array(0, 1, 0, 0, 1)
    val arr4 = Array(1, 1, 1, 0, 0)
    val matrix = Array(arr1, arr2, arr3, arr4)
    printUniqueRows(matrix)
  }
}
