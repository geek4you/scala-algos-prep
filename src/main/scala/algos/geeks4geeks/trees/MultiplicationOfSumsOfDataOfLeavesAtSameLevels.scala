package algos.geeks4geeks.trees

/**
  * Created by geeks4you on 3/1/17.
  */
/**
  * Given a Binary Tree, return following value for it.
1) For every level, compute sum of all leaves if there are leaves at this level. Otherwise ignore it.
2) Return multiplication of all sums.

Examples:

Input: Root of below tree
         2
       /   \
      7     5
             \
              9
Output: 63
First levels doesn't have leaves. Second level
has one leaf 7 and third level also has one
leaf 9.  Therefore result is 7*9 = 63


Input: Root of below tree
         2
       /   \
     7      5
    / \      \
   8   6      9
      / \    /  \
     1  11  4    10

Output: 208
First two levels don't have leaves. Third
level has single leaf 8. Last level has four
leaves 1, 11, 4 and 10. Therefore result is
8 * (1 + 11 + 4 + 10)
We strongly recommend you to minimize your browser and try this yourself first.

One Simple Solution is to recursively compute leaf sum for all level starting from top to bottom. Then multiply sums of levels which have leaves. Time complexity of this solution would be O(n2).

An Efficient Solution is to use Queue based level order traversal. While doing the traversal, process all different levels separately. For every processed level, check if it has a leaves. If it has then compute sum of leaf nodes. Finally return product of all sums.
  */
object MultiplicationOfSumsOfDataOfLeavesAtSameLevels {


}
