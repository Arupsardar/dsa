package Solution;

public class CountSubarraysofLengthThreeWithaCondition {
    public int countSubarrays(int[] nums) {
        int count =0;

        for(int i=0;i<=nums.length-3;i++){
            if(2*(nums[i]+nums[i+2])==nums[i+1]){
                count++;
            }
        }
        return count;
        
    }
}
