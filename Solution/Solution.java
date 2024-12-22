package Solution;

public class Solution {
    /*
     * 3396. Minimum Number of Operations to Make Elements in Array Distinct
     * 
     * You are given an integer array nums. You need to ensure that the elements in the array are distinct. To achieve this, you can perform the following operation any number of times:

    Remove 3 elements from the beginning of the array. If the array has fewer than 3 elements, remove all remaining elements.
    Note that an empty array is considered to have distinct elements. Return the minimum number of operations needed to make the elements in the array distinct.
     */

    public int minimumOperations(int[] nums) {
        int count =0;
        for(int i=0;i<nums.length;i=i+3){
            HashSet<Integer> set =new HashSet<>();
            for(int j=i;j<nums.length;j++){
                if(set.contains(nums[j])){
                    count++;
                    break;
                }
                set.add(nums[i]);
            }
            
        }
        return count;
    }
}
