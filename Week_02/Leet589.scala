package Week_02

//给定一个 N 叉树，返回其节点值的前序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其前序遍历: [1,3,5,6,2,4]。
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树
// 👍 121 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 * var value: Int = _value
 * var children: List[Node] = List()
 * }
 */

class Node(var _value: Int) {
  var value: Int = _value
  var children: List[Node] = List()
}

object Leet589 {
  def preorder(root: Node): List[Int] = {
    if (root == null) List()
    else root.value :: root.children.foldLeft[List[Int]](List())((x, y) => x ::: preorder(y))
  }
}

//leetcode submit region end(Prohibit modification and deletion)

