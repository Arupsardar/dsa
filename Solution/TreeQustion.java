package Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import strucher.Node;
import strucher.TreeNode;

public class TreeQustion {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> levelSums = new ArrayList<>();
        levelWiseSum(root, 0, levelSums);

        // Sort the level sums in descending order
        Collections.sort(levelSums, Collections.reverseOrder());

        // If k is greater than the number of levels, return -1
        if (k > levelSums.size()) {
            return -1;
        }

        // Return the k-th largest sum
        return levelSums.get(k - 1);

        
    }

    public void levelWiseSum(TreeNode root, int level, List<Long> levelSums) {
        if (root == null) {
            return;
        }

        // Expand the list if the current level does not exist in the list
        if (level == levelSums.size()) {
            levelSums.add(0L);
        }

        // Update the sum for the current level
        levelSums.set(level, levelSums.get(level) + root.val);

        // Recur for left and right subtrees
        levelWiseSum(root.left, level + 1, levelSums);
        levelWiseSum(root.right, level + 1, levelSums);
    }

    /*
     * 
     589. N-ary Tree Preorder Traversal
        Solved
        Easy
        Topics
        Companies
        Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

        Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
     */

    public List<Integer> preorder(Node root) {
        List<Integer> arr =new ArrayList<>();
        preorder(root,arr);
        return arr;

    }
    public void preorder(Node root,List<Integer> arr) {
        if(root==null){
            return;
        }
        arr.add(root.val);
        for(int i=0;i<root.children.size();i++){
            preorder(root.children.get(i),arr);
        }

    }

    /*
     * 
     429. N-ary Tree Level Order Traversal
        Solved
        Medium
        Topics
        Companies
        Given an n-ary tree, return the level order traversal of its nodes' values.

        Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
     */


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>  ans =new ArrayList<>();
        levelOrder(root,0,ans);
        return ans;
    }

    public void levelOrder(Node root,int level,List<List<Integer>>  ans) {
        if(root==null){
            return;
        }
        if(ans.size()==level){
            ans.add(new ArrayList<>());
        }
        List<Integer> arr =ans.get(level);
        arr.add(root.val);
        ans.set(level,arr);
        for(int i=0;i<root.children.size();i++){
            levelOrder(root.children.get(i),level+1,ans);
        }
        
        
    }


    /*
     590. N-ary Tree Postorder Traversal
            Solved
            Easy
            Topics
            Companies
            Given the root of an n-ary tree, return the postorder traversal of its nodes' values.

            Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
     */

    public List<Integer> postorder(Node root) {
        List<Integer> ans =new ArrayList<>();
        postorder(root,ans);
        return ans;
    }

    public void postorder(Node root,List<Integer> ans) {
        
        if(root==null){
            return;
        }
        for(int i=0;i<root.children.size();i++){
           postorder(root.children.get(i),ans);
        }
        ans.add(root.val);
        
    }

    /*
     145. Binary Tree Postorder Traversal
        Solved
        Easy
        Topics
        Companies
        Given the root of a binary tree, return the postorder traversal of its nodes' values.
     */

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans =new ArrayList<>();
        postorderTraversal(root,ans);
        return ans; 
     }
 
     public void postorderTraversal(TreeNode root,List<Integer> ans) {
         if(root==null){
             return;
         }
         postorderTraversal(root.left,ans);
         postorderTraversal(root.right,ans);
         ans.add(root.val);
 
 
     }


     /*
      100. Same Tree

        Given the roots of two binary trees p and q, write a function to check if they are the same or not.

        Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
      */
        public boolean isSameTree(TreeNode p, TreeNode q) {
           return isSameTree2(p,q);
        }
    
        public boolean isSameTree2(TreeNode p, TreeNode q) {
            if(p==null && q==null){
                return true;
            }
            if(p==null && q  !=null || q==null && p!=null){
                return false;
            }
            if(q.val !=p.val){
                return false;
            }
            return isSameTree2(p.left,q.left)&& isSameTree2(p.right,q.right);
        }
}
