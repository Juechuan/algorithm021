学习笔记
1. clarification  
2. possible solution --> optimal (time & space)
3. code
4. test case

### HashMap

#### Put
调用Put方法：


比如调用 hashMap.put("key", value) ，插入一个Key为“key"的元素。

这时候我们需要利用一个哈希函数来确定Entry的插入位置（index）：


index = HashFunc（“key”）
求的值存放在Entry下
HashMap每一个元素是一个Entry对象，也是一个链表的头节点。每一个Entry对象通过Next指针指向它的下一个Entry节点。当新来的Entry映射到冲突的数组位置时，只需要插入到对应的链表。

####Get

把输入的Key做一次Hash计算，得到对应的index：

index = Hash（“apple”）

由于刚才所说的Hash冲突，同一个位置有可能匹配到多个Entry，这时候就需要顺着对应链表的头节点，一个一个向下来查找。

拓展

Entry下存取链表，Hash计算的方式关系到存取的元素均匀分布的问题

位运算：（Length为HashMap的长度）

index = HashCode（Key） & （Length - 1） 
