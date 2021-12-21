import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.xml.soap.Node;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list= new ArrayList<>();
        Deque<Node> que = new LinkedList<>();
        
        if (root == null) {
            return list; 
        }

        que.offerLast(root);
        while (!que.isEmpty()) {
            int levelSize= que.size();
            List<Integer> levelList = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                Node poll = que.pollFirst();
                levelList.add(poll.val);
                List<Node> children = poll.children;
                if (children==null || children.size()==0) {
                    continue; 
                }
                for (Node node : children) {
                    if (node != null) {
                        que.offerLast(node);
                    }
                }

            }
            list.add(levelList);
        }
        return list;
    }
}
// @lc code=end

