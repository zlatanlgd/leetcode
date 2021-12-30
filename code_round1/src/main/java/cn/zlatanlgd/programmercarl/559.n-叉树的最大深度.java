import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N 叉树的最大深度
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    // public int maxDepth(Node root) {
    // if (root==null) {
    // return 0;
    // }
    // int depth = 0;
    // Queue<Node> que= new LinkedList<>();
    // que.offer(root);
    // while (!que.isEmpty()) {
    // depth++;
    // int len = que.size();
    // while (len>0) {
    // Node node = que.poll();
    // for (int i = 0; i < node.children.size(); i++) {
    // if (node.children.get(i) != null) {
    // que.offer(node.children.get(i));
    // }
    // }
    // len--;
    // }
    // }
    // return depth;
    // }

    // 递归
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        if (root.children != null) {
            for (Node node : root.children) {
                depth = Math.max(depth, maxDepth(node));
            }
        }
        return depth + 1;
    }
}
// @lc code=end
