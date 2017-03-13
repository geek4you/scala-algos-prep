package algos.epi.stacks

import java.util

/**
  * Created by geek4you  on 3/12/17.
  */
object NormalisePathNames {

  /**
    *
    */
  def normalisePathNames(path: String): String = {
    if (Option(path).isEmpty || path == "") {
      new IllegalArgumentException(" Path null or empty !!")
    }

    val pathNames = new util.LinkedList[String]()

    // Special case starts with /, which is an absolute path
    if (path.startsWith("/"))
      pathNames.addFirst("/")

    val delimiter = "/"
    val tokens = path.split(delimiter)

    tokens.foreach(token => {
      if (token == "..") {
        if (pathNames.isEmpty || pathNames.peekFirst().equals("..")) {
          pathNames.addFirst("..")
        } else {
          if (pathNames.peekFirst() == "/")
            throw new IllegalArgumentException(
              s"Path error !! Trying to go up root $path")
          pathNames.removeFirst()
        }
      } else if (token != "." && !token.isEmpty) { // must be a name
        pathNames.addFirst(token)
      }
    })

    val result = new StringBuilder()
    if (!pathNames.isEmpty) {
      val iterator = pathNames.descendingIterator()
      var prev = iterator.next()
      result.append(prev)
      while (iterator.hasNext) {
        if (prev != "/") {
          result.append("/")
        }
        prev = iterator.next()
        result.append(prev)
      }
    }
    result.toString()
  }

  def main(args: Array[String]): Unit = {
    val path = "/usr/lib/../var/../bin/gcc"
    println(normalisePathNames(path))
  }
}
