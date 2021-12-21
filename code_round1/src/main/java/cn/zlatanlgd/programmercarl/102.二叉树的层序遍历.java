import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

// @lc code=start

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
     
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        if (root==null) {
            return resList; 
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        
        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = que.size(); 
            // 使用固定len，而不是que.size,quesize会不断变化
            while (len>0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) {
                    que.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right);
                }
                len--;
            }
            resList.add(itemList);
        }
        return resList;
    }
}
// @lc code=end

