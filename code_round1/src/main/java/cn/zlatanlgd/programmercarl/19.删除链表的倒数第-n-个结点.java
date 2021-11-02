/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode del = slow.next;
        slow.next = del.next;
        return dummyHead.next;
    }

}
// @lc code=end
