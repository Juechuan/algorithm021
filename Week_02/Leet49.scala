package Week_02

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串
// 👍 539 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Leet49 {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    strs.map(x => (x.sorted, x)).groupBy(_._1).map(y => y._2.map(_._2).toList).toList
  }
}

//leetcode submit region end(Prohibit modification and deletion)

