package Solution;

import java.util.*;
import java.util.stream.Collectors;

import strucher.TreeNode;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans =new ArrayList();
        List<Integer> arr=new ArrayList<>();
        combinationSum2(0,candidates, target, ans, arr);
       

        return ans;
        
    }


    public static void combinationSum2(int i,int [] candidates,int reminder,List<List<Integer>> ans,List<Integer> arr){
        if(i==candidates.length){
            if(reminder==0){
                ans.add(new ArrayList<>(arr));
            }
            return;
        }
        
        if(candidates[i]<reminder){
            arr.add(candidates[i]);
            combinationSum2(i,candidates,reminder-candidates[i],ans,arr);
            arr.remove(arr.size()-1);
        }
        combinationSum2(i+1,candidates,reminder,ans,arr);
    }

    /*

    40. Combination Sum II

    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

        Each number in candidates may only be used once in the combination.

        Note: The solution set must not contain duplicate combinations.
     
     */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> ans =new HashSet<>();
        List<Integer> arr=new ArrayList<>();
         combinationSum2(0,candidates, target, ans, arr);
         List<List<Integer>> ans2=new ArrayList<>(ans);
         return ans2;
     }
 
     public static void combinationSum2(int i,int [] candidates,int reminder,HashSet<List<Integer>> ans,List<Integer> arr){
         if(i==candidates.length){
             if(reminder==0){
                 ans.add(new ArrayList<>(arr));
             }
             return;
         }
         
         if(candidates[i]<=reminder){
             arr.add(candidates[i]);
             combinationSum2(i,candidates,reminder-candidates[i],ans,arr);
             arr.remove(arr.size()-1);
         }
         combinationSum2(i+1,candidates,reminder,ans,arr);
     }

     public List<List<Integer>> combinationSumop(int[] candidates, int target) {
        List<List<Integer>> ans =new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum3(0,candidates, target, arr,ans);
        List<List<Integer>> ans2=new ArrayList<>(ans);
        return ans2;
    }

    private void combinationSum3(int index, int[] candidates, int target, List<Integer> currentCombination, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(currentCombination)); // Add a copy of the current combination
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Skip duplicate elements
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break; // No need to proceed further as the array is sorted
            }

            currentCombination.add(candidates[i]);
            combinationSum3(i + 1, candidates, target - candidates[i], currentCombination, ans);
            currentCombination.remove(currentCombination.size() - 1); // Backtrack
        }
    }

    /*
     17. Letter Combinations of a Phone Number

        Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

        A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     */

    public List<String> letterCombinations(String digits) {
        HashMap<Integer,List<Character>> map =new HashMap<>();
        List<Character> chararr =new ArrayList<>();
        chararr.add('a');
        chararr.add('b');
        chararr.add('c');
        map.put(2,new ArrayList<>(chararr));
        chararr.clear();
        chararr.add('d');
        chararr.add('e');
        chararr.add('f');
        map.put(3, new ArrayList<>(chararr));
        chararr.clear();
        
        chararr.add('g');
        chararr.add('h');
        chararr.add('i');
        map.put(4, new ArrayList<>(chararr));
        chararr.clear();

        // Mapping for '5'
        chararr.add('j');
        chararr.add('k');
        chararr.add('l');
        map.put(5, new ArrayList<>(chararr));
        chararr.clear();

        // Mapping for '6'
        chararr.add('m');
        chararr.add('n');
        chararr.add('o');
        map.put(6, new ArrayList<>(chararr));
        chararr.clear();

        // Mapping for '7'
        chararr.add('p');
        chararr.add('q');
        chararr.add('r');
        chararr.add('s');
        map.put(7, new ArrayList<>(chararr));
        chararr.clear();

        // Mapping for '8'
        chararr.add('t');
        chararr.add('u');
        chararr.add('v');
        map.put(8, new ArrayList<>(chararr));
        chararr.clear();

        // Mapping for '9'
        chararr.add('w');
        chararr.add('x');
        chararr.add('y');
        chararr.add('z');
        map.put(9, new ArrayList<>(chararr));
        chararr.clear();

        List<String>  ans =new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        List<Character> arr=new ArrayList<>();
        letterCombinations(digits,0,arr,ans,map);
        
        return ans;
    }

    public void letterCombinations(String digits,int index,List<Character> charList,List<String> ans,HashMap<Integer,List<Character>> map ){
        if(digits.length()==index){
            String result = charList.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining());
            ans.add(result);
            return;
        }
        int dig =digits.charAt(index)-'0';
        List<Character> charlist =map.get(dig);
        for(int i=0;i<charlist.size();i++){
            charList.add(charlist.get(i));
            letterCombinations(digits,index+1,charList,ans,map);
            charList.remove(charList.size()-1);
        }

    }
    /*
     public static HashMap<Integer,String> map =new HashMap<>();

    public static List<String> letterCombinations(String digits) {
        
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jml");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        System.out.println(map);

        List<String>  ans =new ArrayList<>();
        List<Character> arr=new ArrayList<>();
        letterCombinations(digits,0,arr,ans);
        return ans;
        
    }

    public static void letterCombinations(String digits,int index,List<Character> charList,List<String> ans){
        if(digits.length()==index){
            String result = charList.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining());
            ans.add(result);
            return;
        }
        
        int dig =digits.charAt(index)-'0';
        
        String arr=map.get(dig);
        char [] charlist =arr.toCharArray();
        for(int i=0;i<charlist.length;i++){
            charList.add(charlist[i]);
            letterCombinations(digits,index+1,charList,ans);
            charList.remove(charList.size()-1);
        }

    }
     */

     /*

     77. Combinations
      Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

        You may return the answer in any order.
      */

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans =new ArrayList<>();
        List<Integer> arr =new ArrayList<>();
        combine(n,k,1,ans,arr);
        return ans;
    }
    public void combine(int n, int k,int ind,List<List<Integer>> ans,List<Integer> arr) {
       if(arr.size()==k){
            ans.add(new ArrayList<>(arr));
            return;
       }
       for(int i=ind;i<=n;i++){
           arr.add(i);
           combine(n,k,i+1,ans,arr);
           arr.remove(arr.size()-1);

       }

        
    }
    /*
     113. Path Sum II

    Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

    A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
     */

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> ans =new ArrayList<>();
        List<Integer> arr =new ArrayList<>();
        pathSum(root,targetSum,ans,arr);
        List<List<Integer>> ans2 =new ArrayList<>(ans);
        return ans2;
    }

    public void pathSum(TreeNode root, int targetSum,List<List<Integer>> ans,List<Integer> arr) {
        if(root==null){
            
            return;
        }
        arr.add(root.val);

        if (root.left == null && root.right == null && targetSum == root.val) {
            ans.add(new ArrayList<>(arr)); 
        }
        pathSum(root.left,targetSum-root.val,ans,arr);
        
        pathSum(root.right,targetSum-root.val,ans,arr);
        arr.remove(arr.size()-1);
    }

    /*
     437. Path Sum III

        Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

        The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
     */

    public int pathSumiii(TreeNode root, int targetSum) {
        // Use a HashMap to store prefix sums and their frequencies
        HashMap<Long, Integer> prefixSumMap = new HashMap<>();
        // Initialize with prefix sum 0 to handle paths starting from the root
        prefixSumMap.put(0L, 1);
        return dfs(root, 0, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, HashMap<Long, Integer> prefixSumMap) {
        if (node == null) {
            return 0;
        }

        // Add the current node's value to the cumulative sum
        currentSum += node.val;

        // Check how many paths ending at this node have a sum equal to targetSum
        int count = prefixSumMap.getOrDefault(currentSum - targetSum, 0);

        // Add the current sum to the map
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);

        // Recur for left and right subtrees
        count += dfs(node.left, currentSum, targetSum, prefixSumMap);
        count += dfs(node.right, currentSum, targetSum, prefixSumMap);

        // Remove the current sum from the map (backtrack)
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);

        return count;
    }
}
