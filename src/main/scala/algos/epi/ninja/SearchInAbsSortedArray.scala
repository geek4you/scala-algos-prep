package algos.epi.ninja

/**
  * Created by geek4you on 4/16/17.
  */
/**
  * Say we have an array

a[] ={1,2,-3,3,-3,-3,4,-4,5}
And find the position of 3 (which would be 3)

There are be no multiple indexes for an answer.

It must be efficient, and NOT linear.

I was thinking of doing a Binary Search of the array, but instead of comparing the raw values,
I wanted to compare the absolute values; abs(a[i]) and abs(n) [n is the input number].
Then if the values are equal, I do another comparison, now with the raw values a[i] and n.

But I run into a problem where, if I am in the above situation with the
same array {1,2,-3,3,-3,-3,4,-4,5}, and am looking for 3, there are multiple -3 that get in
the way (thus, I would have to check if the raw values a[i] and n does not work, I have to
check a[i+1] and a[i-1].)

Ok im just rambling now. Am i thinking too hard for this?

  */
/**
  * I would:

  - use a tweaked binary search algorithm to find the index of the left-most element that matches
  - iterate through the indexes until you find the element are looking for, or an element whose absolute value no longer matches.

That should be O(logN) for the first step. The second step is O(1) on average if you assume that the element values are evenly distributed.
(The worst case for the second step is O(N); e.g. when the elements all have the same absolute value, and the one you want is the last in the array.)
  */
class SearchInAbsSortedArray {}
