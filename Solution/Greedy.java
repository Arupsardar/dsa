package Solution;

public class Greedy {
    /*  
     55. Jump Game

        You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

        Return true if you can reach the last index, or false otherwise.
     */
    public boolean canJump(int[] nums) {
        int max_ind=0;
        for(int i=0;i<nums.length;i++){
            if(i>max_ind){
                return false;
            }
            max_ind=Math.max(max_ind,i+nums[i]);

        }
        return true;
    }
}
