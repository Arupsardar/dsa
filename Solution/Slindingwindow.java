package Solution;

import java.util.HashSet;

public class Slindingwindow {

    /*
       219. Contains Duplicate II

        Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0){
            return false;
        }
       int start =0;
        
        HashSet<Integer> set =new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            if(set.size()>=k){
                set.remove(nums[start]);
                start++;
            }
            set.add(nums[i]);
            
        }
        
        return false;
        
        


        
    }
}
