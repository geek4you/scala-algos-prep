package algos.epi.arrays

import java.util
import java.util.Collections

/**
  * Created by geek4you on 3/4/17.
  */
object DutchNationalFlagWith4Colors {

  def dutchNationalFlagWith4Colors(arr: util.List[Char]): Unit = {
    // i represents the next position of 'a' element to be placed .
    // Similiarly j , k and l represent the positions of b , c and d respectively.
    var (i, j, k, l) = (0, 0, 0, arr.size() - 1)

    // These while loops place i,j,k and l to their correct positions
    while (arr.get(i) == 'a') {
      i += 1
      j = i
      k = i
    }

    while (arr.get(j) == 'b') {
      j += 1
      k = j
    }

    while (arr.get(k) == 'c') {
      k += 1
    }

    while (arr.get(l) == 'd') {
      l -= 1
    }

    // Loops till k is less than l
    while (k <= l) {
      if (arr.get(k) == 'a') {
        // Swap with arr(i) if a is found
        Collections.swap(arr, i, k)

      } else if (arr.get(k) == 'b') {
        // Swap with arr(j) if b is found
        Collections.swap(arr, j, k)
      } else if (arr.get(k) == 'd') {
        Collections.swap(arr, k, l)
      }

      // Again These while loops place i,j,k and l to their corect positions
      while (arr.get(i) == 'a') {
        i += 1
        j = i
        k = i
      }

      while (arr.get(j) == 'b') {
        j += 1
        k = j
      }

      while (arr.get(k) == 'c') {
        k += 1
      }

      while (arr.get(l) == 'd') {
        l -= 1
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = Array[Char]('a', 'b', 'c', 'd', 'a', 'd', 'a', 'b', 'c', 'd',
      'd', 'd', 'd', 'd', 'a', 'a', 'a', 'a', 'c', 'c', 'a', 'a', 'b', 'b',
      'a', 'b', 'b', 'a', 'a')
    import scala.collection.JavaConverters._
    val list = new util.ArrayList(arr.toList.asJava)
    dutchNationalFlagWith4Colors(list)
    list.forEach(x => println(x))
  }
}
