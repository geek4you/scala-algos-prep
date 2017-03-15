package algos.epi.searching

import java.util
import java.util.{Collections, Comparator}

/**
  * Created by geek4you on 3/14/17.
  */
/**
  * Page 191
  *
  * Collections Binary search usage !!
  */
object SearchStudent {

  def searchStudent(students: util.List[Student],
                    target: Student,
                    compareGPA: Comparator[Student]): Int = {
    Collections.binarySearch(students, target, comparator)
  }

  val comparator = new Comparator[Student]() {
    override def compare(o1: Student, o2: Student) = {
      if (o1.gradePointAverage != o2.gradePointAverage) {
        o1.gradePointAverage compare o2.gradePointAverage
      } else {
        o1.name compare o2.name
      }
    }
  }
}

case class Student(name: String, gradePointAverage: Double)
