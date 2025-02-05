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

    
    /*
     45. Jump Game II

        You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

        Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

        0 <= j <= nums[i] and
        i + j < n
        Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
     */

    public int jumpboot(int[] nums) {
        return jump(nums,0,0);
     }
 
     public int jump(int[] nums,int jump,int count) {
         if(jump>=nums.length-1){
             return count;
         }
         int min=Integer.MAX_VALUE;
         for(int i=1;i<=nums[jump];i++){
             int num= jump(nums,jump+i,count+1);
             min= Math.min(min,num);
         }
         return min;
     }


     public int jump(int[] nums) {
        int jump =0;
        int l =0;
        int r=0;
        for(int i=0;i<nums.length-1;i++){
            l=Math.max(l,i+nums[i]);
            if(i==r){
              jump++;
              r=l;
            }
        }
        return jump;
     }
}
