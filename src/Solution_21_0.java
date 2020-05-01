
class Solution_21_0 {
    //合并两个有序链表，合并后的节点来自于两个链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head, tail;
        if (l1 == null && l2 == null) {
            return null;
        } else if (l2 == null) {
            head = tail = l1;
            l1 = l1.next;
        } else if (l1 == null) {
            head = tail = l2;
            l2 = l2.next;
        } else {
            if (l1.val > l2.val) {
                head = tail = l2;
                l2 = l2.next;
            } else {
                head = tail = l1;
                l1 = l1.next;
            }
        }

        while (true) {
            if (l1 == null && l2 == null) {
                break;
            } else if (l1 == null) {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            } else if (l2 == null) {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            } else {
                if (l1.val >= l2.val) {
                    tail.next = l2;
                    tail = tail.next;
                    l2 = l2.next;
                } else {
                    tail.next = l1;
                    tail = tail.next;
                    l1 = l1.next;
                }
            }
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}