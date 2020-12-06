package Week_00

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 300 👎 0


object Leet129 {

  def isPalindrome(s: String): Boolean = {
    // main logic
    // 1. filter out number & char
    val filteredS: String = filterNonNumberAndChar(s)

    // 2. reverse and compare
    val reversedS: String = reverseString(filteredS)

    reversedS.equalsIgnoreCase(filteredS)

  }

  def reverseString(filteredS: String): String = {
    filteredS.reverse
  }

  def filterNonNumberAndChar(s: String): String = {
    s.replaceAll("[^a-zA-Z0-9]", "")
  }


}
