package Week_03

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
// 👍 1044 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Leet46 {
  def permute(nums: Array[Int]): List[List[Int]] = {
    if (nums.length == 1) List(nums.toList)
    else if (nums.length == 2) List(nums.toList, nums.reverse.toList)
    else {
      (for {num <- nums.toList
            rest = nums.diff(Array(num))
            prev = permute(rest)
            res = prev.map(List(num) ++ _)
            } yield res).flatten
    }
  }
}

//leetcode submit region end(Prohibit modification and deletion)
