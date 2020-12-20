package Week_03

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics 回溯算法
// 👍 545 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Leet47 {
  def permuteUnique(nums: Array[Int]): List[List[Int]] = {
    solver(List((List[Int](), nums.sorted.toList))) map (x => x._1)
  }

  @scala.annotation.tailrec
  def solver(l: List[(List[Int], List[Int])]): List[(List[Int], List[Int])] = {
    if (l forall (x => x._2 == Nil)) l
    else solver(l flatMap f)
  }

  def f(x: (List[Int], List[Int])): List[(List[Int], List[Int])] = x._2 match {
    case Nil => List(x)
    case _ => g(x._1)(Nil, x._2, Nil)
  }

  @scala.annotation.tailrec
  def g(x: List[Int])(xs1: List[Int], xs2: List[Int], acc: List[(List[Int], List[Int])]): List[(List[Int], List[Int])] = xs2 match {
    case Nil => acc.distinct
    case h :: t => g(x)(xs1 :+ h, t, (h :: x, xs1 ++ t) :: acc)
  }
}

//leetcode submit region end(Prohibit modification and deletion)
