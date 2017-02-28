package algos.geeks4geeks.trees

/**
 * Created by geek4you on 2/24/17.
 */

/**
 * Find next right node of a given key
Given a Binary tree and a key in the binary tree, find the node right to the given key. If there is no node on right side, then return NULL. Expected time complexity is O(n) where n is the number of nodes in the given binary tree.

For example, consider the following Binary Tree. Output for 2 is 6, output for 4 is 5. Output for 10, 6 and 5 is NULL.

                  10
               /      \
	      2         6
           /   \         \
	 8      4          5
We strongly recommend you to minimize the browser and try this yourself first.

Solution: The idea is to do level order traversal of given Binary Tree. When we find the given key, we just check if the next node in level order traversal is of same level, if yes, we return the next node, otherwise return NULL.
 */
object NextRightNodeOfGivenKey {

}
