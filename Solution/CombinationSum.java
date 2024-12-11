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
}
