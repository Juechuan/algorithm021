package Week_03

//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 794 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 */
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Leet105 {
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    if (preorder == null || preorder.length == 0) return null
    val rootValue = preorder(0)
    val rootIndex = inorder.indexOf(rootValue)
    val root = new TreeNode(rootValue)
    root.left = buildTree(preorder.slice(1, rootIndex + 1), inorder.slice(0, rootIndex))
    root.right = buildTree(preorder.slice(rootIndex + 1, preorder.length), inorder.slice(rootIndex + 1, inorder.length))
    root
  }
}

//leetcode submit region end(Prohibit modification and deletion)
