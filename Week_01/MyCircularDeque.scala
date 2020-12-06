package Week_01

//设计实现双端队列。
//你的实现需要支持以下操作：
//
//
// MyCircularDeque(k)：构造函数,双端队列的大小为k。
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
// isEmpty()：检查双端队列是否为空。
// isFull()：检查双端队列是否满了。
//
//
// 示例：
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
// 
//
//
//
// 提示：
//
//
// 所有值的范围为 [1, 1000]
// 操作次数的范围为 [1, 1000]
// 请不要使用内置的双端队列库。
//
// Related Topics 设计 队列
// 👍 65 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MyCircularDeque(_k: Int) {

  /** Initialize your data structure here. Set the size of the deque to be k. */
  val k: Int = _k
  var tmpList = List.empty[Int]

  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  def insertFront(value: Int): Boolean = {
    if (tmpList.length == k) false else {
      tmpList = tmpList :+ value
      true
    }
  }

  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  def insertLast(value: Int): Boolean = {
    if (tmpList.length == k) false else {
      tmpList ::= value
      true
    }
  }

  /** Deletes an item from the front of Deque. Return true if the operation is successful. */
  def deleteFront(): Boolean = {
    tmpList match {
      case Nil => false
      case _ => tmpList = tmpList dropRight 1
        true
    }
  }

  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  def deleteLast(): Boolean = {
    tmpList match {
      case Nil => false
      case h :: t => tmpList = t
        true
    }
  }

  /** Get the front item from the deque. */
  def getFront(): Int = {
    if (tmpList.nonEmpty) tmpList.last else -1
  }

  /** Get the last item from the deque. */
  def getRear(): Int = {
    tmpList.headOption.getOrElse(-1)
  }

  /** Checks whether the circular deque is empty or not. */
  def isEmpty(): Boolean = {
    tmpList.isEmpty
  }

  /** Checks whether the circular deque is full or not. */
  def isFull(): Boolean = {
     k == tmpList.length
  }

}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = new MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */
//leetcode submit region end(Prohibit modification and deletion)
