package algos.sorting

/**
  * Scala Style Merge sort
  * http://dublintech.blogspot.com/2013/05/how-could-scala-do-merge-sort.html
  * http://eddmann.com/posts/merge-sort-in-scala-using-tail-recursion-and-streams/
  */
object MergeSortScalaStyle extends App {
  // It is the same divide and conquer idea.

  //A small example-driven inclusion that I have also made is in the use of an implicit method to provide the less-than predicate. Implictis are an extremely powerful feature that deserves its own post, simply put however, the compiler is able to ‘implicitly’ deduce that I wish to use this comparator method based on its type signature (Int, Int => Boolean).

  implicit def IntIntLessThan(x: Int, y: Int) = x < y

  def mergeSort[T](xs: List[T])(implicit pred: (T, T) => Boolean): List[T] = {
    val m = xs.length / 2
    if (m == 0) xs
    else {
      @scala.annotation.tailrec
      def merge(ls: List[T], rs: List[T], acc: List[T] = List()): List[T] =
        (ls, rs) match {
          case (Nil, _) => acc ++ rs
          case (_, Nil) => acc ++ ls
          case (l :: ls1, r :: rs1) =>
            if (pred(l, r)) merge(ls1, rs, acc :+ l)
            else merge(ls, rs1, acc :+ r)
        }
      val (l, r) = xs splitAt m
      merge(mergeSort(l), mergeSort(r))
    }
  }
  override def main(args: Array[String]): Unit = {
    val arry = List(20, 16, 3, 5, 1, 12, 2, 1)
    mergeSort(arry)
    print(arry)
  }
}
