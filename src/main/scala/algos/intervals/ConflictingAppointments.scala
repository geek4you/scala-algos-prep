package algos.intervals

/**
  * Created by geek4you on 3/8/17.
  */
/**
  * @see : http://www.geeksforgeeks.org/given-n-appointments-find-conflicting-appointments/
  *       <p>
  *       Given n appointments, find all conflicting appointments
  *       <p>
  *       Input: appointments[] = { {1, 5} {3, 7}, {2, 6}, {10, 15}, {5, 6}, {4, 100}}
  *       Output: Following are conflicting intervals
  *       [3,7] Conflicts with [1,5]
  *       [2,6] Conflicts with [1,5]
  *       [5,6] Conflicts with [3,7]
  *       [4,100] Conflicts with [1,5]
  *       <p>
  *       An appointment is conflicting, if it conflicts with any of the previous appointments in array.
  *       <p>
  *       1) Create an Interval Tree, initially with the first appointment.
  *       2) Do following for all other appointments starting from the second one.
  *       a) Check if the current appointment conflicts with any of the existing
  *       appointments in Interval Tree.  If conflicts, then print the current
  * appointment.  This step can be done O(Logn) time.
  *       b) Insert the current appointment in Interval Tree. This step also can
  *       be done O(Logn) time.
  *
  *       Note that the above implementation uses simple Binary Search Tree insert operations.
  *       Therefore, time complexity of the above implementation is more than O(nLogn). We can use Red-Black Tree or AVL Tree
  *       balancing techniques to make the above implementation O(nLogn).
  */
class ConflictingAppointments {}
