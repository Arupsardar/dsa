package Solution;

import java.util.*;

import strucher.TreeNode;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        preorderTraversal2(root,ans);
        return ans;
    }

    public void preorderTraversal2(TreeNode root,List<Integer> ans) {
        if(root==null){
            return;
        }
        ans.add(root.val);
        preorderTraversal2(root.left,ans);
        preorderTraversal2(root.right,ans);
    }
}
