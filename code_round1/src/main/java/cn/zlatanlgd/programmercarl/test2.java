import java.util.*;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        Stack<TreeNode> stack = new Stack();
        TreeNode pre = null;
        TreeNode cur = pRootOfTree;
        TreeNode root = null;
        boolean isFirst = true;
        stack.push(cur);
        while (cur != null || !stack.isEmpty()) {
            //left
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //mid
            cur = stack.pop();
            if(isFirst){
                root = cur;
                pre = root;
                isFirst = false;
            }else{
                pre.right = cur;
                cur.left = pre;
                pre = cur;
            }
            //right
            cur = cur.right;
        }
        return root;
    }
}