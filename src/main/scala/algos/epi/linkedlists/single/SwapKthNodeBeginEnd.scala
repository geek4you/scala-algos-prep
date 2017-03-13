package algos.epi.linkedlists.single

/**
  * Created by geek4you on 3/12/17.
  */
/**
  *
  * link : http://www.geeksforgeeks.org/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/
  * Swap Kth node from beginning with Kth node from end in a Linked List
  * Given a singly linked list, swap kth node from beginning with kth node from end. Swapping of data is not allowed, only pointers should be changed. This requirement may be logical in many situations where the linked list data part is huge (For example student details line Name, RollNo, Address, ..etc). The pointers are always fixed (4 bytes for most of the compilers).
  * *
  * Linked List
  * 1 -> 2 -> 3 -> 4 -> 5 -> 6 ->7 -> 8
  * For k =3 , the above list should be changed to following (6 and  3 are swapped)
  * 1 -> 2 -> 6 -> 4 -> 5 -> 3 ->7 -> 8
  * *
  * The problem seems simple at first look, but it has many interesting cases.
  * *
  * Let X be the kth node from beginning and Y be the kth node from end. Following are the interesting cases that must be handled.
  * 1) Y is next to X
  * 2) X is next to Y
  * 3) X and Y are same
  * 4) X and Y don’t exist (k is more than number of nodes in linked list)
  * *
  * We strongly recommend you to try it yourself first, then see the below solution. It will be a good exercise of pointers.
  */
object SwapKthNodeBeginEnd {}
