package Week_03

import scala.collection.mutable.ListBuffer

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法
// 👍 456 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Leet77 {
  def combine(n: Int, k: Int): List[List[Int]] = {
    val result = new ListBuffer[List[Int]]()
    val path = new ListBuffer[Int]
    combineWithResult(n,k,result,path,1)
    result.to(List)
  }
  def combineWithResult(n: Int, k: Int, result :ListBuffer[List[Int]],path: ListBuffer[Int],index:Int) :Unit = {
    if(n<k){
      return
    }
    if(k == 0){
      result.addOne(path.toList)
    }
    for(i <- index to n){
      val pathTemp = new ListBuffer[Int]().addAll(path)
      pathTemp.addOne(i)
      combineWithResult(n,k-1,result,pathTemp,i+1)
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)

