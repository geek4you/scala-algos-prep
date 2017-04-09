package algos.geeks4geeks.arrays

/**
  * Created by geek4you on 4/8/17.
  */

/**
  * Microsoft Interview
  *
  * Given two version strings, write a function to compare the version strings.
  *
  * if V1>V2 return +ve number
  * if V1<V2 return -ve number
  * if V1==v2 return 0
  *
  * eg: v1 = 10.8.8 , v2 = 8.1.1.1
  */
object CompareVersions {
  def compareVersion(version1: String, version2: String): Int = {
    val arr1 = version1.split("\\.")
    val arr2 = version2.split("\\.")
    var i = 0
    while (i < arr1.length || i < arr2.length) {
      if (i < arr1.length && i < arr2.length)
        if (arr1(i).toInt < arr2(i).toInt) return -1
        else if (arr1(i).toInt > arr2(i).toInt) return 1
        else if (i < arr1.length)
          if (arr1(i).toInt != 0) return 1
          else if (i < arr2.length) if (arr2(i).toInt != 0) return -1
      i += 1
    }
    0
  }
}
