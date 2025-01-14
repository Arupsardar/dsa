package Solution;

import java.util.*;

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
}
