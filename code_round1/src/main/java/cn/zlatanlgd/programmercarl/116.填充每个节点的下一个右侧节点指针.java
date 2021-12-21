import java.util.Deque;
import java.util.List;

import javax.xml.soap.Node;

/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Deque<Node> que = new LinkedList<>();
        if (root == null) {
            return root;
        }
        que.addLast(root);
        while (!que.isEmpty()) {
            int len = que.size();
            while (len > 0) {
                Node cur = que.pollFirst();
                if (cur.left != null) {
                    que.addLast(cur.left);
                }
                if (cur.right != null) {
                    que.addLast(cur.right);
                }
                len--;
                if (len == 0) {
                    cur.next = null;
                } else {
                    cur.next = que.peekFirst();
                }
            }
        }
        return root;
    }
}
// @lc code=end
