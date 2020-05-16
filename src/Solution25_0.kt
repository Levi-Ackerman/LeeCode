class Solution25_0 {

    /**
     * k个一组翻转链表
     * 每k个元素翻转一次链表，最后不足k个则不翻转
     * 要求常数空间复杂度
     */
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if(k <= 1){
            return head
        }

        //空头结点
        val h = ListNode(0)
        h.next = head
        //p先走k，q是空头，p走完后，和q一起翻转链表，然后q往后走
        var p: ListNode? = head
        var q: ListNode = h
        while (true) {
            //p后挪k个元素，如果已经到尾部了直接返回
            for (i in 0 until k) {
                if (p == null) {
                    return h.next
                } else {
                    p = p.next
                }
            }

            //翻转时临时记住尾部位置
            var tempTail= q.next
            //翻转时临时记录头部位置
            var tempHead = q.next

            //现在q的后面是空的了，用来插翻转链表
            q.next = null
            //翻转链表，就是头插法，把k个元素插入链表
            for (i in 0 until k){
                val temp = tempHead.next
                tempHead.next = q.next
                q.next = tempHead
                tempHead = temp
            }
            q = tempTail
            q.next = p
        }
    }
}