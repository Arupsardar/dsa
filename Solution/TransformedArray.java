package Solution;

public class TransformedArray {
    public int[] constructTransformedArray(int[] nums) {
        int n =nums.length;
        int[] rest = new int[n];
        for(int i=0;i<n;i++){
             if(nums[i]>0){
                rest[i]=nums[(i+nums[i])%n];
             }else{
                rest[i]=nums[(i-(Math.abs(nums[i])%n)+n)%n];
             }
             
        }
        return rest;
        
    }
}
