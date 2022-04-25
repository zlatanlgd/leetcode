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
        //中序遍歷
        if(pRootOfTree == null)
            return null;
        Stack<TreeNode> stack =new Stack();
        TreeNode cur= pRootOfTree;
        TreeNode pre = null;
        TreeNode root = null;
        boolean isFirst = true;
        while(cur != null || !stack.isEmpty()){
            //左下
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
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
            cur = cur.right;
        }
        return root;
    }
}