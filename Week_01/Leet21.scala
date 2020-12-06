package Week_01

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表
// 👍 1421 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 * var next: ListNode = _next
 * var x: Int = _x
 * }
 */

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Leet21 {
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    if (l1 == null)  l2
    if (l2 == null)  l1
    val newHead = new ListNode(-1)
    var newTail = newHead
    var head1 = l1
    var head2 = l2
    while (head1 != null && head2 != null) {
      if (head1.x < head2.x) {
        newTail.next = head1
        newTail = newTail.next
        head1 = head1.next
      } else {
        newTail.next = head2
        newTail = newTail.next
        head2 = head2.next
      }
    }
    if (head1 == null)
      newTail.next = head2
    else {
      newTail.next = head1
    }
    newHead.next
  }
}


//leetcode submit region end(Prohibit modification and deletion)
