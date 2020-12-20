package Week_03

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
//
//
//
//
//
// 示例 1:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//
//
// 示例 2:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//
//
//
//
// 说明:
//
//
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉树中。
//
// Related Topics 树
// 👍 870 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 */
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}


object Leet236 {
  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    trait Result
    case class Found(ancestor: TreeNode) extends Result
    case class AtLarge(missing: Set[TreeNode]) extends Result
    def getState(o: TreeNode, target: Set[TreeNode]): Result = {
      if (o == null) AtLarge(target)
      else {
        val tNew = target - o
        if (tNew.isEmpty) {
          Found(o)
        }
        else getState(o.left, tNew) match {
          case Found(x) if target.contains(o) => Found(o)
          case Found(x) => Found(x)
          case AtLarge(t1) =>
            getState(o.right, t1) match {
              case Found(x) if target == t1 => Found(x)
              case Found(x) => Found(o)
              case AtLarge(t2) => AtLarge(t2)
            }
        }
      }
    }

    getState(root, Set(p, q)) match {
      case Found(o) => o
      case _ => root
    }
  }
}

//leetcode submit region end(Prohibit modification and deletion)

