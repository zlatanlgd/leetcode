import java.util.Queue;

import com.sun.org.apache.bcel.internal.classfile.Node;

/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
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
       Queue<Node> que = new LinkedList<>();
       if (root != null) {
           que.add(root);
       }     
       while (!que.isEmpty()) {
            int size  = que.size();
            Node node = null;
            Node nodePre = null;
            
            for (int i = 0; i < size; i++) {
                if (i==0) {
                    nodePre = que.poll();
                    node = nodePre;
                }else{
                    node = que.poll();
                    nodePre.next = node;
                    nodePre = nodePre.next;
                }
                if (node.left!=null) {
                    que.add(node.left);
                }
                if (node.right!=null) {
                    que.add(node.right);
                }
                
            }
            nodePre.next = null;
       }
       return root;
    }
}
// @lc code=end

