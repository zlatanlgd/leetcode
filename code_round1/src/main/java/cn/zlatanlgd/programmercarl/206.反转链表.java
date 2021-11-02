import org.w3c.dom.NodeList;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 迭代
        /*
         * if (head == null) { return head; } ListNode prev = null; ListNode cur = head;
         * ListNode temp = null; while (cur != null) { temp = cur.next; cur.next = prev;
         * prev = cur; cur = temp; } return prev;
         */

        // 递归
        return reverse(null, head);
    }

    public ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null)
            return prev;
        ListNode temp = null;
        temp = cur.next;
        cur.next = prev;
        prev = cur;
        cur = temp;
        return reverse(prev, cur);
    }
}
// @lc code=end
