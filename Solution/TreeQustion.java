package Solution;

import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
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

    public int maxval =-1;
    public int maxAncestorDiff2(TreeNode root) {
        
        maxAncestorDiff(root,root);
        return maxval;
    }
    /*
     * 1026. Maximum Difference Between Node and Ancestor

    Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

    A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.


     */
    /*
     * boot force
     */
    public void maxAncestorDiff(TreeNode root,TreeNode child) {
        if(child==null){
            return;
        }
        
        maxval =Math.max(maxval,Math.abs(root.val-child.val));
        maxAncestorDiff(root,child.left);
        maxAncestorDiff(root,child.right);
        maxAncestorDiff(child,child.left);
        maxAncestorDiff(child,child.right);
    }
        /*
        * optimize
        */

        public int maxAncestorDiff(TreeNode root) {
            return maxAncestorDiff(root, root.val, root.val);
        }
    
        public int maxAncestorDiff(TreeNode node, int maxVal, int minVal) {
            if (node == null) {
                return maxVal - minVal;
            }
    
            // Update max and min values along the path
            maxVal = Math.max(maxVal, node.val);
            minVal = Math.min(minVal, node.val);
    
            // Recur for left and right children
            int leftDiff = maxAncestorDiff(node.left, maxVal, minVal);
            int rightDiff = maxAncestorDiff(node.right, maxVal, minVal);
            
            // Return the maximum difference found
            return Math.max(leftDiff, rightDiff);
        }

        /*
         1302. Deepest Leaves Sum

            Given the root of a binary tree, return the sum of values of its deepest leaves.
         */



        public int deepestLeavesSum(TreeNode root) {
            List<Integer> sum =new ArrayList<>();
            deepestLeavesSum(root,sum,0);
            return sum.get(sum.size()-1);
        }
    
        public void deepestLeavesSum(TreeNode root,List<Integer> sum,int level) {
                if(root==null){
                    return;
                }
    
                if(sum.size()<=level){
                    sum.add(root.val);
                }else{
                    int sum1 =sum.get(level);
                    sum1=sum1+root.val;
                    sum.set(level, sum1);
                }
                
                deepestLeavesSum(root.left,sum,level+1);
                deepestLeavesSum(root.right,sum,level+1);
                
            }

    /*
     1448. Count Good Nodes in Binary Tree

        Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

        Return the number of good nodes in the binary tree.
     */

    public int count =0;
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        goodNodes(root,root.val);
        return count;
    }

    public void goodNodes(TreeNode root, int pre) {
        if(root==null){
            return;
        }
        if(root.val>=pre){
            count++;
        }
        goodNodes(root.left,Math.max(pre, root.val));
        goodNodes(root.right,Math.max(pre, root.val));
    }

    /*
     530. Minimum Absolute Difference in BST

    Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
     */
    public int mindef=Integer.MAX_VALUE;
    public Integer pre=null;

    public int getMinimumDifference(TreeNode root) {
        getMinimumDifference2(root);
    
        return mindef;
    }

    public void getMinimumDifference2(TreeNode root) {
        if(root==null){
            return;
        }
        getMinimumDifference2(root.left);

        if(pre !=null){
            mindef=Math.min(mindef,(root.val-pre));
        }
        pre =root.val;
        getMinimumDifference2(root.right);
    }

    /*
     2265. Count Nodes Equal to Average of Subtree

        Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.

        Note:

        The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
        A subtree of root is a tree consisting of root and all of its descendants.
     */

    public int averageOfSubtree(TreeNode root) {
        int[] arr =averageOfSubtree2(root);
        return arr[0];
    }

    public int[] averageOfSubtree2(TreeNode root) {
        if(root==null){
            return new int[]{0,0,0};
        }
        int [] arrleft =averageOfSubtree2(root.left);
        int [] arrright =averageOfSubtree2(root.right);
        int sum =root.val+arrleft[1]+arrright[1];
        int count =1+arrleft[2]+arrright[2];

        int validNodeCount = arrleft[0] + arrright[0];
        // Check if the current node satisfies the condition.
        if (root.val == sum / count) {
            validNodeCount++;
        }
        return new int[]{validNodeCount,sum,count};
    }

    /*
     111. Minimum Depth of Binary Tree

        Given a binary tree, find its minimum depth.

        The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

        Note: A leaf is a node with no children.
     */

    public int minDepth(TreeNode root) {
        if(root==null){
           return 0;
        }
        if (root.left == null) {
             return 1 + minDepth(root.right);
         }
         if (root.right == null) {
             return 1 + minDepth(root.left);
         }
         
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
     }

     /*
      129. Sum Root to Leaf Numbers

        You are given the root of a binary tree containing digits from 0 to 9 only.

        Each root-to-leaf path in the tree represents a number.

        For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
        Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

        A leaf node is a node with no children.
      */


     public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
    }

    public int sumNumbers(TreeNode root,int num) {
        if(root==null){
            return 0;
        }
        num =num*10+root.val;
        if(root.left ==null && root.right ==null){
            return num;
        }
        int left =sumNumbers(root.left,num);
        int right =sumNumbers(root.right,num);
        return left+right;
    }

    /*
     257. Binary Tree Paths

        Given the root of a binary tree, return all root-to-leaf paths in any order.

        A leaf is a node with no children.
     */

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans =new ArrayList<>();
        String st ="";
        binaryTreePaths(root,ans,st);
        return ans;
    }
    public void binaryTreePaths(TreeNode root,List<String> ans, String st) {
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right==null){
           st=st+root.val;
           ans.add(st);
           return;
        }
        st =st+root.val+"->";
        binaryTreePaths(root.left,ans,st);
        binaryTreePaths(root.right,ans,st);
    }
}
