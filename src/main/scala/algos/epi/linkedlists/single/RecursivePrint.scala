package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/11/17.
  */

object RecursivePrint {

  def recursivePrint[A](head: ListNode[A]): Unit = {
    if(Option(head).isDefined){
      print(s"${head.data} ")
      recursivePrint(head.next)
    }
  }

  def recursiveReversePrint[A](head: ListNode[A]): Unit = {
    if(Option(head).isDefined){
      recursivePrint(head.next)
      print(s"${head.data} ")
    }
  }


}
