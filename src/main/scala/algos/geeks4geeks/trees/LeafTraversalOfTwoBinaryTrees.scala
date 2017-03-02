package algos.geeks4geeks.trees

/**
  * Created by geek4you on 3/1/17.
  */

/**
 * Check if leaf traversal of two Binary Trees is same?
Leaf traversal is sequence of leaves traversed from left to right. The problem is to check if leaf traversals of two given Binary Trees are same or not.

Expected time complexity O(n). Expected auxiliary space O(h1 + h2) where h1 and h2 are heights of two Binary Trees.

Examples:

Input: Roots of below Binary Trees
         1
	/ \
       2   3
      /   / \
     4   6   7

	 0
	/  \
       5    8
        \  / \
        4  6  7
Output: same
Leaf order traversal of both trees is 4 6 7

Input: Roots of below Binary Trees
         0
	/ \
       1   2
      / \
     8   9

	 1
	/ \
       4   3
        \ / \
        8 2  9

Output: Not Same
Leaf traversals of two trees are different.
For first, it is 8 9 2 and for second it is
8 2 9
We strongly recommend you to minimize your browser and try this yourself first.
A Simple Solution is traverse first tree and store leaves from left and right in an array. Then traverse other tree and store leaves in another array. Finally compare two arrays. If both arrays are same, then return true.

The above solution requires O(m+n) extra space where m and n are nodes in first and second tree respectively.

How to check with O(h1 + h2) space?
The idea is use iterative traversal. Traverse both trees simultaneously, look for a leaf node in both trees and compare the found leaves. All leaves must match.

Algorithm:

1. Create empty stacks stack1 and stack2
   for iterative traversals of tree1 and tree2

2. insert (root of tree1) in stack1
   insert (root of tree2) in stack2

3. Stores current leaf nodes of tree1 and tree2
temp1 = (root of tree1)
temp2 = (root of tree2)

4. Traverse both trees using stacks
while (stack1 and stack2 parent empty)
{
    // Means excess leaves in one tree
    if (if one of the stacks are empty)
	return false

   // get next leaf node in tree1
   temp1 = stack1.pop()
   while (temp1 is not leaf node)
   {
        push right child to stack1
	push left child to stack1
   }

   // get next leaf node in tree2
   temp2 = stack2.pop()
   while (temp2 is not leaf node)
   {
        push right child to stack2
	push left child to stack2
   }

   // If leaves do not match return false
   if (temp1 != temp2)
       return false
}

5. If all leaves matched, return true
 */

// todo : Revisit and solve
object LeafTraversalOfTwoBinaryTrees {}
