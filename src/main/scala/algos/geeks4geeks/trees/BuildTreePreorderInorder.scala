package algos.geeks4geeks.trees

/**
  * Created by geek4you on 2/22/17.
  */
/**
  *
  * [[http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/]]
  *
  * Construct Tree from given Inorder and Preorder traversals
  * Let us consider the below traversals:
  *
  * Inorder sequence: D B E A F C
  * Preorder sequence: A B D E C F
  *
  * In a Preorder sequence, leftmost element is the root of the tree. So we know ‘A’ is root for given
  * sequences. By searching ‘A’ in Inorder sequence, we can find out all elements on left side of ‘A’
  * are in left subtree and elements on right are in right subtree. So we know below structure now.
  *
  *              A
               /   \
             /       \
           D B E     F C
  *
  * We recursively follow above steps and get the following tree.
  *
  *
  *         A
          /   \
        /       \
       B         C
      / \        /
    /     \    /
    D       E  F

  * Algorithm: buildTree()
  * 1) Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code)
  * to pick next element in next recursive call.
  * 2) Create a new tree node tNode with the data as picked element.
  * 3) Find the picked element’s index in Inorder. Let the index be inIndex.
  * 4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
  * 5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
  * 6) return tNode.
  *
  */
object BuildTreePreorderInorder {

  /**
    * Recursive function to construct binary of size len from
    * Inorder traversal in[] and Preorder traversal pre[].
    * Initial values of inStrt and inEnd should be 0 and len -1.
    * The function doesn't do any error checking for cases where inorder and preorder
    * do not form a tree
    *
    * If you use search method T(n) = O(n2)
    * If you use hashmap to store elem -> index T(n) = O(n)
    */
  // preIndex global or static across recursive calls
  var preIndex = 0
  var elemToIndexMap: Map[Char, Int] = _

  // todo: REVISIT
  def buildTree(inorder: Array[Char],
                preOrder: Array[Char],
                inStart: Int,
                inEnd: Int): Node[Char] = {
    if (inStart > inEnd)
      null
    else {
      // get hashmap
      if (Option(elemToIndexMap).isEmpty) {
        elemToIndexMap = elemToIndexMap(inorder)
      }
      //Pick current node from Preorder traversal using preIndex and increment preIndex
      val node = Node(preOrder(preIndex))
      preIndex += 1

      //If this node has no children then return
      if (inStart == inEnd)
        node
      else {
        //Else find the index of this node in Inorder traversal
        val inIndex = elemToIndexMap(node.data)

        //Using index in Inorder traversal, construct left and right subtress
        node.left = buildTree(inorder, preOrder, inStart, inIndex - 1)
        node.right = buildTree(inorder, preOrder, inIndex + 1, inEnd)

        node
      }

    }
  }

  // utility functions

  /**
    * Function to find index of value in arr[start...end]
    * The function assumes that value is present in in[]
    */
  def searchIndexInArray(arr: Array[Char],
                         key: Char,
                         start: Int,
                         end: Int): Int = {
    var index = start
    var done = false
    while (index < end && !done) {
      if (arr(index) == key)
        done = true
      else
        index += 1
    }
    index
  }

  /**
    * function to return the element -> index map
    */
  def elemToIndexMap(arr: Array[Char]): Map[Char, Int] = {
    Map(arr.zipWithIndex: _*)
  }

  def main(args: Array[String]): Unit = {
    val in = Array('D', 'B', 'E', 'A', 'F', 'C')
    val pre = Array('A', 'B', 'D', 'E', 'C', 'F')
    val root = buildTree(in, pre, 0, in.length - 1)
    LevelOrderTraversal.lvlOrder(root)
  }

}
