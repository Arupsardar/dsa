package Solution;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans =new ArrayList<>();
        List<Integer> arr =new ArrayList<>();
        creatsubset(nums,ans,0,arr);
        return ans;
        
    }

    public void creatsubset(int[] nums, List<List<Integer>> ans,int ind, List<Integer> arr){
        System.out.println(arr);
        if(ind==nums.length){
            ans.add(arr);
            return;
        }
        
            
            arr.add(nums[ind]);
            creatsubset(nums,ans,ind+1,arr);
            arr.remove(arr.size()-1);
            creatsubset(nums,ans,ind+1,arr);
            
        
    }
}
