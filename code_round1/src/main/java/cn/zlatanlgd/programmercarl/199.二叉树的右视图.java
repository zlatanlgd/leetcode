import java.rmi.server.RemoteStub;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root ==null) {
            return list; 
        } 
        que.offer(root);
        while (!que.isEmpty()) {
            int len = que.size();
            while (len>0) {
                TreeNode tempNode = que.poll();
                if (tempNode.left!=null) {
                    que.add(tempNode.left);
                }
                if (tempNode.right!=null){
                    que.add(tempNode.right);
                }
                len--;
                if (len==0) {
                    list.add(tempNode.val);
                }
            }
        }
        return list;
}
}
// @lc code=end
