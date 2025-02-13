package Solution;

import java.util.ArrayList;

import java.util.List;

public class Permutations {

    /*
     * Approach - 1
     * TC -(O(!n))
     * SC -O(n)
     */

    public void resusion(int[] nums,List<List<Integer>> ans, List<Integer> ds, boolean [] feq){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!feq[i]){
                feq[i]=true;
                ds.add(nums[i]);
                resusion(nums, ans, ds, feq);
                feq[i]=false;
                ds.remove(ds.size()-1);
            }
        }
    }

    public void resusion2(int[] nums,List<List<Integer>> ans, int ind){
        if(ind==nums.length){
            List<Integer> ds =new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(ds);
            return;
        }

        for(int i=ind;i<nums.length;i++){
            int trmp =nums[ind];
            nums[ind]=nums[i];
            nums[i]=trmp;
            resusion2(nums,ans,ind+1);
            trmp =nums[ind];
            nums[ind]=nums[i];
            nums[i]=trmp;

        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans =new ArrayList<>();
        List<Integer> ds =new ArrayList<>();
        boolean [] feq =new boolean[nums.length];
        resusion(nums, ans, ds, feq);
        return ans;
    }
}
