package Solution;

import java.util.*;

import strucher.TreeNode;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>  ans =new ArrayList<>();
        inorderTraversal2(root,ans);
        return ans;
        
    }
    public void inorderTraversal2(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        inorderTraversal2(root.left,ans);
        ans.add(root.val);
        inorderTraversal2(root.right,ans);
    }
}
